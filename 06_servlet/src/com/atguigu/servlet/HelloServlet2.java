package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/17 11:33
 */

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("调用了init方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletConfig servletConfig = getServletConfig();
        String servletName = servletConfig.getServletName();
        String name = servletConfig.getInitParameter("username");

        ServletContext servletContext = servletConfig.getServletContext();

        System.out.println("程序别名" + servletName);
        System.out.println("初始化参数:" + name);
        System.out.println("servletContext=" + servletContext);

        System.out.println("通过get方法请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("通过post方法请求");
    }
}
