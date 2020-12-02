package com.covidPotar19.dto;

public class BbsCommentDTO {

    private String content;
    private String date;
    private String username;

    public BbsCommentDTO(String content, String date, String username) {
        this.content = content;
        this.date = date;
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
