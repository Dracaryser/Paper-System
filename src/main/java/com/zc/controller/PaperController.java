package com.zc.controller;

import com.zc.entity.Paper;
import com.zc.entity.Student;
import com.zc.entity.Tutor;
import com.zc.service.PaperService;
import com.zc.service.StudentService;
import com.zc.service.TutorService;
import com.zc.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/paper")
public class PaperController {

    Paper paper = new Paper();
    @Autowired
    TutorService tutorService;
    @Autowired
    StudentService studentService;
    @Autowired
    PaperService paperService;

    @RequestMapping(value = "/{sid}/detail")
    public String paperDetail(@PathVariable("sid") Long sid, Model model) {
        Long pid = studentService.findPidById(sid);
        paper = paperService.findById(pid);
        Student student = studentService.findById(sid);
        student.setPaper(paper);
        model.addAttribute("student", student);
        return "paper/paperDetail";
    }

    @RequestMapping(value = "/{sid}/tdetail")
    public String tpaperDetail(@PathVariable("sid") Long sid, Model model) {
        Long pid = studentService.findPidById(sid);
        paper = paperService.findById(pid);
        Student student = studentService.findById(sid);
        student.setPaper(paper);
        model.addAttribute("student", student);
        return "tutor/tutorPaperDetail";
    }

    @RequestMapping(value = "/{pid}/update")
    public String update(@PathVariable("pid") Long pid, HttpServletRequest request, Model model) throws IOException {

        paper = paperService.findById(pid);
        Long sid = paperService.findSidById(pid);
        Student student = studentService.findById(sid);
        Long tid = studentService.findTidById(sid);
        Tutor tutor = tutorService.findById(tid);
        student.setTutor(tutor);

        String pname = new String(request.getParameter("pname").getBytes("ISO-8859-1"), "utf-8");
        String pcontent = new String(request.getParameter("pcontent").getBytes("ISO-8859-1"), "utf-8");
        paper.setPcontent(pcontent);
        paper.setPname(pname);
        paper.setState("已保存");
        String state = paper.getState();
        student.setPaper(paper);
        model.addAttribute("pname", pname);
        model.addAttribute("pcontent", pcontent);
        model.addAttribute("state", state);
        model.addAttribute("student", student);
        paperService.update(paper);
        return "paper/paperDetail";
    }

    @RequestMapping(value = "/{pid}/tutorUpdate")
    public String tutorUpdate(@PathVariable("pid") Long pid, HttpServletRequest request, Model model) throws IOException {

        paper = paperService.findById(pid);
        Long sid = paperService.findSidById(pid);
        Long tid = studentService.findTidById(sid);
        Tutor tutor = tutorService.findById(tid);
        List<Student> students = studentService.findByTid(tid);
        tutor.setStudents(students);
        String pname = request.getParameter("pname");
        String pcontent =request.getParameter("pcontent");
        paper.setPcontent(pcontent);
        paper.setPname(pname);
        paper.setState("已保存");
        String state = paper.getState();
        model.addAttribute("pname", pname);
        model.addAttribute("pcontent", pcontent);
        model.addAttribute("state", state);
        model.addAttribute("tutor", tutor);
        paperService.update(paper);
        return "tutor/tutorDetail";
    }


    @RequestMapping(value = "/{sid}/sendEmail")
    public String sendEmail(@PathVariable("sid") Long sid,Model model) throws MessagingException {
        Student student = studentService.findById(sid);
        Long tid = studentService.findTidById(sid);
        Tutor tutor = tutorService.findById(tid);
        Long pid = studentService.findPidById(sid);
        Paper paper = paperService.findById(pid);
        paper.setState("已提交");
        paperService.update(paper);
        student.setPaper(paper);
        student.setTutor(tutor);
        String to = tutor.getMail();
        String sname = student.getSname();
        MailUtils.sendMail(to,"论文提交提醒",sname+"的论文已提交，请及时审阅");
        model.addAttribute("student",student);
        return "student/studentDetail";
    }

    @RequestMapping(value = "/{sid}/tSendEmail")
    public String tsendEmail(@PathVariable("sid") Long sid,Model model) throws MessagingException {
        Student student = studentService.findById(sid);
        Long tid = studentService.findTidById(sid);
        Tutor tutor = tutorService.findById(tid);
        Long pid = studentService.findPidById(sid);
        Paper paper = paperService.findById(pid);
        paper.setState("已审阅修改");
        paperService.update(paper);
        List<Student> students = studentService.findByTid(tid);
        tutor.setStudents(students);
        student.setPaper(paper);
        student.setTutor(tutor);
        String to = student.getMail();
        MailUtils.sendMail(to,"论文审阅提醒","您的论文已被导师审阅修改，请及时查看。");
        model.addAttribute("tutor",tutor);
        return "tutor/tutorDetail";
    }
}
