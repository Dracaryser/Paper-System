package com.zc.service;

import com.zc.entity.Student;
import com.zc.entity.Tutor;

import java.util.List;
import java.util.Set;

public interface TutorService {
    Tutor findByName(String tname);

    List<Student> findAll();

    Tutor findById(Long tid);

    void update(Tutor tutor);

    Tutor check(Long tid);

    String getPasswordById(String id);
}
