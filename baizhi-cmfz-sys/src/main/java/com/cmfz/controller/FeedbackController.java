package com.cmfz.controller;

import com.cmfz.entity.Feedback;
import com.cmfz.service.FeedbackService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;


    /*查看所有用户反馈*/
    @RequestMapping("/queryAll")
    @ResponseBody
    public Map<String,Object> queryAll(Integer page, Integer rows){

        Page<Feedback> feedbacks = feedbackService.queryAll(page, rows);
        List<Feedback> result = feedbacks.getResult();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",feedbacks.getTotal());
        map.put("rows",result);
        return  map;
    }
}
