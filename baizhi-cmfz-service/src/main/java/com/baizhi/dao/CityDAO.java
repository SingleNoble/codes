package com.baizhi.dao;

import com.baizhi.entity.City;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/11.
 */
public interface CityDAO extends BaseDAO<City> {
    List<City> selectByPid(String pid);
}
