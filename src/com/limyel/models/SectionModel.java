package com.limyel.models;

public class SectionModel extends BaseModel {
    private String name;
    private int subjecctId;
    private int userId;         // 版主

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubjecctId() {
        return subjecctId;
    }

    public void setSubjecctId(int subjecctId) {
        this.subjecctId = subjecctId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
