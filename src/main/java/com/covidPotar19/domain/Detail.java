package com.covidPotar19.domain;

import javax.persistence.*;

@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int pageNo;
    private int numOfRows;
    private int startCreateDt;
    private int endCreateDt;
}
