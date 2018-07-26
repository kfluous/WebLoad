package com.kfluous.webload.action;


import com.kfluous.webload.domain.Project;
import com.kfluous.webload.service.Impl.ProjectServiceImpl;
import com.kfluous.webload.service.ProjectService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ProjectAction extends ActionSupport {
    @Autowired
    private ProjectService mProjectService;



    public String toAchieve(){
        System.out.println("ProjectAction toAchieve");
        List<Project> toAchieve =mProjectService.AllProject();
        ActionContext ac =ActionContext.getContext();
        ac.put("toAchieve",toAchieve);
        return "toAchieve";
    }

    public String achieveAll(){
        System.out.println("ProjectAction toAchieve");
        List<Project> achieveAll =mProjectService.AllProject();
        ActionContext ac =ActionContext.getContext();
        ac.put("achieveAll",achieveAll);
        return "achieveAll";
    }

    public String nerWorr(){
        return null;
    }

}
