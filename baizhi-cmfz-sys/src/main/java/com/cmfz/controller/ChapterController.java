package com.cmfz.controller;


import com.cmfz.entity.Album;
import com.cmfz.entity.Chapter;
import com.cmfz.service.AlbumService;
import com.cmfz.service.ChapterService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    private ChapterService chapterService;
    @Resource
    private AlbumService albumService;

    /*上传音频*/
    @ResponseBody
    @RequestMapping("/upload")
    public String upload(HttpSession session, MultipartFile audio, Album album){
        String msg=null;
        album = albumService.queryById(album);
        //获取文件存储路径
        String realPath = session.getServletContext().getRealPath("/");
        String filepath="cmfz/audio";
        File file = new File(realPath, filepath);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取文件名
        String oldname = audio.getOriginalFilename();
        //新文件名
        String newName= UUID.randomUUID().toString()+new Date().getTime()+"."+ FilenameUtils.getExtension(oldname);
        //文件类型
        String fileType=audio.getContentType();
        //文件路径
        String path = filepath+"/"+newName;
        //文件大小
        String fileSize=String.valueOf(audio.getSize());

        Chapter chapter = new Chapter();
        chapter.setOldName(oldname);
        chapter.setNewName(newName);
        chapter.setFilePath(path);
        chapter.setFileSize(fileSize);
        chapter.setContentType(fileType);
        chapter.setAlbum(album);
        try {
            chapter=chapterService.add(chapter);
            audio.transferTo(new File(file,newName));
            msg="success";
        } catch (IOException e) {
            e.printStackTrace();
            chapterService.drop(chapter);
            msg="error";
        }
        return msg;
    }

    /*查询专辑的章节*/
    @ResponseBody
    @RequestMapping("/queryByAlbumId")
    public Map<String,Object> queryByAlbumId(Integer page,Integer rows,Album album){

        Map<String,Object> map = new HashMap<String, Object>();
        Page<Chapter> chapters = null;
        try {
            chapters = chapterService.queryByAlbumId(page, rows, album);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("total",chapters.getTotal());
        map.put("rows",chapters.getResult());
        return map;
    }
    /*删除*/
    @ResponseBody
    @RequestMapping("/drop")
    public String drop(Chapter chapter){
        String msg=null;
        try {
            chapterService.drop(chapter);
            msg="success";
        } catch (Exception e) {
            e.printStackTrace();
            msg="error";
        }
        return msg;
    }
}
