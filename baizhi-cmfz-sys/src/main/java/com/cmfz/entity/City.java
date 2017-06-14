package com.cmfz.entity;

import java.io.Serializable;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public class City implements Serializable {

    private String id;
    private String code;
    private String name;

    private Province province;

    public City() {
    }

    public City(String id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", province=" + province +
                '}';
    }
}
