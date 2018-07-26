package com.kfluous.webload.dao;

import com.kfluous.webload.domain.Student;

import java.util.List;

public interface UserDAO {
    Student findUser(String id,String pwd);
    boolean updateUserPwd(Student student);
    Student findUserById(String sid);
    public List<Student> showStuNoFile(String classname);
}
