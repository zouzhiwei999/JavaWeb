package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    //用户名是否已经被使用
    public boolean existsUsername(String username);

    //注册
    public void regist(User user);

    //登录
    public User login(String username, String password);

}
