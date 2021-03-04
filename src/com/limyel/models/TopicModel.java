package com.limyel.models;

public class TopicModel extends BaseModel {
    private String title;
    private String content;
    private int sectionId;
    private int userId;         // 贴主

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
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
