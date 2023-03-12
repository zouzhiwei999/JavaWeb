package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author AOA
 * @version 1.0
 * @description: 制定操作规范
 * @date 2022/4/19 19:45
 */

public interface UserDao {
    //查询顾客是否存在，返回用户信息
    public User queryUserForUsername(String name);

    //存入一个用户信息,返回存入条目数
    public int save(User user);

    //登录，验证账号密码是否正确，返回用户信息
    public User queryUserForUsernameAndPassword(String username, String password);
}
