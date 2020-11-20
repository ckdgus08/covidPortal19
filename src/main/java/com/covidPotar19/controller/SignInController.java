package com.covidPotar19.servlet;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
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
