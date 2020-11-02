package com.covidPotar19.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleMapController {

    @RequestMapping(value = "/googleMap")
    public String googleMapController() {

        return "googleMap";
    }
}
