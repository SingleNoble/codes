package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/11.
 */
public interface UserDAO extends BaseDAO<User>{
    User selectByPhone(String phone);
    void updateByPassword(User user);
    List<User> selectFiveUser();
}
