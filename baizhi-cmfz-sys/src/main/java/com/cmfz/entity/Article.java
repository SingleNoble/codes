package com.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 31677 on 2017/6/14.
 */
public class Article implements Serializable {

    private String id;
    private String title;
    @JSONField(format = "yyyy-MM-dd HH:ss:mm")
    private Date createdate;
    private String type;
    private String content;

    private Master master;

    public Article() {
    }

    public Article(String id, String title, Date createdate, String type, String content, Master master) {
        this.id = id;
        this.title = title;
        this.createdate = createdate;
        this.type = type;
        this.content = content;
        this.master = master;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", createdate=" + createdate +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", master=" + master +
                '}';
    }
}
