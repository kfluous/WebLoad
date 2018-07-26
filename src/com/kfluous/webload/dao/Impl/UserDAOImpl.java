package com.kfluous.webload.dao.Impl;

import com.kfluous.webload.dao.BaseDAO;
import com.kfluous.webload.dao.UserDAO;
import com.kfluous.webload.domain.Student;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("restriction")
@Repository
@Transactional
public class UserDAOImpl extends BaseDAO implements UserDAO  {
    Student mStudent =null;

    @Override
    public Student findUser(String id,String pwd) {
        Long idToint = Long.parseLong(id);
        mStudent = (Student) getSession().createQuery(
                "FROM Student s WHERE s.id = :id and s.password = :pwd"
        ).setParameter("id", idToint)
                .setParameter("pwd", pwd).uniqueResult();

        return mStudent;
    }

    @Override
    public boolean updateUserPwd(Student student) {
        getSession().update(student);
        return true;
    }

    @Override
    public Student findUserById(String sid) {
        Student student= (Student)getSession().get(Student.class,sid);
        return student;
    }

    @Override
    public List<Student> showStuNoFile(String classname) {
        List<Student> StuList = null;
        StuList = getSession().createQuery(
                "from Student stu where stu.id not in (select file.auther from FileRec file where file.fileClass=:classname)")
                .setParameter("classname", classname)
                .list();
        return StuList;
    }
}
