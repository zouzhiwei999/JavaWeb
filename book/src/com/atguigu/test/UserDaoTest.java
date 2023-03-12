package com.atguigu.test;

import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserForUsername() {
        if (userDao.queryUserForUsername("admin") == null){
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(1, "admin", "123456", "adxa@qq.com")));
    }

    @Test
    public void queryUserForUsernameAndPassword() {
        if (userDao.queryUserForUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("成功");
        }
    }
}