package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/*
 *
 *
 * @author zzw
 * @date 2023/2/25 14:42
 * @param
 * @return
 */

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String username = request.getParameter("username");
        System.out.println("获取了参数:" + username);

        //盖章，设置属性
        request.setAttribute("key", "root");
        System.out.println("柜台盖章了");

        //获取重定向
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/form.html");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");

        //重定向发送
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
