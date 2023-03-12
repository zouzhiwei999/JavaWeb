package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AOA
 * @version 1.0
 * @description: 创建Cookie
 * @date 2022/4/27 14:38
 */

public class CookieServlet extends BaseServlet{

    //修改Cookie
    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方案一
//        Cookie cookie = new Cookie("key2", "newvalue2");
//
//        response.addCookie(cookie);

        //方案二
        Cookie cookie = CookieUtils.findCookie("key2", request.getCookies());

        if (cookie != null){
            cookie.setValue("wdnmd");
            response.addCookie(cookie);
            response.getWriter().write("方案二");
        }
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要立即删除的cookie
        Cookie key2 = CookieUtils.findCookie("key2", request.getCookies());
        //设置生命周期
        if (key2 != null) {
            key2.setMaxAge(0);
            response.addCookie(key2);
            response.getWriter().write(key2.getName() + "被删除了");
        }
    }

    protected void live3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要立即删除的cookie
        Cookie key2 = new Cookie("cookie01","live3600");
        //设置生命周期
        if (key2 != null) {
            key2.setMaxAge(60);
            response.addCookie(key2);
            response.getWriter().write(key2.getName() + "被删除了");
        }
    }

    /*
     *  创建Cookie对象
     *
     * @author zzw
     * @date 2023/3/1 16:03
     * @param [request, response]
     * @return void
     */
    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("key2", "value2");
        response.addCookie(cookie);

        Cookie cookie1 = new Cookie("key3", "value3");
        response.addCookie(cookie1);

        response.addCookie(cookie);
        response.addCookie(cookie1);

        response.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            response.getWriter().write(cookie.getName() + "=" + cookie.getValue() + "<br/>");
        }

        Cookie cookiefind = CookieUtils.findCookie("key2", cookies);

        if(cookiefind != null){
            response.getWriter().write("找到了需要的cookie");
        }

    }
}
