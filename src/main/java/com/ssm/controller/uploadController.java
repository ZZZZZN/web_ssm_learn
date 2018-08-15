package com.ssm.controller;


import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@SuppressWarnings({ "rawtypes" })
@Controller
public class uploadController {

    private Logger log;

    public uploadController() {
        this.log = Logger.getLogger(this.getClass());
    }


    @GetMapping("uploaderUI")
    public String uploadUI(){
        return "upload";
    }

    @PostMapping("uploadPicture")
    @ResponseBody
    public JSONObject upload(@RequestParam("file")MultipartFile files,HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json=new JSONObject();
        response.setCharacterEncoding("utf-8");
        String msg = "添加成功";
        log.info("-------------------开始调用上传文件upload接口-------------------");
        try{
            String name = files.getOriginalFilename();
            String path = request.getSession().getServletContext().getRealPath("");
            path = path + "/upload/";
            path = path + File.separator + name;
            File uploadFile = new File(path);
            files.transferTo(uploadFile);
        }catch(Exception e){
            msg="添加失败";
        }
        log.info("-------------------结束调用上传文件upload接口-------------------");
        json.put("msg", msg);
        return json;
    }

}
