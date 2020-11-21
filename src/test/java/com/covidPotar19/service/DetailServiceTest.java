package com.covidPotar19.service;

import com.covidPotar19.domain.Detail;
import com.covidPotar19.repository.DetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class DetailServiceTest {

    @Autowired private DetailRepository detailRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void sdfasd() throws Exception{
        //given

        DetailService detailService = new DetailService(detailRepository);

        List<Detail> result = detailService.getDetail(20201110, 20201120);

        System.out.println("result = " + result.size());


        //when
        
        //then
        
    }

}