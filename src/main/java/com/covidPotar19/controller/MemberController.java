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

    @PostMapping("/member/joinAction")
    public String joinAction()
    {
        return "member/joinAction";
    }

    @PostMapping("/member/loginAction")
    public String loginAction()
    {
        return "member/loginAction";
    }

    @PostMapping("/member/logoutAction")
    public String logoutAction()
    {
        return "member/logoutAction.jsp";
    }

    @RequestMapping(value = "/index")
    public String indexController()
    {
        return "index";
    }

}
