package com.cmfz.controller;

import com.cmfz.entity.Article;
import com.cmfz.service.ArticleService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 31677 on 2017/6/14.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    //添加
    @RequestMapping("/add")
    @ResponseBody
    public Map<String,String> add(Article article){
        Map<String,String> map=new HashMap<String, String>();
        try {
            articleService.add(article);
            map.put("message","添加成功~~~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","添加失败!!!!"+e.getMessage());
        }
        return map;
    }
    //分页
    @RequestMapping("/queryAllByPage")
    @ResponseBody
    public Map<String ,Object> queryAllByPage(Integer page,Integer rows){
        Page<Article> articles = articleService.queryAllByPage(page, rows);
        List<Article> result = articles.getResult();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",articles.getTotal());
        map.put("rows",result);
        return map;
    }
    //删除
    @RequestMapping("/drop")
    @ResponseBody
    public Map<String,String> drop(String id){
        Map<String,String> map=new HashMap<String,String>();
        try {
            articleService.drop(id);
            map.put("message","删除成功~~");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","删除失败！！！"+e.getMessage());
        }
        return map;
    }
    //查一个
    @RequestMapping("/queryOne")
    @ResponseBody
    public Article queryOne(String id){

        return articleService.queryOneById(id);
    }
}
