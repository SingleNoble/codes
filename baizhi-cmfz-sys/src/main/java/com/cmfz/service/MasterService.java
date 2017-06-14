package com.cmfz.service;

import com.cmfz.entity.Master;
import com.github.pagehelper.Page;



/**
 * Created by 梵辰 on 2017/6/13.
 */
public interface MasterService {

    /*添加上师*/
    public void add(Master master);

    /*查询所有上师*/
    Page<Master> queryAll(Integer page, Integer rows);

}
