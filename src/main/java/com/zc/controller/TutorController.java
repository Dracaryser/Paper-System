package com.zc.controller;

import com.zc.entity.Student;
import com.zc.entity.Tutor;
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
import java.util.List;

@Controller
@RequestMapping("/tutor")
public class TutorController {

    Tutor tutor = new Tutor();

    @RequestMapping(value = "log")
    public String log() {
        return "/index";
    }

    @Autowired
    TutorService tutorService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/login")
    private String login(HttpServletRequest request, Model model, HttpSession httpSession, HttpServletResponse response) throws IOException, ServletException {
        Long tid = Long.valueOf(request.getParameter("id"));
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(tid),password);
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            request.setAttribute("errormessage", "工号或密码错误！");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        httpSession.setAttribute("id", tid);
        tutor = tutorService.findById(tid);
        List<Student> students = studentService.findByTid(tid);
        tutor.setStudents(students);
        model.addAttribute("tutor", tutor);

        return "tutor/tutorDetail";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "/index";
    }

    @RequestMapping("/{tid}/modify")
    private String modify(@PathVariable("tid") Long tid, Model model) {
        tutor = tutorService.findById(tid);
        model.addAttribute("tutor", tutor);
        return "tutor/tutorModify";
    }

    @RequestMapping("/{tid}/smodify")
    private String smodify(@PathVariable("tid") Long tid, HttpServletRequest request, Model model) {
        tutor = tutorService.findById(tid);
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        tutor.setPassword(password);
        tutor.setMail(mail);
        List<Student> students = studentService.findByTid(tid);
        tutor.setStudents(students);
        tutorService.update(tutor);
        model.addAttribute("password", password);
        model.addAttribute("mail", mail);
        model.addAttribute("tid", tid);
        model.addAttribute("tutor", tutor);
        return "tutor/tutorDetail";

    }


}
