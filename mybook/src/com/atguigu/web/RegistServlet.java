package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        //如果验证码正确
        if ("abc".equalsIgnoreCase(code)){
            //用户名是否已经被使用
            if (userService.existsUsername(username)){
                //如果被使用,重新注册
                System.out.println(username + " 已经被注册");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
            } else {
                //如果不被使用,转发到注册成功页面
                userService.regist(new User(0, username, password, email));
                System.out.println(username + " 注册成功");
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
            }
        } else {
            //如果验证码错误,重新注册
            request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
        }
    }
}
