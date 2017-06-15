package com.cmfz.service.impl;


import com.cmfz.dao.AlbumDao;
import com.cmfz.entity.Album;
import com.cmfz.service.AlbumService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    public Page<Album> queryAll(Integer page, Integer rows) {
        Page<Album> albums = PageHelper.startPage(page, rows);
        albumDao.selectAll();
        return albums;
    }

    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        albumDao.insert(album);
    }

    public void drop(Album album) {

        albumDao.delete(album.getId());
    }

    public void change(Album album) {

        albumDao.update(album);
    }

    public Album queryById(Album album) {
        album = albumDao.selectById(album.getId());
        return album;
    }
}
