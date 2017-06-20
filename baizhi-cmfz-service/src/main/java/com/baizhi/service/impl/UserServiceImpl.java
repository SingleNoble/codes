package com.baizhi.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.cmfz.until.MD5Util;
import com.cmfz.until.SaltUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by wangqiang on 2017/6/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> queryFiveUser() {
        List<User> list = userDAO.selectFiveUser();
        return list;
    }

    public User login(User user) {
        User userDB = userDAO.selectByPhone(user.getPhone());
        if (userDB!=null){
            String md5 = MD5Util.getMd5Code(user.getPassword() + userDB.getSalt());
            if (StringUtils.equals(md5,userDB.getPassword())){
                return userDB;
            }
            throw new RuntimeException("密码错误");
        }
        throw new RuntimeException("用户不存在");
    }

    public void regist(User user) {
        user.setId(UUID.randomUUID().toString());
        String salt = SaltUtil.getSalt(6);
        user.setSalt(salt);
        user.setPassword(MD5Util.getMd5Code(user.getPassword()+salt));
        userDAO.insert(user);
    }

    public void changeUser(User user) {
        userDAO.update(user);
    }
}
