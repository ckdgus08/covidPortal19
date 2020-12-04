package com.covidPotar19.service;

import com.covidPotar19.domain.Bbs;
import com.covidPotar19.domain.BbsComment;
import com.covidPotar19.domain.Detail;
import com.covidPotar19.repository.BbsRepository;
import com.covidPotar19.repository.DetailRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class DetailServiceTest {

    @Autowired
    EntityManager em;
    @Autowired
    private BbsRepository bbsRepository;
    @Autowired
    private DetailRepository detailRepository;

    @Test
    @DisplayName("게시판 테스트")
    void 게시판_테스트() throws Exception {
        //given
//        Bbs bbsA = new Bbs("게시글1", "ㅎㅇㅎㅇ", "123");
//        Bbs bbsB = new Bbs("게시글2", "ㅎㅇㅎㅇ", "123");
//        em.persist(bbsA);
//        em.persist(bbsB);
//
//        BbsComment comment1 = new BbsComment("댓글1", bbsA);
//        BbsComment comment2 = new BbsComment("댓글2", bbsA);
//        BbsComment comment3 = new BbsComment("댓글3", bbsB);
//        BbsComment comment4 = new BbsComment("댓글4", bbsB);
//
//        em.persist(comment1);
//        em.persist(comment2);
//        em.persist(comment3);
//        em.persist(comment4);
//
//        //when
//        // 초기화
//        em.flush();
//        em.clear();
//        //then
//        List<BbsComment> comments = em.createQuery("select c from BbsComment c", BbsComment.class)
//                .getResultList();
//
//        for (BbsComment comment : comments) {
//            System.out.println("comment = " + comment);
//            System.out.println("-> comment.bbs = " + comment.getBbs());
//        }

    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void sdfasd() throws Exception {
        //given

        DetailService detailService = new DetailService(detailRepository);

        List<Detail> result = detailService.getDetail(20201110, 20201120);

        System.out.println("result = " + result.size());


        //when

        //then

    }

}