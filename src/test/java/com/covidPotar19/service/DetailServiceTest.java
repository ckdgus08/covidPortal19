package com.covidPotar19.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetailServiceTest {
    
    @Test
    public void sdfasd() throws Exception{
        //given

        DetailService detailService = new DetailService();

        String result = detailService.getJsonData(1, 10, 20201101, 20201108);

        System.out.println(result);

        //when
        
        //then
        
    }

}