package com.kfluous.webload.dao.Impl;

import com.kfluous.webload.dao.BaseDAO;
import com.kfluous.webload.dao.ProjectDAO;
import com.kfluous.webload.domain.Project;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("restriction")
@Repository
@Transactional
public class ProjectDAOImpl extends BaseDAO implements ProjectDAO {
    @Override
    public Project GetProjectById(int id) {
        Project p = (Project) getSession().get(Project.class, id);
        return p;
    }

    @Override
    public List<Project> ListALLProject() {
        List<Project> achieve = null;
        String hql = "FROM Project p ORDER BY p.date DESC";
        achieve = getSession().createQuery(hql).list();
        return achieve;
    }

    @Override
    public boolean AddProject(Project project) {
        getSession().save(project);
        return true;
    }

    @Override
    public boolean UpdateProject(Project project) {

        getSession().update(project);
        return true;
    }

    @Override
    public boolean DeleteProject(Project project) {
        getSession().delete(project);
        return true;

    }
}
