package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/*
 *
 *
 * @author zzw
 * @date 2023/2/25 14:42
 * @param
 * @return
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        System.out.println("获取了参数:" + username);

        //是否盖章，获取属性
        Object key = request.getAttribute("key");
        System.out.println("柜台1盖章了:" + key);

        System.out.println("柜台2处理自己的事务");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
