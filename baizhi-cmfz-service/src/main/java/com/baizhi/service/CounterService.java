package com.baizhi.service;

import com.baizhi.entity.Counter;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/15.
 */
public interface CounterService {
    void addCounter(Counter counter);
    List<Counter> queryByLidAndUserId(String lessonId, String userId);
    void drop(String id);
    void changeNum(Counter counter);
}
