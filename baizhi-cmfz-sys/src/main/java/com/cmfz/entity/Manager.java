package com.cmfz.entity;

import java.io.Serializable;

/**
 * 管理员实体
 */
public class Manager implements Serializable {

    private String id;
    private String name;
    private String password;
    private String salt;
    private String phone;

    public Manager() {
    }

    public Manager(String id, String name, String password, String salt, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
