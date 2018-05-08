package com.zc.dao;

import com.zc.entity.Student;

import java.util.List;

public interface StudentDao {

    Student findById(Long sid);

    Long findTidById(Long sid);

    List<Student> findByTid(Long tid);

    Long findPidById(Long sid);

    void update(Student student);

}
