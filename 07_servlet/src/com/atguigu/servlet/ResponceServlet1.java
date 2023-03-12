package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ResponceServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了responce1");
//        response.setStatus(302);
////        response.setHeader("Location", "http://localhost:8080/07_servlet/responceServlet2");
//        response.setHeader("Location", "http://www.baidu.com");

        //方式2
//        response.sendRedirect("http://www.baidu.com");
        response.sendRedirect("/07_servlet/responceServlet2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
