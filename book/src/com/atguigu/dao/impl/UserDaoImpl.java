package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/19 0:55
 */

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    
    /**
    * @Author: zzw
    * @Description: 返回查询的用户
    * @DateTime: 2022/4/19 1:29
    * @Params: username 用户名
    */
    @Override
    public com.atguigu.pojo.User queryUserForUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return query(User.class, sql, username);
    }

    /*
     *
     *
     * @author zzw
     * @date 2022/4/19 1:53
     * @param 传入用户名
     * @return 返回条目数
     */
    @Override
    public int saveUser(com.atguigu.pojo.User user) {
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    /*
     *
     *
     * @author zzw
     * @date 2022/5/12 11:49
     * @param [username, password]
     * @return com.atguigu.pojo.User
     * 判断用户是否存在
     */
    @Override
    public com.atguigu.pojo.User queryUserForUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return query(User.class, sql, username,password);
    }
}
