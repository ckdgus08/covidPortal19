package com.covidPotar19.repository;

import com.covidPotar19.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository
{
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member)
    {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id)
    {
        return em.find(Member.class, id);
    }

    public List<Member> findAll()
    {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByUserId(String userId)
    {
        return em.createQuery("select m from Member m where m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getResultList();
    }

}
