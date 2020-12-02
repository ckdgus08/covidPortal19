package com.covidPotar19.domain;

import com.covidPotar19.Member.MemberDAO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bbs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_id")
    private Long id;
    private String title;
    private LocalDateTime date;
    private String content;
    private Status status;
    private String username;
    private int count;

    @OneToMany(mappedBy = "bbs")
    private List<BbsComment> comments = new ArrayList<>();

    protected Bbs() {

    }

    public Bbs(String title, String content, String username) {
        this.username = username;
        this.title = title;
        this.date = LocalDateTime.now();
        this.content = content;
        this.status = Status.NONE;
        this.count = 0;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BbsComment> getComments() {
        return comments;
    }

    public void setComments(List<BbsComment> comments) {
        this.comments = comments;
    }
}
