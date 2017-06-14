package com.cmfz.service;


import com.cmfz.entity.City;
import com.cmfz.entity.Province;

import java.util.List;


/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface CityService {

    /*根据code查看所有城市*/
    public List<City> queryByCode(String code);

}
