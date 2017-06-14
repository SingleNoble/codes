package com.cmfz.dao;

import com.cmfz.entity.Manager;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface ManagerDAo extends BaseDao<Manager> {

    /*根据管理员姓名查询*/
    public Manager selectByName(String name);

}
