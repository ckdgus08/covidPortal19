package com.covidPotar19.repository;

import com.covidPotar19.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository
{
    @PersistenceContext
    private EntityManager em;

    public void save(Member member)
    {
        em.persist(member);
    }


}
