package com.zc.controller;

import com.zc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@RequestMapping("/file")
@Controller
public class FileController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/{sid}/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@PathVariable("sid") Long sid, MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = String.valueOf(sid)+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        File dir = new File(path, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        file.transferTo(dir);
        return "Upload Success!";
    }

    @RequestMapping(value ="/{sid}/down")
    public void down(@PathVariable("sid") Long sid,HttpServletRequest request,HttpServletResponse response) throws Exception{

        String fileName = request.getSession().getServletContext().getRealPath("/upload")+"\\"+String.valueOf(sid)+".docx";
        String realname = String.valueOf(sid)+".docx";
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        response.addHeader("Content-Disposition", "attachment;filename=" + realname);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }

}