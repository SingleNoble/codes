package com.cmfz.service;


import com.cmfz.entity.Album;
import com.cmfz.entity.Chapter;
import com.github.pagehelper.Page;


public interface ChapterService {


    Page<Chapter> queryByAlbumId(Integer page, Integer rows, Album album);

    Chapter add(Chapter chapter);

    void update(Chapter chapter);

    Chapter queryById(Chapter chapter);

    void drop(Chapter chapter);
}
