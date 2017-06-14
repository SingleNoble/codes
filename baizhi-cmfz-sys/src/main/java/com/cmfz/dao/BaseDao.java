package com.cmfz.dao;

import java.util.List;

/**
 * 基础dao 接口
 */
public interface BaseDao<T> {


    public void insert(T t);

    public void update(T t);

    public void delete(String id);

    public T selectById(String id);

    public List<T> selectAll();
}
