package com.zc.controller;

import com.zc.entity.Student;
import com.zc.entity.Tutor;
import com.zc.service.StudentService;
import com.zc.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tutor")
public class TutorController {

    Tutor tutor = new Tutor();
    @RequestMapping(value = "log")
    public String log(){
        return "/index";
    }
    @Autowired
    TutorService tutorService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/login")
    private String login(HttpServletRequest request, Model model, HttpSession httpSession) {
        Long tid = Long.valueOf(request.getParameter("id"));
        String password = request.getParameter("password");
        httpSession.setAttribute("id",tid);
        try {
            tutor = tutorService.findById(tid);
            if(tutor == null)
                return "/index";
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Student> students = studentService.findByTid(tid);
        tutor.setStudents(students);
        if (tutor.getTid() != tid || !tutor.getPassword().equals(password)) {
            return "/index";
        } else {
            model.addAttribute("tutor", tutor);
        }
        return "tutor/tutorDetail";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "/index";
    }

    @RequestMapping("/{tid}/modify")
    private String modify(@PathVariable("tid") Long tid,Model model){
        tutor = tutorService.findById(tid);
        model.addAttribute("tutor",tutor);
        return "tutor/tutorModify";
    }

    @RequestMapping("/{tid}/smodify")
    private String smodify(@PathVariable("tid") Long tid,HttpServletRequest request,Model model){
        tutor = tutorService.findById(tid);
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");
        tutor.setPassword(password);
        tutor.setMail(mail);
        List<Student> students = studentService.findByTid(tid);
        tutor.setStudents(students);
        tutorService.update(tutor);
        model.addAttribute("password",password);
        model.addAttribute("mail",mail);
        model.addAttribute("tid",tid);
        model.addAttribute("tutor",tutor);
        return "tutor/tutorDetail";

    }


}
