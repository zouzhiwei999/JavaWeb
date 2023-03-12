package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
/*
 *  
 * 
 * @author zzw
 * @date 2023/2/24 23:37
 * @param 
 * @return 
 */

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("用户名:" + name);
        System.out.println("密码:" + password);
        System.out.println("兴趣" + Arrays.asList(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("用户名:" + name);
        System.out.println("密码:" + password);
        System.out.println("兴趣" + Arrays.asList(hobbies));
    }
}
