package com.cmfz.service;


import com.cmfz.entity.Rotation;
import com.github.pagehelper.Page;

import java.util.List;


/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface RotationService {


    /*添加图片*/
    public void add(Rotation rotation);

    /*查看所有图片*/
    public Page<Rotation> queryAll(Integer page, Integer rows);

    /*查询一个*/
    public Rotation queryById(String id);

    /*查询五条*/
    public Page<Rotation> queryFive(Integer page, Integer rows);

    /*删除图片*/
    public void delete(Rotation rotation);


}
