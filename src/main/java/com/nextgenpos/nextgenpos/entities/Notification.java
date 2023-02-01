package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class  Notification {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    private Boolean read;

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    @Basic
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Notification(Date date, Boolean read, String content, String link) {
        this.date = date;
        this.read = read;
        this.content = content;
        this.link = link;
    }

    public Notification() {
    }
}
