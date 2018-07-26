package com.kfluous.webload.domain;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "file_rec", schema = "fileload", catalog = "")
public class FileRec {
    private int mFileId;
    private String mFileName;
    private double mFilesize;
    private String mFileClass;
    private String mFilePath;
    private Long mAuther;
    private Date mDate;
    public FileRec(){};

    public  FileRec(File file){
        //this.mFileName = file.getName();
        //this.mFilePath = file.getPath();         //完整路径
        this.mFilesize = file.length()/1024;
        //this.mFileClass = getParent(file);     //父目录
        this.mDate = Date.valueOf(LocalDate.now());
    }

    @Id
    @Column(name = "fileId")
    public int getFileId() {
        return mFileId;
    }

    public void setFileId(int fileId) {
        mFileId = fileId;
    }

    @Basic
    @Column(name = "fileName")
    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    @Basic
    @Column(name = "filesize")
    public double getFilesize() {
        return mFilesize;
    }

    public void setFilesize(double filesize) {
        mFilesize = filesize;
    }

    @Basic
    @Column(name = "fileClass")
    public String getFileClass() {
        return mFileClass;
    }

    public void setFileClass(String fileClass) {
        mFileClass = fileClass;
    }

    @Basic
    @Column(name = "filePath")
    public String getFilePath() {
        return mFilePath;
    }

    public void setFilePath(String filePath) {
        mFilePath = filePath;
    }

    @Basic
    @Column(name = "auther")
    public Long getAuther() {
        return mAuther;
    }

    public void setAuther(long auther) {
        mAuther = auther;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileRec fileRec = (FileRec) o;
        return mFileId == fileRec.mFileId &&
                Double.compare(fileRec.mFilesize, mFilesize) == 0 &&
                Objects.equals(mFileName, fileRec.mFileName) &&
                Objects.equals(mFileClass, fileRec.mFileClass) &&
                Objects.equals(mFilePath, fileRec.mFilePath) &&
                Objects.equals(mAuther, fileRec.mAuther) &&
                Objects.equals(mDate, fileRec.mDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mFileId, mFileName, mFilesize, mFileClass, mFilePath, mAuther, mDate);
    }

    public String getParent(File file){
         String splitSTR = "//";
        String[] strings = file.getParent().split(splitSTR);
        return strings[strings.length-1];
    }
}
