package com.cmfz.service;

import com.cmfz.entity.Master;
import com.github.pagehelper.Page;

public interface MasterService {


    /*查询所有上师*/
    Page<Master> queryAll(Integer page, Integer rows);

    void add(Master master);

    Master queryById(String id);

    void drop(Master master);

    void change(Master master);

}
