package com.nextgenpos.nextgenpos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Notify {


    private Long id;
    private String title;

    private String content;
    private String relativePath;
    public void setId(Long id) {
        this.id = id;
    }

    public Notify(Long id, String title, String content, String relativePath) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.relativePath = relativePath;
    }

    public Notify() {
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
