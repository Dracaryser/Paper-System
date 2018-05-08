package com.zc.service;

import com.zc.entity.Student;

import java.util.List;

public interface StudentService {

    Student findById(Long sid);

    Long findTidById(Long sid);

    List<Student> findByTid(Long tid);

    Long findPidById(Long sid);

    Student doLogin(Long sid,String password);

    void update(Student student);
}
