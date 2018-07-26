package com.kfluous.webload.service.Impl;

import com.kfluous.webload.dao.FileDAO;
import com.kfluous.webload.dao.Impl.FileDAOImpl;
import com.kfluous.webload.domain.FileRec;
import com.kfluous.webload.domain.Project;
import com.kfluous.webload.domain.Student;
import com.kfluous.webload.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;


@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDAO mFileDAO;

    @Override
    public boolean uploadFile(File file,FileRec fileRec) {
        try {
            fileRec.setFilePath(ROOTPATH+CONNECTOR
                    +fileRec.getFileClass()+CONNECTOR
                    +fileRec.getFileName());         //设置路径

            File destFile = new File(ROOTPATH+CONNECTOR
                    +fileRec.getFileClass(),fileRec.getFileName());

            FileUtils.copyFile(file,destFile);
            mFileDAO.saveFile(fileRec);
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public boolean downloadFile(FileRec file) {
        return false;
    }    //不给下载 算了

    @Override
    public boolean deleteMyFile(int fileId) {
        FileRec fileRec = mFileDAO.getFileById(fileId);
        File deteleFile = new File(fileRec.getFilePath());
        if(!deteleFile.exists()) {                 //TODO
            mFileDAO.deleteFile(fileId);         //历史遗留，没有解决数据库和真实文件的同步
            return true;                        //即 数据库可插入多个文件名一样数据，但是同名的真实文件会被覆盖
        }                                       //所以 将为空数据 单独处理
        if(!deteleFile.isFile())
            return false;

        if(deteleFile.delete()){                //我也不知道我在干撒哈；
            mFileDAO.deleteFile(fileId);
            return true;
        }
        return true;
    }



    @Override
    public List<FileRec> FileList(String Achieve) {
        return mFileDAO.showFileByClass(Achieve);
    }

    @Override
    public List<FileRec> FileList(int Project_id) {
        return mFileDAO.showFileByClass(Project_id);
    }

    @Override
    public List<FileRec> MyFileList(Student student) {
        return mFileDAO.showfileByAuthorid(student.getSid());
    }

    @Override
    public List showStuNOFile(String Achieve) {
        return mFileDAO.showStuNoFile(Achieve);
    }
}
