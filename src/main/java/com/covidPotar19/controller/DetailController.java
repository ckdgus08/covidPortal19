package com.covidPotar19.controller;

import com.covidPotar19.domain.Detail;
import com.covidPotar19.service.DetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class DetailController extends HttpServlet {

    private final DetailService detailService;
    Logger logger = LoggerFactory.getLogger(DetailController.class);


    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping(value = "/detail")
    public String detail(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
                         @RequestParam(value = "end", required = false, defaultValue = "0") int end, Model model, HttpServletResponse response, HttpServletRequest request) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String today = (String.valueOf(localDateTime.getYear()));

        if(String.valueOf(localDateTime.getMonthValue()).length() == 1) {

            today += "0" + localDateTime.getMonthValue();

        } else {
            today += String.valueOf(localDateTime.getMonthValue());
        }

        if(String.valueOf(localDateTime.getDayOfMonth()).length() == 1) {

            today += "0" + localDateTime.getDayOfMonth();

        } else {
            today += String.valueOf(localDateTime.getDayOfMonth());
        }





        int startDay;
        int endDay;

        if (start != 0) {
            startDay = start;
        } else {
            startDay = Integer.parseInt(today);
        }

        if (end != 0) {
            endDay = end;
        } else {
            endDay = Integer.parseInt(today);
        }

        List<Detail> result = detailService.getDetail(startDay, endDay);

        request.setAttribute("result", result);

        return "detail";
    }

    @PostMapping(value = "/detail")
    public String postDetail(@RequestParam(value = "startYear", required = false, defaultValue = "2020") String startYear,
                             @RequestParam(value = "startMonth", required = false, defaultValue = "11") String startMonth,
                             @RequestParam(value = "startDay", required = false, defaultValue = "01") String startDay,
                             @RequestParam(value = "endYear", required = false, defaultValue = "2020") String endYear,
                             @RequestParam(value = "endMonth", required = false, defaultValue = "12") String endMonth,
                             @RequestParam(value = "endDay", required = false, defaultValue = "31") String endDay,

                             Model model, HttpServletResponse response, HttpServletRequest request) {

        String start = startYear + startMonth + startDay;
        String end = endYear + endMonth + endDay;

        List<Detail> result = detailService.getDetail(Integer.parseInt(start), Integer.parseInt(end));

        request.setAttribute("result", result);


        return "detail";
    }


}
