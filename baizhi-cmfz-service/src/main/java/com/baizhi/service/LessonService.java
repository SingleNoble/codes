package com.baizhi.service;

import com.baizhi.entity.Lesson;

import java.util.List;

/**
 * Created by wangqiang on 2017/6/15.
 */
public interface LessonService {
    List<Lesson> queryDefaultLesson();
    List<Lesson> queryByUserId(String id);
    void addLesson(Lesson lesson);
    void dropCustomLesson(Lesson lesson, String userId);
    Lesson queryById(String id);
}
