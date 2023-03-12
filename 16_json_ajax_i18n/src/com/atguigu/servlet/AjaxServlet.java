package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/3 1:34
 */

public class AjaxServlet extends BaseServlet{

    protected void returnAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person(1, "年末");
        Gson gson = new Gson();
        String s = gson.toJson(person,Person.class);

        resp.getWriter().write(s);
    }
    protected void jQueryAjxa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person(1, "年末");
        Gson gson = new Gson();
        String s = gson.toJson(person,Person.class);

        resp.getWriter().write(s);

    }
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person(1, "jQueryGet方法");
        Gson gson = new Gson();
        String s = gson.toJson(person,Person.class);

        resp.getWriter().write(s);

    }
    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person(1, "jQueryPost方法");
        Gson gson = new Gson();
        String s = gson.toJson(person,Person.class);

        resp.getWriter().write(s);

    }

    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Person person = new Person(1, "jQueryGetJSON方法");
        Gson gson = new Gson();
        String s = gson.toJson(person,Person.class);

        resp.getWriter().write(s);

        System.out.println("jQueryGetJSON");

    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        System.out.println("username: " + username + "password: " + password);

    }


}
