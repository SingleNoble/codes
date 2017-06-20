package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangqiang on 2017/6/11.
 */
public class Province implements Serializable {
    private String id;
    private String code;
    private String name;

    private List<City> cities;

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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Province(String id, String code, String name, List<City> cities) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.cities = cities;
    }

    public Province() {
    }
}
