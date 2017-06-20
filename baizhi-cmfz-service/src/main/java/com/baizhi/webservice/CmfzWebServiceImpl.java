package com.baizhi.webservice;

import com.alibaba.druid.util.StringUtils;
import com.baizhi.entity.Counter;
import com.baizhi.entity.Lesson;
import com.baizhi.entity.User;
import com.baizhi.service.CounterService;
import com.baizhi.service.LessonService;
import com.baizhi.service.UserService;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangqiang on 2017/6/16.
 */
@WebService
@Path("/cmfz")
public class CmfzWebServiceImpl implements CmfzWebService {
    @Resource
    private LessonService lessonService;
    @Resource
    private CounterService counterService;
    @Resource
    private UserService userService;

    //lesson
    @GET
    @Path("/queryDefaultLesson")
    @Produces("application/json;charset=UTF-8")
    public HashMap<String,Object> queryDefaultLesson() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Lesson> lessons = null;
        try {
            lessons = lessonService.queryDefaultLesson();
            map.put("msg","成功");
            map.put("list",lessons);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    @GET
    @Path("/queryByUserId")
    @Produces("application/json;charset=UTF-8")

    public HashMap<String,Object> queryByUserId(String userId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Lesson> lessons = null;
        try {
            lessons = lessonService.queryByUserId(userId);
            map.put("msg","成功");
            map.put("list",lessons);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    @POST
    @Path("/addLesson")
    @Produces("application/json;charset=UTF-8")
    public HashMap<String,Object> addLesson(Lesson lesson,String userId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setId(userId);
        lesson.setUser(user);
        try {
            lessonService.addLesson(lesson);
            map.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    @DELETE
    @Path("/dropCustomLesson")
    @Produces("application/json;charset=UTF-8")
    public HashMap<String,Object> dropCustomLesson(Lesson lesson,String userId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            lessonService.dropCustomLesson(lesson,userId);
            map.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    //counter
    @POST
    @Path("/addCounter")
    @Produces("application/json;charset=UTF-8")
    public HashMap<String,Object> addCounter(Counter counter, String userId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setId(userId);
        counter.setUser(user);
        try {
            counterService.addCounter(counter);
            map.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    @GET
    @Path("/queryByLidAndUserId")
    @Produces("application/json;charset=UTF-8")
    public HashMap<String,Object> queryByLidAndUserId(String lessonId, String userId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Lesson lesson = lessonService.queryById(lessonId);
        if (StringUtils.equals(lesson.getType(),"o")){
            userId=null;
        }
        List<Counter> counters = null;
        try {
            counters = counterService.queryByLidAndUserId(lessonId, userId);
            map.put("msg","成功");
            map.put("list",counters);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    @DELETE
    @Path("/dropCounter")
    @Produces("application/json;charset=UTF-8")
    public HashMap<String,Object> dropCounter(String id) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            counterService.drop(id);
            map.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }
    @PUT
    @Path("/changeNum")
    public HashMap<String,Object> changeNum(Counter counter) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            counterService.changeNum(counter);
            map.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    //User

    @GET
    @Path("/login")
    @Produces("application/json;charset=UTF-8")
    public HashMap<String,Object> login(User user) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            user = userService.login(user);
            map.put("msg","成功");
            map.put("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg",e.getMessage());
        }
        return map;
    }
    @POST
    @Path("/regist")
    public HashMap<String,Object> regist(User user) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            userService.regist(user);
            map.put("msg","成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }

    @GET
    @Path("/queryFiveUser")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public HashMap<String, Object> queryFiveUser() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<User> users = userService.queryFiveUser();
            map.put("msg","成功");
            map.put("list",users);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","失败");
        }
        return map;
    }
}
