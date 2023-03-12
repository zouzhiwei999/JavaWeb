package com.atguigu.dao;

import com.atguigu.pojo.User;
import com.atguigu.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/19 19:50
 */

public class UserDaoImpl extends BaseDao<User> implements UserDao{

    @Override
    public User queryUserForUsername(String name) {
        String sql = "select username,password,email from t_user where username = ?";
        User user = query(User.class, sql, name);
        return user;
    }

    @Override
    public int save(User user) {
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        int update = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update;
    }

    @Override
    public User queryUserForUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        User query = query(User.class, sql, username, password);
        return query;
    }
}
