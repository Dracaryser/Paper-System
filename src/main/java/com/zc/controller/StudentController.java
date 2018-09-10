package com.zc.controller;

import com.zc.entity.Paper;
import com.zc.entity.Student;
import com.zc.entity.Tutor;
import com.zc.service.PaperService;
import com.zc.service.StudentService;
import com.zc.service.TutorService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/student")
public class StudentController {

    Student student = new Student();
    @Autowired
    StudentService studentService;
    @Autowired
    TutorService tutorService;
    @Autowired
    PaperService paperService;


    @RequestMapping("/login")
    private String login(HttpServletRequest request, Model model, HttpSession httpSession,HttpServletResponse response)throws ServletException, IOException{
        Long sid = Long.valueOf(request.getParameter("id"));
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(sid),password);
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            request.setAttribute("errormessage", "学号或密码错误！");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        student = studentService.doLogin(sid,password);
        Long tid = studentService.findTidById(sid);
        Tutor tutor = tutorService.findById(tid);
        student.setTutor(tutor);
        Long pid = studentService.findPidById(sid);
        Paper paper = paperService.findById(pid);
        student.setPaper(paper);
        model.addAttribute("sid",sid);
        httpSession.setAttribute("id",sid);
        model.addAttribute("student",student);

        return "student/studentDetail";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "/index";
    }

    @RequestMapping("/{sid}/modify")
    private String modify(@PathVariable("sid") Long sid, Model model){
        student = studentService.findById(sid);
        model.addAttribute("student",student);
        return "student/studentModify";
    }

    @RequestMapping("/{sid}/smodify")
    private String smodify(@PathVariable("sid")Long sid,HttpServletRequest request,Model model){
        student = studentService.findById(sid);
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        Long tid = studentService.findTidById(sid);
        Tutor tutor = tutorService.findById(tid);
        student.setTutor(tutor);
        Long pid = studentService.findPidById(sid);
        Paper paper = paperService.findById(pid);
        student.setPaper(paper);
        student.setPassword(password);
        student.setMail(mail);
        model.addAttribute("student",student);
        model.addAttribute("password",password);
        model.addAttribute("mail",mail);
        model.addAttribute("sid",sid);
        studentService.update(student);
        return "student/studentDetail";
    }
}
