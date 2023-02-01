package com.nextgenpos.nextgenpos.common;

import com.nextgenpos.nextgenpos.entities.User;

import java.util.Date;

public class NotificationDto {
    private Long idNotification;
    private Date date;
    private Boolean read;
    private String content;
    private String link;
    private User admin;

    public NotificationDto(Long idNotification, Date date, Boolean read, String content, String link, User admin) {
        this.idNotification = idNotification;
        this.date = date;
        this.read = read;
        this.content = content;
        this.link = link;
        this.admin = admin;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getRead() {
        return read;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }

    public User getAdmin() {
        return admin;
    }
}
