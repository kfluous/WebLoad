package com.kfluous.webload.action;

import com.kfluous.webload.Constant;
import com.kfluous.webload.domain.FileRec;
import com.kfluous.webload.domain.Project;
import com.kfluous.webload.domain.Student;
import com.kfluous.webload.service.FileService;
import com.kfluous.webload.service.Impl.FileServiceImpl;
import com.kfluous.webload.service.Impl.ProjectServiceImpl;
import com.kfluous.webload.service.ProjectService;
import com.kfluous.webload.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.io.File;
import java.util.List;
import java.util.Map;

@Controller
public class FileAction extends ActionSupport{
    private File filename;
    private String filenameContentType;
    private String filenameFileName;
    private int fileId;
    private int project_id;

    private Student mStudent;
    private FileRec mFileRec;

    @Autowired
    private FileService fileService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    public String upload(){
        mStudent= (Student) ActionContext.getContext().getSession().get(Constant.USER);
        System.out.println("Action:upload");
        mFileRec =new FileRec(filename);
        System.out.println("file size:"+filename.length());
        if(fileService.uploadFile(filename,initFile(mFileRec))){
            return SUCCESS;
        }
        return ERROR;
    }


    public String StuNoFIle(){
        List<Student> StuNoFIle =   userService.showStuNoFile(fileClass(project_id));
        ActionContext ac = ActionContext.getContext();
        ac.put("StuNoFIle",StuNoFIle);
        return "StuNoFIle";
    }

    //按路径归档获取List
    public String ClassAchieve(){
        List<FileRec> fileList =   fileService.FileList(fileClass(project_id));
        ActionContext ac = ActionContext.getContext();
        ac.put("classfileList",fileList);
        return "classlist";
    }
    //按上传者获取List
    public String UserAchieve(){
        System.out.println("Action UserAchieve");
        ActionContext ac = ActionContext.getContext();
        mStudent= (Student) ActionContext.getContext().getSession().get(Constant.USER);
        List<FileRec> fileList = fileService.MyFileList(mStudent);
        ac.put("userfileList",fileList);
        return "userlist";
    }



    public String delete_file(){
        System.out.println("Action delete_file");
        if(fileService.deleteMyFile(fileId)){
            return SUCCESS;
        }
        System.out.println("error");
        return ERROR;
    }


    public String file_same(){

        return ERROR;
    }
    public File getFilename() {
        return filename;
    }

    public void setFilename(File filename) {
        this.filename = filename;
    }

    public String getFilenameContentType() {
        return filenameContentType;
    }

    public void setFilenameContentType(String filenameContentType) {
        this.filenameContentType = filenameContentType;
    }

    public String getFilenameFileName() {
        return filenameFileName;
    }

    public void setFilenameFileName(String filenameName) {
        this.filenameFileName = filenameName;
    }


    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public Student getStudent() {
        return mStudent;
    }

    public void setStudent(Student student) {
        mStudent = student;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public FileRec initFile(FileRec fileRec){
        fileRec.setAuther(mStudent.getSid());
        fileRec.setFileName(filenameFileName);
        System.out.println("initFile"+filenameFileName);
        Project project = projectService.getProjectById(project_id);
        fileRec.setFileClass(project.getProjectname());//关联文件路径  可改 TODO
        return fileRec;
    }

    public String fileClass(int project_id){
        Project project = projectService.getProjectById(project_id);
        return project.getProjectname();
    }
}
