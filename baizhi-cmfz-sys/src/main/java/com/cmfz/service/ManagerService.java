package com.cmfz.service;

import com.cmfz.entity.Manager;
import com.github.pagehelper.Page;

import java.util.List;


/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface ManagerService {

    /*根据管理员姓名查询*/
    public Manager querryByName(Manager manager);

    /*注册管理员*/
    public void add(Manager manager);

    /*删除*/
    public void drop(String id);

    /*查看所有管理员*/
    Page<Manager> queryAll(Integer page, Integer rows);

}
