package com.covidPotar19.controller;

import com.covidPotar19.service.DetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class DetailController {

    Logger logger = LoggerFactory.getLogger(DetailController.class);

    private final DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @RequestMapping(value = "/detail")
    public String detailMapController(Model model, HttpServletRequest request) {

        String result = detailService.getJsonData(1, 10, 20201101, 20201103);

        request.setAttribute("result",result);
        return "detail";
    }
}
