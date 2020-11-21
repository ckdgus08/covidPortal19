package com.covidPotar19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController
{
    @GetMapping("/member/join")
    public String join()
    {
        return "member/join";
    }

    @GetMapping("/member/login")
    public String login()
    {
        return "member/login";
    }

    @PostMapping("/member/join_Action")
    public String joinAction()
    {
        return "member/join_Action";
    }

    @PostMapping("/member/login_Action")
    public String loginAction()
    {
        return "member/login_Action";
    }

    @RequestMapping(value = "/index")
    public String indexController()
    {
        return "index";
    }

}
