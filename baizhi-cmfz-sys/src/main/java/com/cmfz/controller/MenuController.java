package com.cmfz.controller;


import com.cmfz.entity.Manager;
import com.cmfz.entity.Menu;
import com.cmfz.service.ManagerService;
import com.cmfz.service.MenuService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 管理员相关的controll
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /*查询系统菜单*/
    @RequestMapping("/querryAll")
    @ResponseBody
    public List<Menu> querryAll(){
        List<Menu> menus = menuService.querryAll();
        return menus;
    }


}
