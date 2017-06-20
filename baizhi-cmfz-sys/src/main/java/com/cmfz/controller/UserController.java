package com.cmfz.controller;

import com.cmfz.entity.User;
import com.cmfz.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 31677 on 2017/6/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("/queryAllByPage")
    @ResponseBody
    public Map<String,Object> queryAllByPage(Integer page,Integer rows){
        Page<User> users = userService.queryAllByPage(page, rows);
        List<User> result = users.getResult();
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("total",users.getTotal());
        map.put("rows",result);
        return map;
    }
    //删除
    @RequestMapping("/drop")
    @ResponseBody
    public Map<String,String> drop(String id){
        Map<String,String> map=new HashMap<String,String>();
        try {
            userService.drop(id);
            map.put("message","删除成功~~~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","删除失败！！！！"+e.getMessage());
        }
        return map;
    }
}
