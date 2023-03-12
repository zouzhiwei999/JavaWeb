package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserForUsername() {
        User user = userDao.queryUserForUsername("杜甫");
        System.out.println(user);

    }

    @Test
    public void save() {
        int i = userDao.save(new User(0, "杜甫", "5201314", "DuFu@163.com"));
        System.out.println("插入" + i + "条用户信息");
    }

    @Test
    public void queryUserForUsernameAndPassword() {
        User user = userDao.queryUserForUsernameAndPassword("杜甫", "520314");
        System.out.println(user);

    }
}