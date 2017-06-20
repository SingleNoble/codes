package com.baizhi.dao;

import com.baizhi.entity.Counter;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/11.
 */
public interface CounterDAO extends BaseDAO<Counter>{
    List<Counter> selectByLidAndUserId(@Param("lid") String lid, @Param("uid") String uid);
    void updateNum(Counter counter);
}
