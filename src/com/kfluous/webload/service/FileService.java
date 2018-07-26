package com.kfluous.webload.service;


import com.kfluous.webload.domain.FileRec;
import com.kfluous.webload.domain.Project;
import com.kfluous.webload.domain.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public interface FileService {



    public static final String ROOTPATH = "/home/fileload";

    public static final String CONNECTOR = "/";


    boolean uploadFile(File file,FileRec fileRec);  //上传文件

    boolean downloadFile(FileRec file);        //下载文件

    boolean deleteMyFile(int fileId);        //删除文件

    List<FileRec> FileList(String Achieve); //根据Achieve归档项目查找文件

    List<FileRec> FileList(int Project_id); //根据Achieve归档项目查找文件

    List<FileRec> MyFileList(Student student);

    List showStuNOFile(String Achieve);

}
