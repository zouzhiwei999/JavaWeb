package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintStream;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");


        //获取登录参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //查询
        User login = userService.login(new User(0, username, password, null));

        //如果有返回值,转发到成功页面
        if (login != null){
            System.out.println("登陆成功");
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            //没有,重新登录
            request.setAttribute("msg", "您的账号或密码错误");
            request.setAttribute("username", username);
            System.out.println("账号或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }


    }
}
