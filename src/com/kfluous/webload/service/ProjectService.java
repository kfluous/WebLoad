package com.kfluous.webload.service;

import com.kfluous.webload.domain.Project;

import java.util.List;

public interface ProjectService {
    List<Project> AllProject();
    boolean AddNewProject(Project project);
    boolean DeleteProject(Project project);
    boolean UpdateProject(Project project);

    Project getProjectById(int id);
}
