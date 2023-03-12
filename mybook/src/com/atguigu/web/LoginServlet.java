package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //验证是否登录成功
        User user = userService.login(username, password);
        if (user != null){
            //存在，转发成功页面
            System.out.println(username + "登录成功");
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request, response);
        } else {
            //不存在，重新登录
            System.out.println(username + "登陆失败，请重新登录");
            request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
        }
    }
}
