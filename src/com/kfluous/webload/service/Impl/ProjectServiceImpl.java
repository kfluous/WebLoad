package com.kfluous.webload.service.Impl;

import com.kfluous.webload.dao.Impl.ProjectDAOImpl;
import com.kfluous.webload.dao.ProjectDAO;
import com.kfluous.webload.domain.Project;
import com.kfluous.webload.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO mProjectDAO;

    @Override
    public List<Project> AllProject() {
        return mProjectDAO.ListALLProject();
    }

    @Override
    public boolean AddNewProject(Project project) {
        return mProjectDAO.AddProject(project);
    }

    @Override
    public boolean DeleteProject(Project project) {
        return mProjectDAO.DeleteProject(project);
    }

    @Override
    public boolean UpdateProject(Project project) {
        return mProjectDAO.UpdateProject(project);
    }

    @Override
    public Project getProjectById(int id) {
        return mProjectDAO.GetProjectById(id);
    }
}
