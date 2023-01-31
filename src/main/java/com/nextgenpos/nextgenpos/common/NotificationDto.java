package com.nextgenpos.nextgenpos.common;

import com.nextgenpos.nextgenpos.entities.User;

import java.util.Date;

public class NotificationDto {
    private Long idNotification;
    private Date date;
    private Boolean Read;
    private String Content;
    private String Link;
    private User admin;

    public NotificationDto(Long idNotification, Date date, Boolean read, String content, String link, User admin) {
        this.idNotification = idNotification;
        this.date = date;
        Read = read;
        Content = content;
        Link = link;
        this.admin = admin;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getRead() {
        return Read;
    }

    public String getContent() {
        return Content;
    }

    public String getLink() {
        return Link;
    }

    public User getAdmin() {
        return admin;
    }
}
