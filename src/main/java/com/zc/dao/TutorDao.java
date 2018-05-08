package com.zc.dao;

import com.zc.entity.Student;
import com.zc.entity.Tutor;

import java.util.List;
import java.util.Set;

public interface TutorDao {
    Tutor findByName(String tname);

    List<Student> findAll();

    Tutor findById(Long tid);

    void update(Tutor tutor);
}
