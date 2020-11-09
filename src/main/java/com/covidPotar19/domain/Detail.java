package com.covidPotar19.domain;

import javax.persistence.*;

@Entity
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    int pageNo;
    int numOfRows;
    int startCreateDt;
    int endCreateDt;
}
