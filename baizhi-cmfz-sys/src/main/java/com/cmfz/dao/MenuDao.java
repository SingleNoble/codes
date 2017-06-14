package com.cmfz.dao;

import com.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface MenuDao extends BaseDao<Menu> {

    //查询所有一级菜单
    List<Menu> selectByLev();
    //查询一级菜单下的子菜单
    List<Menu> selectByParentId(String id);

}
