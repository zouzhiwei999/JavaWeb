package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();


    //退出登录
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

//        response.setHeader("Content-Type","text/html;charset=UTF-8");
//        response.setContentType("text/html;charset=UTF-8");

        //获取登录参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //查询
        User user = userService.login(new User(null, username, password, null));

        //如果有返回值,转发到成功页面
        if (user != null){
            System.out.println("登陆成功");
            //如果登录成功,在session域传入用户信息
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            //没有,重新登录
            request.setAttribute("msg", "您的账号或密码错误");
            request.setAttribute("username", username);
            System.out.println("账号或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean b = userService.existsUsername(username);
        //将返回数据放进map
        Map<String, Object> map = new HashMap<>();
        map.put("existsUsername",b);

        //返回json形式
        Gson gson = new Gson();
        String s = gson.toJson(map);

        response.getWriter().write(s);

    }



    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repwd = request.getParameter("repwd");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());

        if (token != null && code.equalsIgnoreCase(token)){
            //如果用户名不存在
            if (userService.existsUsername(username)){
                //已经存在
                request.setAttribute("msg", "用户名已被使用");
                request.setAttribute("username", username);
                request.setAttribute("email", email);


                System.out.println("用户名" + username + "已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //不存在,注册
                userService.registUser(new User(1, username, password, email));
                //跳转
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("repwd", repwd);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }


}
