package com.cmfz.service.impl;

import com.cmfz.dao.ManagerDAo;
import com.cmfz.entity.Manager;
import com.cmfz.service.ManagerService;
import com.cmfz.until.MD5Util;
import com.cmfz.until.SaltUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDAo managerDAo;

   /*登录*/
    public Manager querryByName(Manager manager) {

        Manager managerDB = managerDAo.selectByName(manager.getName());
        if(managerDB!=null){
            String md5Code = MD5Util.getMd5Code(manager.getPassword() + managerDB.getSalt());
            if(md5Code.equals(managerDB.getPassword())){
                return managerDB;
            }
            throw new RuntimeException("密码错误");
        }
        throw new RuntimeException("用户不存在");

    }

    /*添加管理员*/
    public void add(Manager manager) {
        manager.setId(UUID.randomUUID().toString());
        String salt = SaltUtil.getSalt(6);
        manager.setSalt(salt);
        String newpwd = MD5Util.getMd5Code(manager.getPassword() + salt);
        manager.setPassword(newpwd);
        managerDAo.insert(manager);

    }

    /*删除*/
    public void drop(String id) {
        managerDAo.delete(id);

    }

    /*查看所有管理员*/
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Manager> queryAll(Integer page, Integer rows) {
        Page<Manager> Managers = PageHelper.startPage(page, rows);
        managerDAo.selectAll();
        return Managers;
    }
}
