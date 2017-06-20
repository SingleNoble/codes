package com.baizhi.dao;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/11.
 */
public interface BaseDAO<T> {
    List<T> selectAll();
    T selectById(String id);
    void insert(T t);
    void delete(String id);
    void update(T t);
}
