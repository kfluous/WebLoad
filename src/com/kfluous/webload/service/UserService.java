package com.kfluous.webload.service;

import com.kfluous.webload.domain.Student;

import java.util.List;

public interface UserService {
    Student loginByIdandPwd(String id,String pwd);
    boolean logout(Student student);
    boolean ChangePwd(Student student,String password);
    public List<Student> showStuNoFile(String classname);
}
