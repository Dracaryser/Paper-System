package com.zc.service.impl;

import com.zc.dao.redis.RedisDao;
import com.zc.dao.StudentDao;
import com.zc.entity.Student;
import com.zc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    RedisDao redisDao;

    public Student findById(Long sid) {
        Student student = studentDao.findById(sid);
        return student;
    }

    public Long findTidById(Long sid) {
        return studentDao.findTidById(sid);
    }

    public List<Student> findByTid(Long tid) {
        return studentDao.findByTid(tid);
    }

    public Long findPidById(Long sid) {
        return studentDao.findPidById(sid);
    }

    public Student doLogin(Long sid,String password) {
        Student student = redisDao.getStudent(sid,password);
        if(student == null){
            try {
                student = studentDao.findById(sid);
                if(student == null){
                    return null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            redisDao.putStudent(student);
        }
        return student;
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public Student check(Long sid) {
        Student student = studentDao.findById(sid);
        if(student != null){
            return student;
        }
        return null;
    }
}
