package com.limyel.models;

import java.sql.Timestamp;

public class BaseModel {
    private int id;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created_at;
    }

    public void setCreated(Timestamp created) {
        this.created_at = created;
    }

    public Timestamp getUpdated() {
        return updated_at;
    }

    public void setUpdated(Timestamp updated) {
        this.updated_at = updated;
    }
}
