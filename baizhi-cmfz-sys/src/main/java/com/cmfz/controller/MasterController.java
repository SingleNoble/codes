package com.cmfz.controller;



import com.cmfz.entity.Master;
import com.cmfz.service.MasterService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
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

    //查所有
    @RequestMapping("/query")
    @ResponseBody
    public List<Master> query(){
        return masterService.sellect();
    }
    /*添加上师*/
    @ResponseBody
    @RequestMapping("/add")
    public String add(Master master){
        masterService.add(master);
        return null;
    }
    /*上师头像*/
    @ResponseBody
    @RequestMapping("/photoUpload")
    public String photoUpload(HttpSession session, MultipartFile photo) throws Exception {
        //获取文件存储路径
        String realPath = session.getServletContext().getRealPath("/");
        String filepath="cmfz/image";
        File file = new File(realPath, filepath);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename = photo.getOriginalFilename();
        photo.transferTo(new File(file,filename));
        return filepath+"/"+filename;
    }


    @ResponseBody
    @RequestMapping("/photoDel")
    public void photoDel(String imgpath,HttpSession session){
        //获取文件存储路径
        String realPath = session.getServletContext().getRealPath("/");
        File file = new File(realPath, imgpath);
        if ((file.exists())){
            file.delete();
        }
    }


    @ResponseBody
    @RequestMapping("/drop")
    public Map<String,String> drop(String id,HttpSession session) throws Exception {
        Master master = masterService.queryById(id);
        String realPath = session.getServletContext().getRealPath("/");
        File file=new File(realPath,master.getImgpath());
        Map<String,String> map = new HashMap<String, String>();
        try {
            masterService.drop(master);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","删除失败");
        }
        try {
            if (file.exists()){
                file.delete();
            }
            map.put("message","删除成功");
        } catch (Exception e) {
            map.put("message","删除失败");
            masterService.add(master);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/queryById")
    public Master queryById(String id){
        Master master = masterService.queryById(id);
        return master;
    }

    @RequestMapping("/change")
    public void change(Master master){
        masterService.change(master);
    }

}
