package com.cmfz.service.impl;

import com.cmfz.dao.MasterDao;
import com.cmfz.entity.Master;
import com.cmfz.service.MasterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("masterService")
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao masterDao;


    public void add(Master master) {
        master.setId(UUID.randomUUID().toString());
        masterDao.insert(master);

    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<Master> queryAll(Integer page, Integer rows) {

        Page<Master> pages = PageHelper.startPage(page, rows);
        masterDao.selectAll();

        return pages;
    }


}
