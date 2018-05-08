package com.zc.service;

import com.zc.entity.Student;
import com.zc.entity.Tutor;

public interface RegisterService {

    void save(Student student);

    void saveTutor(Tutor tutor);
}
