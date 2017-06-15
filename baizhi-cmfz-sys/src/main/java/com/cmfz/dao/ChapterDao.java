package com.cmfz.dao;

import com.cmfz.entity.Chapter;

import java.util.List;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface ChapterDao extends BaseDao<Chapter> {

    /*根据专辑id查找章节*/

    List<Chapter> selectByAlbumId(String id);

}
