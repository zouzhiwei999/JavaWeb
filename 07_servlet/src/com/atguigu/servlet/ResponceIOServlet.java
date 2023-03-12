package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponceIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //方案一：（不推荐）
//        //设置服务器字符集
//        response.setCharacterEncoding("UTF-8");
//
//        //设置浏览器字符集
//        response.setHeader("Content-Type","text/html;charset=UTF-8");

        //方案二：（推荐）
        response.setContentType("text/html;charset=UTF-8");

        System.out.println(response.getCharacterEncoding());

        PrintWriter writer = response.getWriter();
        writer.write("你妹的");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
