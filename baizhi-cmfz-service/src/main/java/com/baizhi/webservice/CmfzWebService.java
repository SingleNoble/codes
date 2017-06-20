package com.baizhi.webservice;

import com.baizhi.entity.Counter;
import com.baizhi.entity.Lesson;
import com.baizhi.entity.User;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangqiang on 2017/6/16.
 */
@WebService
public interface CmfzWebService {
    //Lesson
    HashMap<String,Object> queryDefaultLesson();
    HashMap<String,Object> queryByUserId(String userId);
    HashMap<String,Object> addLesson(Lesson lesson, String userId);
    HashMap<String,Object> dropCustomLesson(Lesson lesson, String userId);

    //Counter
    HashMap<String,Object> addCounter(Counter counter, String userId);
    HashMap<String,Object> queryByLidAndUserId(String lessonId, String userId);
    HashMap<String,Object> dropCounter(String id);
    HashMap<String,Object> changeNum(Counter counter);

    //User
    HashMap<String,Object> login(User user);
    HashMap<String,Object> regist(User user);
    HashMap<String,Object> queryFiveUser();
}
