package com.cmfz.controller;


import com.cmfz.entity.Rotation;
import com.cmfz.service.RotationService;
import com.github.pagehelper.Page;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/rotation")
public class RotationController {

    @Resource
    private RotationService rotationService;

    //添加
    @ResponseBody
    @RequestMapping("/add")
    public Map<String,String> add(MultipartFile rtt, HttpSession session,String description){


        Rotation rotation=null;
        Map<String,String> map=new HashMap<String, String>();
        //获取文件存储路径
        String realPath = session.getServletContext().getRealPath("/");
        String filepath="cmfz\\image";
        File file = new File(realPath, filepath);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取文件后缀名
        String extension = FilenameUtils.getExtension(rtt.getOriginalFilename());
        //文件信息入库
        try {
            rotation = new Rotation(null, description,realPath+filepath+"\\"+description+"."+extension);

            rotationService.add(rotation);
        }catch (Exception e1){
            e1.printStackTrace();
            map.put("message","上传失败");
            return map;
        }
        //上传文件
        try {
            rtt.transferTo(new File(file,description+"."+extension));
            map.put("message","上传成功");
            return map;
        } catch (IOException e) {
            //失败删除文件
            rotationService.delete(rotation);
            map.put("message","上传失败");
            return map;
        }
    }
    //查询所有
    @ResponseBody
    @RequestMapping("/queryAll")
    public Map<String ,Object> queryAll(Integer page,Integer rows){
        Page<Rotation> rotations = rotationService.queryAll(page, rows);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",rotations.getTotal());
        map.put("rows",rotations.getResult());
        return map;
    }
    //删除
    @ResponseBody
    @RequestMapping("/drop")
    public void drop(String id,HttpSession session){

        Rotation rotation = rotationService.queryById(id);
        String realPath = session.getServletContext().getRealPath("/");
        File file = new File(realPath, rotation.getFilepath());
        try {
            rotationService.delete(rotation);
        }catch (Exception e){
            throw new RuntimeException("删除失败");
        }
        try {
            if (file.exists()){
                file.delete();
            }
        }catch (Exception e1){
            rotationService.add(rotation);
            throw new RuntimeException("删除失败");
        }

    }

}
