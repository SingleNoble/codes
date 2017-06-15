package com.cmfz.service.impl;


import com.cmfz.dao.ChapterDao;
import com.cmfz.entity.Album;
import com.cmfz.entity.Chapter;
import com.cmfz.service.ChapterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    public Page<Chapter> queryByAlbumId(Integer page, Integer rows, Album album) {
        Page<Chapter> chapters = PageHelper.startPage(page, rows);
        chapterDao.selectByAlbumId(album.getId());
        return chapters;
    }

    public Chapter add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapterDao.insert(chapter);
        return chapter;
    }

    public void update(Chapter chapter) {
        chapterDao.update(chapter);
    }

    public Chapter queryById(Chapter chapter) {
        chapter = chapterDao.selectById(chapter.getId());
        return chapter;
    }

    public void drop(Chapter chapter) {
        chapterDao.delete(chapter.getId());
    }
}
