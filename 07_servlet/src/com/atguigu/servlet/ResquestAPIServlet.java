package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/*
 *  
 * 
 * @author zzw
 * @date 2023/2/24 23:16
 * @param 
 * @return 
 */

public class ResquestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //URI 请求的资源路径
        System.out.println("URI 请求的资源路径" + request.getRequestURI());

        //URL 请求的全局资源定位符
        System.out.println("URL 请求的绝对资源路径" + request.getRequestURL());

        //发起请求的的客户端
        System.out.println("发起请求的的客户端" + request.getRemoteHost());

        //请求头
        System.out.println(request.getHeader("User-Agent"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
