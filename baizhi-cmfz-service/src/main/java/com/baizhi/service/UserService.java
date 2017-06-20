package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/16.
 */
public interface UserService {
    List<User> queryFiveUser();
    User login(User user);
    void regist(User user);
    void changeUser(User user);
}
