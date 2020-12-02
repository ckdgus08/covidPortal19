package com.covidPotar19.dto;

public class BbsDTO {

    private Long id;
    private String title;
    private String date;
    private String username;
    private Integer count;

    public BbsDTO(Long id, String title, String username, String date, Integer count) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.username = username;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
