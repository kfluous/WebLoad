package com.kfluous.webload.filter;

import com.kfluous.webload.Constant;
import com.kfluous.webload.service.Impl.ProjectServiceImpl;
import com.kfluous.webload.service.ProjectService;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UploadFilter extends HttpServlet  implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        ProjectService projectService = new ProjectServiceImpl();

        int project_id =Integer.parseInt(request.getParameter("project_id"));
        String Author = request.getParameter(Constant.USER);
        String fileName = request.getParameter("filenameFileName");
        String ProjectName = projectService.getProjectById(project_id).getProjectname();
        System.out.println("Author "+Author+",fileName "+fileName+",project_id "+project_id);
    }
}
