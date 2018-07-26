package com.kfluous.webload.dao.Impl;

import com.kfluous.webload.dao.BaseDAO;
import com.kfluous.webload.dao.FileDAO;
import com.kfluous.webload.domain.FileRec;
import com.kfluous.webload.domain.Project;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@SuppressWarnings("restriction")
@Repository
@Transactional
public class FileDAOImpl extends BaseDAO implements FileDAO {

    public FileDAOImpl() {
        super();
    }



//    public void saveFile(FileRec file){
//        //1.注册数据库驱动
//        DriverManager.registerDriver(new Driver());
//        //2.获取数据库的连接
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fileload?useSSL=false", "root", "");
//        //3.创建传输器对象
//        Statement stat = conn.createStatement();
//        //4.利用传输器对象传输sql语句到数据库中执行操作，将结果用结果集返回
//        String sql="INSERT INTO `file_rec`\n" +
//                "(`fileId`, `fileName`, `filesize`, `fileClass`, `filePath`, `auther`, `date`)\n" +
//                "VALUES ("
//                + file.getFileName() +","
//                +file.getFilesize() +","
//                +file.getClass() +","
//                +file.getFilePath() +","
//                + file.getAuther()+","
//                +" CURRENT_DATE);";
//        boolean rs =  stat.execute(sql);
//
//
//        //6.关闭连接（后开先关）
//        rs.close();
//        stat.close();
//        conn.close();
//    }









    @Override
    public void saveFile(FileRec file) {
        getSession().saveOrUpdate(file);
    }


    @Override
    public void deleteFile(int fileId) {
        FileRec file = (FileRec) getSession().get(FileRec.class, fileId);
        getSession().delete(file);
    }

    @Override
    public boolean updateFIle(FileRec file) {
        getSession().update(file);
        return true;

    }

    @Override
    public List<Project> findALLAchieve() {
        List<Project> achieve = null;

        String hql = "FROM Project";
        achieve = getSession().createQuery(hql).list();

        return achieve;
    }

    @Override

    //TODO  待优化
    public List<FileRec> showFileByClass(String classpath) {
        List<FileRec> list = null;

        list = getSession().createQuery(
                "FROM FileRec f WHERE f.fileClass = :class "
        ).setParameter("class", classpath)
                .list();

        return list;
    }

    @Override
    public List<FileRec> showfileByAuthorid(Long myid) {
        List<FileRec> myFileList = null;
        myFileList = getSession().createQuery(
                "FROM FileRec f WHERE f.auther = :myid "
        ).setParameter("myid", myid)
                .list();
        return myFileList;
    }

    @Override
    public FileRec getFileById(int fileId) {
        FileRec fileRec= (FileRec) getSession().get(FileRec.class,fileId);
        return fileRec;
    }

    @Override
    public List<FileRec> showFileByClass(int project_id) {
        List<FileRec> fileList = null;
        fileList = getSession().createQuery(
                "FROM FileRec f WHERE f.auther = :project_id "
        ).setParameter("project_id", project_id)
                .list();
        return fileList;
    }

    @Override
    public List showStuNoFile(String classname) {
        List StuList = null;
        StuList = getSession().createQuery(
                "select stu.name from Student stu where stu.id not in (select file.auther from FileRec file where file.fileClass=:classname)")
                .setParameter("classname", classname)
                .list();
        return StuList;
    }

    @Override
    public boolean judgeSameFilename(String filename) {

        return false;
    }


}
