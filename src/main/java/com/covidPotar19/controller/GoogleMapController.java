package com.covidPotar19.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleMapController {

    Logger logger = LoggerFactory.getLogger(GoogleMapController.class);

    @RequestMapping(value = "/googleMap")
    public String googleMapController() {

        logger.info("someone enter on googleMap site!!! ");

        return "googleMap";
    }
}
