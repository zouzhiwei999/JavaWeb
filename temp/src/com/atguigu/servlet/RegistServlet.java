package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/29 2:09
 */

public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取验证码
        String attribute = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String user = req.getParameter("user");
        String code = req.getParameter("code");

        if (attribute != null && attribute.equalsIgnoreCase(code)){
            System.out.println(user + "保存到了数据库");
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
        } else {
            System.out.println("请不要重复提交");
        }
    }
}
