package com.kfluous.webload.service.Impl;

import com.kfluous.webload.dao.Impl.UserDAOImpl;
import com.kfluous.webload.dao.UserDAO;
import com.kfluous.webload.domain.Student;
import com.kfluous.webload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO mUserDAO;

    @Override
    public Student loginByIdandPwd(String id,String pwd) {
        Student student = null;
        student = (Student)mUserDAO.findUser(id,pwd);
        return student;
    }

    @Override
    public boolean logout(Student student) {
        return false;
    }

    @Override
    public boolean ChangePwd(Student student,String passowrd) {
        if(student.getPassword()==passowrd)
            return false;
        student.setPassword(passowrd);

        mUserDAO.updateUserPwd(student);
        return true;                  //写的很乱 TODO
    }

    @Override
    public List<Student> showStuNoFile(String classname) {
        return mUserDAO.showStuNoFile(classname);
    }
}
