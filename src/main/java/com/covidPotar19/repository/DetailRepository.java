package com.covidPotar19.repository;

import com.covidPotar19.domain.Detail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class DetailRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int saveDetail(Detail detail) {
        try {
            em.persist(detail);
            return detail.getStateDt();
        } catch (EntityExistsException e) {
            return 0;
        }
    }

    public Detail getDetailFromStateDt(int stateDt) {
        try {
            return em.createQuery("select d from Detail d where d.stateDt = :stateDt", Detail.class)
                    .setParameter("stateDt", stateDt).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }


}
