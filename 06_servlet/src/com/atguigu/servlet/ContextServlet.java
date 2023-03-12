package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();

        System.out.println(servletContext.getInitParameter("username"));//   上下文
        System.out.println(servletContext.getContextPath());//   /06_servlet
        System.out.println(servletContext.getRealPath("/"));//  C:\Users\AAA\IdeaProjects\JavaWeb\out\artifacts\06_servlet_war_exploded\
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
