package com.covidPotar19.service;

import com.covidPotar19.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService
{
    @Autowired
    MemberRepository memberRepository;


}
