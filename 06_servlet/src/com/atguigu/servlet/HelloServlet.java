package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/17 0:17
 */

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("先调用构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init调用");
        System.out.println("获取初始化参数" + servletConfig.getInitParameter("username"));
        System.out.println("获取ServletContext" + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String method = httpServletRequest.getMethod();

        if ("get".equalsIgnoreCase(method)){
            doGet();
        }else if ("post".equalsIgnoreCase(method)){
            doPost();
        }


    }

    public void doGet(){
        System.out.println("get请求");
    }

    public void doPost(){
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy调用");
    }
}
