package com.cmfz.controller;


import com.cmfz.entity.Album;
import com.cmfz.service.AlbumService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/album")
public class AlbumController {

    @Resource
    private AlbumService albumService;

    /*查询所有*/
    @ResponseBody
    @RequestMapping("/queryAll")
    public Map<String,Object> queryAll(Integer page,Integer rows){
        Page<Album> albums = albumService.queryAll(page, rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",albums.getTotal());
        map.put("rows",albums);
        return map;
    }

    /*添加*/
    @ResponseBody
    @RequestMapping("/add")
    public String add(Album album){
        String msg=null;
        try {
            albumService.add(album);
            msg="恭喜你 ！添加成功";
        } catch (Exception e) {
            e.printStackTrace();
            msg="很遗憾，失败了";
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping("/drop")
    public String drop(Album album){
        String msg=null;
        try {
            albumService.drop(album);
            msg="Success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="False";
        }
        return msg;
    }

    /*更新*/
    @ResponseBody
    @RequestMapping("/change")
    public String change(Album album){
        System.out.println(album);
        String msg=null;
        try {
            albumService.change(album);
            msg="success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="error";
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping("/queryById")
    public Album queryById(Album album){
        Album albumDB = albumService.queryById(album);
        return albumDB;
    }
}
