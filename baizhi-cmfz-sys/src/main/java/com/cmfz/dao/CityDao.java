package com.cmfz.dao;

import com.cmfz.entity.City;

import java.util.List;

/**
 * Created by 梵辰 on 2017/6/12.
 */
public interface CityDao extends BaseDao<City> {

    /*根据省份的code 查询城市*/

    public List<City> selectByCode(String code);

}
