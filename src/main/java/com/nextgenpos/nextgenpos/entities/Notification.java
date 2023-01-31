package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Notification {
    private Long idNotification;
    private Date date;
    private Boolean Read;
    private String Content;
    private String Link;
    private User admin;

    @Id
    @GeneratedValue
    public Long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getRead() {
        return Read;
    }

    public void setRead(Boolean read) {
        Read = read;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
    @ManyToOne()
    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User user) {
        this.admin = user;
    }
}
