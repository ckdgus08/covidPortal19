package com.covidPotar19.controller;

import com.covidPotar19.domain.Detail;
import com.covidPotar19.repository.DetailRepository;
import com.covidPotar19.service.DetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class DetailController extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(GoogleMapServlet.class);

    private final DetailService detailService;


    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @RequestMapping(value = "/detail")
    public String detail(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
                         @RequestParam(value = "end", required = false, defaultValue = "0") int end, Model model, HttpServletResponse response, HttpServletRequest request) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String today = (String.valueOf(localDateTime.getYear()) + localDateTime.getMonthValue() + localDateTime.getDayOfMonth());

        int startDay;
        int endDay;

        if(start != 0) {
            startDay = start;
        } else {
            startDay = Integer.parseInt(today)-7;
        }

        if(end != 0) {
            endDay = end;
        } else {
            endDay = Integer.parseInt(today);
        }


        List<Detail> result = detailService.getDetail(startDay, endDay);

        request.setAttribute("result", result);


        return "detail";
    }


}
