package com.zc.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tutor {

    private long tid;
    private String tname;
    private String prof;
    private String mail;
    private String password;
    private List<Student> students = new ArrayList<Student>();

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", prof='" + prof + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", students=" + students +
                '}';
    }
}
