package com.cmfz.entity;

import java.io.Serializable;

/**
 * 用户反馈
 */
public class Feedback implements Serializable {

    private String id;
    private String content;

    private User user;

    public Feedback() {
    }

    public Feedback(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }

}
