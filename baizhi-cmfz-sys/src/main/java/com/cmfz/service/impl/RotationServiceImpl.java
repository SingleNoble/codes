package com.cmfz.service.impl;

import com.cmfz.dao.RotationDao;
import com.cmfz.entity.Rotation;
import com.cmfz.service.RotationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.UUID;

@Service("rotation")
@Transactional
public class RotationServiceImpl implements RotationService {

    @Resource
    private RotationDao rotationDao;

    /*添加*/
    public void add(Rotation rotation) {
        rotation.setId(UUID.randomUUID().toString());

        rotationDao.insert(rotation);

    }


    public Page<Rotation> queryAll(Integer page, Integer rows) {

        Page<Rotation> pages = PageHelper.startPage(page, rows);
        rotationDao.selectAll();
        return pages;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Rotation queryById(String id) {
        Rotation rotation = rotationDao.selectById(id);
        return rotation;
    }

    public Page<Rotation> queryFive(Integer page, Integer rows) {
        Page<Rotation> pages = PageHelper.startPage(page, rows);
        rotationDao.selectFive();
        return pages;
    }


    public void delete(Rotation rotation) {
        rotationDao.delete(rotation.getId());

    }
}
