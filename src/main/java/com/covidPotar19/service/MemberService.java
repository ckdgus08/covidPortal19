package com.covidPotar19.service;

import com.covidPotar19.domain.Member;
import com.covidPotar19.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService
{
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long join(Member member) //회원 가입.
    {
        validateDuplicateMember(member); //회원가입시 아이디 중복 확인
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member)
    {
        List<Member> findMembers = memberRepository.findByUserId(member.getUserId());

        if(!findMembers.isEmpty())
        {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
}
