package com.cmfz.controller;


import com.cmfz.entity.Manager;
import com.cmfz.service.ManagerService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * 管理员相关的controll
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /*登录检验*/
    @RequestMapping("/check")
    public String check(Manager manager,HttpSession session){
        Manager managerDB = managerService.querryByName(manager);
        session.setAttribute("manager",managerDB);

        return "redirect:/cmfz/page/main/main.jsp";
    }
    /*注册*/
    @RequestMapping("/regist")
    public String regist(Manager manager){
        managerService.add(manager);
        return null;
    }
    /*删除*/
    @RequestMapping("delete")
    public void delete(String id){
        managerService.drop(id);
    }


    /*查看所有管理员*/
    @RequestMapping("/queryAll")
    @ResponseBody
    public Map<String,Object> queryAll(Integer page, Integer rows){
        Page<Manager> managers = managerService.queryAll(page, rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",managers.getTotal());
        map.put("rows",managers.getResult());
        return map;
    }
}
