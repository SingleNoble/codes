package com.cmfz.service.impl;

import com.cmfz.dao.MenuDao;
import com.cmfz.entity.Menu;
import com.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 梵辰 on 2017/6/13.
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    /*查询菜单*/
    public List<Menu> querryAll() {

        List<Menu> list = menuDao.selectByLev();

        return list;
    }
}
