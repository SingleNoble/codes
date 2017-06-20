package com.baizhi.dao;

import com.baizhi.entity.Lesson;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/11.
 */
public interface LessonDAO extends BaseDAO<Lesson>{
    List<Lesson> selectDefaultLesson();
    List<Lesson> selectByUserId(String id);
}
