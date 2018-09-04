package com.zc.controller;

import com.zc.entity.Paper;
import com.zc.entity.Student;
import com.zc.entity.Tutor;
import com.zc.service.PaperService;
import com.zc.service.RegisterService;
import com.zc.service.StudentService;
import com.zc.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/register")
public class RegisterController {

    Student student = new Student();
    Tutor tutor = new Tutor();
    Paper paper = new Paper();
    @Autowired
    RegisterService registerService;

    @Autowired
    TutorService tutorService;
    @Autowired
    PaperService paperService;
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/studentRegister")
    public String StudentRegister(){
        return "student/studentRegister";
    }

    @RequestMapping(value = "/tutorRegister")
    public String TutorRegister(){
        return "tutor/tutorRegister";
    }

    @RequestMapping(value = "/check",method = { POST })
    public void checkUser(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        PrintWriter out = response.getWriter();
        Long sid = Long.valueOf(request.getParameter("sid"));
        if (sid==null) {
            out.print(2);// 2是不能为空
        } else {
            Student student = studentService.check(sid);
            if (student != null) {
                out.print(1);// 学号已存在
            } else {
                out.print(3);// 学号可以用
            }
        }
    }

    @RequestMapping(value = "/checkTutor",method = { POST })
    public void checkTutor(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        PrintWriter out = response.getWriter();
        Long tid = Long.valueOf(request.getParameter("tid"));
        if (tid==null) {
            out.print(2);// 2是不能为空
        } else {
            Tutor tutor = tutorService.check(tid);
            if (tutor != null) {
                out.print(1);// 工号已存在
            } else {
                out.print(3);// 工号可以用
            }
        }
    }
    @RequestMapping(value = "/student")
    public String sregister(HttpServletRequest request, Model model) throws IOException{

        String sname = request.getParameter("sname");
        Long sid = Long.valueOf(request.getParameter("sid"));
        String sex = request.getParameter("sex");
        int age = Integer.valueOf(request.getParameter("age"));
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String major = request.getParameter("major");
        String tname = request.getParameter("tname");
        tutor = tutorService.findByName(tname);


        student.setSid(sid);
        student.setSname(sname);
        student.setSex(sex);
        student.setAge(age);
        student.setPassword(password);
        student.setMail(mail);
        student.setMajor(major);
        Tutor tutor = tutorService.findByName(tname);
        System.out.println(tutor);
        Long tid = tutor.getTid();
        model.addAttribute("tid",tid);
        List<Student> students = studentService.findByTid(tid);
        students.add(student);
        tutor.setStudents(students);
        student.setTutor(tutor);
        paperService.createNewPaper();
        paper = paperService.findLatestPaper();
        student.setPaper(paper);

        model.addAttribute("student",student);
        registerService.save(student);
        return "student/studentDetail";
    }

    @RequestMapping(value = "/tutor")
    public String tRegister(HttpServletRequest request, Model model){
        Long tid = Long.valueOf(request.getParameter("tid"));
        String tname = request.getParameter("tname");
        String prof = request.getParameter("prof");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");

        tutor.setTname(tname);
        tutor.setTid(tid);
        tutor.setProf(prof);
        tutor.setMail(mail);
        tutor.setPassword(password);
        model.addAttribute("tutor",tutor);
        registerService.saveTutor(tutor);
        return "tutor/tutorDetail";
    }
}
