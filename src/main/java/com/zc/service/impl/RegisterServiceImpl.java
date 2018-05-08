package com.zc.service.impl;

import com.zc.dao.RegisterDao;
import com.zc.entity.Student;
import com.zc.entity.Tutor;
import com.zc.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;
    
    public void save(Student student) {
        registerDao.save(student);
    }

    public void saveTutor(Tutor tutor) {
        registerDao.saveTutor(tutor);
    }
}
