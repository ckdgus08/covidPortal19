package com.covidPotar19.controller;

import com.covidPotar19.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController
{
    private final MemberService memberService;

    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    @GetMapping(value = "/signInForm")
    public String signInForm() {
        return "signInForm";
    }

    @GetMapping(value = "/signUpForm")
    public String SignInController() {
        return "signInForm";
    }

    @RequestMapping(value = "/index")
    public String indexController() {
        return "index";
    }
}
