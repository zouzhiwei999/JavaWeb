package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        //获取attribute值
        System.out.println("获取Attribute值:" + servletContext.getAttribute("key"));

        //设置attribute值
        servletContext.setAttribute("key", "value");

        //再次获取
        System.out.println("获取Attribute值:" + servletContext.getAttribute("key"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
