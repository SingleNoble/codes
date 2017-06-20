package com.cmfz.service;

import com.cmfz.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by 31677 on 2017/6/13.
 */
public interface UserService {
    //分页
    public Page<User> queryAllByPage(Integer page,Integer rows);
    //查所有
    public List<User> queryAll();
    //删除
    public void drop(String id);
}
