package com.kfluous.webload.dao;
import com.kfluous.webload.domain.FileRec;
import com.kfluous.webload.domain.Project;


import java.util.List;


public interface FileDAO  {
    void saveFile(FileRec file);
    void deleteFile(int fileId);   //delete
    boolean updateFIle(FileRec file);
    List<Project> findALLAchieve();   //查询数据库 project表
    List<FileRec> showFileByClass(String classpath);   // find all file where classpath = project.classpath
    List<FileRec> showfileByAuthorid(Long myid);      // find all file where author = myid
    FileRec getFileById(int fileId);   //
    List<FileRec> showFileByClass(int project_id);

    List showStuNoFile(String classname);

    boolean judgeSameFilename(String filename);
}
