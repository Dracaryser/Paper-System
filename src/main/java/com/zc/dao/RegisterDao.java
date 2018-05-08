package com.zc.dao;

import com.zc.entity.Student;
import com.zc.entity.Tutor;
import org.apache.ibatis.annotations.Param;

public interface RegisterDao {

    void save(@Param("student") Student student);

    void saveTutor(@Param("tutor") Tutor tutor);
}
