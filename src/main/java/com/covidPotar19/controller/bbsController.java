package com.covidPotar19.controller;

import com.covidPotar19.domain.Bbs;
import com.covidPotar19.domain.BbsComment;
import com.covidPotar19.domain.Status;
import com.covidPotar19.dto.BbsDTO;
import com.covidPotar19.repository.BbsCommentRepository;
import com.covidPotar19.repository.BbsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
public class bbsController {

    private BbsRepository bbsRepository;
    private BbsCommentRepository bbsCommentRepository;

    public bbsController(BbsRepository bbsRepository, BbsCommentRepository bbsCommentRepository) {
        this.bbsRepository = bbsRepository;
        this.bbsCommentRepository = bbsCommentRepository;
    }

    @RequestMapping("bbs")
    public String bbs(Model model, HttpServletRequest request,
                      @RequestParam(value = "page", defaultValue = "1") int page) {

        //페이징
        PageRequest noticePageRequest = PageRequest.of(0, 3,
                Sort.by(Sort.Direction.DESC, "date"));

        Page<Bbs> notices = bbsRepository.findByStatus(Status.NOTICE, noticePageRequest);
        //dto 변환
        Page<BbsDTO> noticesDTO = notices.map(bbs -> new BbsDTO(bbs.getId(), bbs.getTitle(), bbs.getUsername()
                , bbs.getDate().format(DateTimeFormatter.ofPattern("MM-dd hh:mm")), bbs.getCount()));


        PageRequest normalPageRequest = PageRequest.of(page-1, 10,
                Sort.by(Sort.Direction.DESC, "date"));

        Page<Bbs> normals = bbsRepository.findByStatus(Status.NONE, normalPageRequest);
        Page<BbsDTO> normalsDTO = normals.map(bbs -> new BbsDTO(bbs.getId(), bbs.getTitle(), bbs.getUsername()
                , bbs.getDate().format(DateTimeFormatter.ofPattern("MM-dd hh:mm")), bbs.getCount()));


        model.addAttribute("notice", noticesDTO.getContent());
        model.addAttribute("normal", normalsDTO.getContent());
        request.setAttribute("total", normalsDTO.getTotalPages());
        request.setAttribute("page", page-1);

        return "bbs";
    }

    @RequestMapping("view")
    public String view(Model model, HttpServletRequest request,
                       @RequestParam(value = "bbsID", defaultValue = "1") Long id) {

        Optional<Bbs> bbs = bbsRepository.findById(id);

        bbs.get().setCount(bbs.get().getCount() + 1);

        model.addAttribute("bbs", bbs.get());

        return "view";
    }

    @RequestMapping("update")
    public String update(Model model, HttpServletRequest request,
                         @RequestParam(value = "bbsID", defaultValue = "1") Long id) {

        Optional<Bbs> bbs = bbsRepository.findById(id);

        model.addAttribute("bbs", bbs.get());

        return "update";
    }

    @RequestMapping("updateAction")
    public void updateAction(Model model, HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value = "bbsID", defaultValue = "1") Long id,
                               @RequestParam(value = "bbsTitle", defaultValue = "1") String title,
                               @RequestParam(value = "bbsContent", defaultValue = "1") String content) throws IOException {

        Optional<Bbs> bbs = bbsRepository.findById(id);
        bbs.get().setTitle(title);
        bbs.get().setContent(content);

        response.sendRedirect("view?bbsID="+id);
    }

    @RequestMapping("deleteAction")
    public void deleteAction(Model model, HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value = "bbsID", defaultValue = "1") Long id
                               ) throws IOException {
        Optional<Bbs> bbs = bbsRepository.findById(id);
        bbs.get().setStatus(Status.DEL);

        response.sendRedirect("bbs");
    }

    @RequestMapping("write")
    public String write(Model model, HttpServletRequest request) {

        return "write";
    }

    @RequestMapping("writeAction")
    public void writeAction(Model model, HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "bbsTitle", defaultValue = "1") String title,
                              @RequestParam(value = "bbsContent", defaultValue = "1") String content) throws IOException {

        Bbs bbs = new Bbs(title,content, (String) request.getSession().getAttribute("user_id"));
        List<BbsComment> list = new ArrayList<>();
        bbs.setComments(list);
        bbsRepository.save(bbs);

        response.sendRedirect("bbs");
    }

    @RequestMapping("commentAction")
    public void commentAction(Model model, HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "bbsID", defaultValue = "1") Long id,
                              @RequestParam(value = "content", defaultValue = "1") String content) throws IOException {

        Optional<Bbs> bbs = bbsRepository.findById(id);

        BbsComment comment = new BbsComment(content ,bbs.get(),(String) request.getSession().getAttribute("user_id"));
        bbsCommentRepository.save(comment);

        response.sendRedirect("view?bbsID="+id);
    }
}
