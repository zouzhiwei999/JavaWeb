package com.atguigu.utils;

import javax.servlet.http.Cookie;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/27 22:27
 */

public class CookieUtils {
    public static Cookie findCookie(String name, Cookie[] cookies){

        for (Cookie cookie : cookies) {
            if (name == null || cookies == null || cookies.length == 0){
                return null;
            }

            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
