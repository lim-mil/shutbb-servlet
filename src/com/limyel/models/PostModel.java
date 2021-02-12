package com.limyel.models;

public class PostModel extends BaseModel {
    private String title;
    private String content;
    private int userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int authorId) {
        this.userId = authorId;
    }
}
