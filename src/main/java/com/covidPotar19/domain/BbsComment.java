package com.covidPotar19.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BbsComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bbs_comment_id")
    private Long id;

    private LocalDateTime date;
    private String content;
    private Status status;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bbs_id")
    private Bbs bbs;

    protected BbsComment() {
    }

    public BbsComment(String content, Bbs bbs, String username) {
        this.username = username;
        this.date = LocalDateTime.now();
        this.content = content;
        this.status = Status.NONE;
        if (bbs != null)
            addComment(bbs);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public Bbs getBbs() {
        return bbs;
    }

    public void setBbs(Bbs bbs) {
        this.bbs = bbs;
    }

    public void addComment(Bbs bbs) {
        this.bbs = bbs;
        bbs.getComments().add(this);
    }

}
