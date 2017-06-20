package com.cmfz.service.impl;


import com.cmfz.dao.UserDao;
import com.cmfz.entity.User;
import com.cmfz.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by 31677 on 2017/6/13.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public Page<User> queryAllByPage(Integer page, Integer rows){
        Page<User> users = PageHelper.startPage(page, rows);
        userDao.selectAll();
        return users;
    }

    public List<User> queryAll() {

        return userDao.selectAll();
    }

    //删除
    public void drop(String id){
        userDao.delete(id);
    }
}
