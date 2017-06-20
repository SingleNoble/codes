package com.cmfz.controller;

import com.cmfz.entity.City;
import com.cmfz.entity.Master;
import com.cmfz.entity.Province;
import com.cmfz.entity.User;
import com.cmfz.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 31677 on 2017/6/13.
 */
@Controller
@RequestMapping("/poiExcel")
public class PoiExcelController {
    @Resource
    private UserService userService;

    @RequestMapping("/download")
    @ResponseBody
    public void download(HttpServletResponse response){
        try {
            //创建工作空间
            Workbook workbook=new HSSFWorkbook();
            //创建工作薄
            Sheet sheet = workbook.createSheet("所有用户信息");
            //合并单元格
            CellRangeAddress address=new CellRangeAddress(0, 1, 0, 11);
            sheet.addMergedRegion(address);
            //设置单元格格式
            sheet.setDefaultColumnWidth(20);
            //创建一级标题行
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            //设置内容格式
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(cellStyle);
            cell.setCellValue("用户基本信息");

            //创建二级标题行
            Row titleRow=sheet.createRow(2);
            Field[] declaredFields = User.class.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                Cell colCell = titleRow.createCell(i);
                colCell.setCellValue(getValue(declaredFields[i].getName()));
            }
            //调用业务
            List<User> users = userService.queryAll();
            System.out.println(users);

            for (int i = 0; i < users.size(); i++) {
                //数据行
                Row dataRow = sheet.createRow(i+3);
                //创建数据列
                for (int j = 0; j < declaredFields.length; j++) {
                    Cell dataCell = dataRow.createCell(j);
                    //通过反射调用类中的方法
                    String getMethodName = "get" +
                            declaredFields[j].getName().substring(0, 1).toUpperCase()
                            +declaredFields[j].getName().substring(1);
                    //返回方法对象
                    Method getMethod = User.class.getDeclaredMethod(getMethodName, new Class[]{});
                    //执行方法
                    Object invoke = getMethod.invoke(users.get(i), new Object[]{});
                    if(declaredFields[j].getType()  == String.class) {
                        dataCell.setCellValue(invoke.toString());
                    }
                    if(declaredFields[j].getType()  == Province.class) {
                        dataCell.setCellValue(((Province)invoke).getName());
                    }
                    if(declaredFields[j].getType()  == City.class) {
                        dataCell.setCellValue(((City)invoke).getName());
                    }
                    if(declaredFields[j].getType()  == Master.class) {
                        dataCell.setCellValue(((Master)invoke).getNickname());
                    }
                }

            }
            //写出Excel

            //设置以附件的形式下载  attachment
            response.setHeader("content-disposition", "attachment; fileName="+ URLEncoder.encode("所有用户信息.xls","UTF-8"));
            ServletOutputStream os = response.getOutputStream();
            workbook.write(os);
            os.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String getValue(String key){
        Map<String,String> map=new HashMap<String,String>();
        map.put("id", "编号");
        map.put("realname", "姓名");
        map.put("nickname", "法名");
        map.put("sex", "性别");
        map.put("description", "个性签名");
        map.put("phone", "手机号");
        map.put("password", "密码");
        map.put("salt", "盐");
        map.put("imgpath", "头像路径");
        map.put("province", "省");
        map.put("city", "市");
        map.put("master", "师傅");
        return map.get(key);
    }
}
