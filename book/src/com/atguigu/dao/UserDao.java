package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {


    public User queryUserForUsername(String username);

    public int saveUser(User user);

    public User queryUserForUsernameAndPassword(String username, String password);
}
