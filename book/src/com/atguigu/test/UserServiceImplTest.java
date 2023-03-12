package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(1, "zzw", "123456", "1830560034@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(1, "zzw", "123456", "")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("zzw")){
            System.out.println("用户名已经存在");
        }else {
            System.out.println("用户名不存在");
        }

    }
}