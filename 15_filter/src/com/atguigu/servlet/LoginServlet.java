package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断是否正确
        if ("zzw123".equals(username) && "123456".equals(password)) {
            System.out.println("密码正确");
            request.getSession().setAttribute("username", username);
            response.getWriter().write("你已成功登陆");

        } else {
            System.out.println("密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
