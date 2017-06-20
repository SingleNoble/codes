package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by wangqiang on 2017/6/11.
 */
public class Master implements Serializable {
    private String id;
    private String realname;
    private String nickname;
    private String imgpath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id='" + id + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }

    public Master(String id, String realname, String nickname, String imgpath) {
        this.id = id;
        this.realname = realname;
        this.nickname = nickname;
        this.imgpath = imgpath;
    }

    public Master() {
    }
}
