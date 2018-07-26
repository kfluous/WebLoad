package com.kfluous.webload.domain;

import java.io.File;
import java.util.Calendar;

public class myFile  {
    private int fileId;
    private String fileName;
    private float fileSize;
    private String fileClass;
    private String filePath;
    private String author;
    private Calendar date;

    public myFile(){

    };

    public  myFile(File file){
        this.fileName = file.getName();
        this.filePath = file.getPath();
        this.fileSize = file.getTotalSpace();
        this.fileClass = file.getParent();
        this.date = Calendar.getInstance();
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String  getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public float getFileSize() {
        return fileSize;
    }

    public void setFileSize(float fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileClass() {
        return fileClass;
    }

    public void setFileClass(String fileClass) {
        this.fileClass = fileClass;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
