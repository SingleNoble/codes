package com.cmfz.dao;

import com.cmfz.entity.Rotation;

import java.util.List;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface RotationDao extends BaseDao<Rotation> {

    /*查询五条图片*/

    public List<Rotation> selectFive();
}
