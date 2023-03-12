package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean aNew = session.isNew();
        String id = session.getId();

        response.getWriter().write("得到了session:" + session + "<br/>");
        response.getWriter().write("是否是新的:" + aNew + "<br/>");
        response.getWriter().write("session的id:" + id + "<br/>");
    }

    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("sessionKey", "sessionValue");
        response.getWriter().write("设置了session的值");
    }

    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object sessionKey = request.getSession().getAttribute("sessionKey");
        response.getWriter().write("获取了session的值" + sessionKey);
    }

    //Session的默认超时及配置
    protected void defaultlive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();

        response.getWriter().write("Session的默认超时及配置" + maxInactiveInterval);
    }

    //Session3秒超时销毁
    protected void live3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setMaxInactiveInterval(3);
        response.getWriter().write("Session3秒超时销毁" + request.getSession().getMaxInactiveInterval());
    }

    //Session马上销毁
    protected void deletenow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.getWriter().write("Session马上销毁" + request.getSession());
    }


    }
