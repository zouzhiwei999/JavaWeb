package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();
    @Test
    public void existsUsername() {
        boolean b = userService.existsUsername("辛弃疾");
        System.out.println("辛弃疾是否已经被使用:" + b);
    }

    @Test
    public void regist() {
        userService.regist(new User(0, "辛弃疾", "1749394", "XinQiJi@163.com"));

    }

    @Test
    public void login() {
        User user = userService.login("辛弃疾", "1749394");
        System.out.println(user);
    }
}