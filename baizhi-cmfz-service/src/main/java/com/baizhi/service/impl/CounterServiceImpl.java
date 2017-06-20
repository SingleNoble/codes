package com.baizhi.service.impl;

import com.baizhi.dao.CounterDAO;
import com.baizhi.entity.Counter;
import com.baizhi.service.CounterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by wangqiang on 2017/6/16.
 */
@Service
public class CounterServiceImpl implements CounterService {
    @Resource
    private CounterDAO counterDAO;

    public void addCounter(Counter counter) {
        counter.setId(UUID.randomUUID().toString());
        counter.setCreatedate(new Date());
        counterDAO.insert(counter);
    }

    public List<Counter> queryByLidAndUserId(String lessonId,String userId) {
        List<Counter> counters = counterDAO.selectByLidAndUserId(lessonId,userId);
        return counters;
    }

    public void drop(String id) {
        counterDAO.delete(id);
    }

    public void changeNum(Counter counter) {
        counterDAO.updateNum(counter);
    }

}
