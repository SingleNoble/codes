package com.cmfz.entity;

import java.io.Serializable;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public class Rotation implements Serializable {

    private String id;
    private String description;
    private String filepath;

    public Rotation() {
    }

    public Rotation(String id, String description, String filepath) {
        this.id = id;
        this.description = description;
        this.filepath = filepath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return "Rotation{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
