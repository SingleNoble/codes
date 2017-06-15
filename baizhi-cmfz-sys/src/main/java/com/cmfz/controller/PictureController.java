package com.cmfz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/picture")
public class PictureController {
    @ResponseBody
    @RequestMapping("/upload")
    public String upload(HttpSession session, MultipartFile picture) {
        //获取文件存储路径
        String realPath = session.getServletContext().getRealPath("/");
        String filepath="cmfz/image";
        File file = new File(realPath, filepath);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename = picture.getOriginalFilename();
        try {
            picture.transferTo(new File(file,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath+"/"+filename;
    }

    @ResponseBody
    @RequestMapping("/pictureDel")
    public void photoDel(String imgpath,HttpSession session){
        //获取文件存储路径
        String realPath = session.getServletContext().getRealPath("/");
        File file = new File(realPath, imgpath);
        if ((file.exists())){
            file.delete();
        }
    }
}
