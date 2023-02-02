package com.nextgenpos.nextgenpos.common;

public class NotifyDto {
    private Long id;
    private String title;

    private String content;
    private String relativePath;

    public NotifyDto(Long id, String title, String content, String relativePath) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.relativePath = relativePath;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getRelativePath() {
        return relativePath;
    }
}
