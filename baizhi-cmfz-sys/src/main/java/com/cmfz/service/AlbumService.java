package com.cmfz.service;


import com.cmfz.entity.Album;
import com.github.pagehelper.Page;


public interface AlbumService {

    Page<Album> queryAll(Integer page, Integer rows);

    void add(Album album);

    void drop(Album album);

    void change(Album album);

    Album queryById(Album album);
}
