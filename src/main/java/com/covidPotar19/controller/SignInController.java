package com.covidPotar19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController
{
    @RequestMapping(value = "/signInForm")
    public String SignInController()
    {
        return "signInForm";
    }
}
