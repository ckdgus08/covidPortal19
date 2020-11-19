package com.covidPotar19.controller;

import com.covidPotar19.domain.Member;
import com.covidPotar19.domain.MemberForm;
import com.covidPotar19.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MemberController
{
    private final MemberService memberService;

    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    @GetMapping("/signInForm")
    public String signInForm()
    {
        return "signInForm";
    }

    @GetMapping("signUpForm")
    public String SignUpForm()
    {
        return "signUpForm";
    }

    @RequestMapping(value = "/index")
    public String indexController()
    {
        return "index";
    }

    @GetMapping(value = "/members/new")
    public String createForm(Model model)
    {
        model.addAttribute("memberForm", new MemberForm());
        return "signUpForm";
    }

    @PostMapping(value = "/members/new")
    public String joinMember(@Valid MemberForm memberForm, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "signUpForm";
        }

        Member member = new Member();

        member.setName(memberForm.getName());
        member.setUserId(memberForm.getUserId());
        member.setPassword(memberForm.getPassword());

        memberService.join(member);

        return "redirect:/";
    }

}
