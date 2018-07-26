package com.kfluous.webload.action;

import com.kfluous.webload.Constant;
import com.kfluous.webload.domain.Student;
import com.kfluous.webload.service.Impl.UserServiceImpl;
import com.kfluous.webload.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
    private String username;
    private String password;
    private String updatepassword;

    @Autowired
    private UserService mUserService;


    public String login(){
        System.out.println("UserService"+mUserService);
        Student student=mUserService.loginByIdandPwd(username,password);
        if(student!=null) {
            ActionContext.getContext().getSession().put(Constant.USER,student);
            return "toIndex";
        }
        else
            return "AccountNotFound";
    }

    public String changePwd(){
        Student mStudent= (Student) ActionContext.getContext().getSession().get(Constant.USER);
        mUserService.ChangePwd(mStudent,updatepassword);
        return SUCCESS;
    }

    public String logout(){
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }






    //Getter and Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUpdatepassword() {
        return updatepassword;
    }

    public void setUpdatepassword(String updatepassword) {
        this.updatepassword = updatepassword;
    }
}
