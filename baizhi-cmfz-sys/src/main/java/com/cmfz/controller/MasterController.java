package com.cmfz.controller;



import com.cmfz.entity.Master;
import com.cmfz.service.MasterService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 管理员相关的controll
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public Map<String,Object> queryAll(Integer page, Integer rows){

        Page<Master> masters = masterService.queryAll(page, rows);
        List<Master> result = masters.getResult();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",masters.getTotal());
        map.put("rows",result);
        return map;
    }

    /*添加*/
    @RequestMapping("/add")
    public String add(Master master){
        masterService.add(master);
        return "redirect:/master/queryAll";
    }

}
