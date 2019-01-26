package com.boardinglabs.rumahcemara.outreach.models;

public class Chat {
    String message;
    String fromId;
    String createdAt;

    public Chat(String message, String fromId, String createdAt) {
        this.message = message;
        this.fromId = fromId;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
