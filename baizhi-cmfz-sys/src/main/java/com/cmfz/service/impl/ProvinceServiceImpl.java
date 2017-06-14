package com.cmfz.service.impl;

import com.cmfz.dao.ProvinceDao;
import com.cmfz.entity.Province;
import com.cmfz.service.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 梵辰 on 2017/6/13.
 */
@Service("province")
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao provinceDao;

    public List<Province> queryAll() {

        List<Province> list = provinceDao.selectAll();

        return list;
    }
}
