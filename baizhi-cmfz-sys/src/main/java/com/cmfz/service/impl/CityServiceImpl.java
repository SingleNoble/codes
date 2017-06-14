package com.cmfz.service.impl;

import com.cmfz.dao.CityDao;
import com.cmfz.entity.City;
import com.cmfz.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 梵辰 on 2017/6/13.
 */
@Service("city")
@Transactional
public class CityServiceImpl implements CityService {

    @Resource
    private CityDao cityDao;


    public List<City> queryByCode(String code) {
        List<City> cities = cityDao.selectByCode(code);

        return cities;
    }
}
