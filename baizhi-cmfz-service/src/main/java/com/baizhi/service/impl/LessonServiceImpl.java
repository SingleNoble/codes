package com.baizhi.service.impl;

import com.baizhi.dao.CounterDAO;
import com.baizhi.dao.LessonDAO;
import com.baizhi.entity.Counter;
import com.baizhi.entity.Lesson;
import com.baizhi.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by wangqiang on 2017/6/15.
 */
@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonDAO lessonDAO;
    @Autowired
    private CounterDAO counterDAO;

    public List<Lesson> queryDefaultLesson() {
        List<Lesson> lessons = lessonDAO.selectDefaultLesson();
        return lessons;
    }

    public List<Lesson> queryByUserId(String userId) {
        List<Lesson> lessons = lessonDAO.selectByUserId(userId);
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        lesson.setId(UUID.randomUUID().toString());
        lesson.setType("1");
        lessonDAO.insert(lesson);
    }

    public void dropCustomLesson(Lesson lesson,String userId) {
        List<Counter> counters = counterDAO.selectByLidAndUserId(lesson.getId(), userId);
        for (Counter counter : counters) {
            counterDAO.delete(counter.getId());
        }
        lessonDAO.delete(lesson.getId());
    }

    public Lesson queryById(String id) {
        Lesson lesson = lessonDAO.selectById(id);
        return lesson;
    }
}
