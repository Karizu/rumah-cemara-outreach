package com.boardinglabs.rumahcemara.outreach.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ChatMessage extends RealmObject {
    String fromId;
    String message;
    String createdAt;
    String channel;
    @PrimaryKey
    String id;

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "fromId='" + fromId + '\'' +
                ", message='" + message + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", channel='" + channel + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
