package com.cmfz.entity;

import java.io.Serializable;

/**
 * 章节实体
 */
public class Chapter implements Serializable {

    private String id;
    private String oldName;
    private String newName;
    private String filePath;
    private String fileSize;
    private String contentType;
    private Album album;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", oldName='" + oldName + '\'' +
                ", newName='" + newName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }

    public Chapter(String id, String oldName, String newName, String filePath, String fileSize, String contentType, Album album) {
        this.id = id;
        this.oldName = oldName;
        this.newName = newName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.album = album;
    }

    public Chapter() {
    }
}
