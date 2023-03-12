package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //账号密码是否为零
        if (username == null &&"".equals(username) ) {
            response.getWriter().write("账号为空");
        }

        if (password == null&& "".equals(password)) {
            response.getWriter().write("密码为空");
        }

        if (username.equals("zzw") && password.equals("123456")) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            response.getWriter().write("Cookie保存了");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
