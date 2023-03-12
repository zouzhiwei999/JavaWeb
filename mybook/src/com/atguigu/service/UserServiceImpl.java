package com.atguigu.service;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;
import com.atguigu.pojo.User;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/19 20:25
 */

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean existsUsername(String name) {
        User user = userDao.queryUserForUsername(name);
        return user != null;
    }

    @Override
    public void regist(User user) {
        int save = userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        User u = userDao.queryUserForUsernameAndPassword(username, password);
        return u;
    }
}
