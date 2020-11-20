package com.covidPotar19.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class SignInController {
    @RequestMapping(value = "/signInForm")
    public String SignInController() {
        return "signInForm";
    }

    @RequestMapping(value = "/index")
    public String indexController() {
        return "index";
    }
}
