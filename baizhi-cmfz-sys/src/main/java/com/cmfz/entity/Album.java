package com.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/*
* 专辑
* */
public class Album implements Serializable {

    private String id;
    private String name;
    private String author;
    private String teller;
    private String num;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date createdate;
    private Integer grade;
    private String imgpath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTeller() {
        return teller;
    }

    public void setTeller(String teller) {
        this.teller = teller;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", teller='" + teller + '\'' +
                ", num='" + num + '\'' +
                ", content='" + content + '\'' +
                ", createdate=" + createdate +
                ", grade=" + grade +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }

    public Album(String id, String name, String author, String teller, String num, String content, Date createdate, Integer grade, String imgpath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.teller = teller;
        this.num = num;
        this.content = content;
        this.createdate = createdate;
        this.grade = grade;
        this.imgpath = imgpath;
    }

    public Album() {
    }
}
