package com.kfluous.webload.filter;



import com.kfluous.webload.Constant;
import com.kfluous.webload.domain.Student;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter extends HttpServlet implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String url=request.getServletPath();
        String contextPath=request.getContextPath();

        System.out.println("url="+url);
        //判断当前请求地址是否是登录的请求地址
        if(!(url.contains("login")||url.contains("toindex.jsp"))){
            //非登录请求
            if(request.getSession().getAttribute(Constant.USER) != null){
                //说明已经登录过
                System.out.println("已经登录");
                filterChain.doFilter(request, response);
            } else {
                System.out.println("没有登录，跳转到登录页面");
                //没有登录，跳转到登录页面
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else {
            //登录请求；直接放行
            System.out.println("登录请求");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
