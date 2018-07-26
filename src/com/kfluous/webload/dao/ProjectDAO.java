package com.kfluous.webload.dao;

import com.kfluous.webload.domain.Project;

import java.util.List;

public interface ProjectDAO {
    Project GetProjectById(int id); //

    List<Project> ListALLProject();

    boolean AddProject(Project project);

    boolean UpdateProject(Project project);

    boolean DeleteProject(Project project);
}
