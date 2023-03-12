package com.atguigu.dao.impl;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.*;
import java.sql.*;
import java.util.List;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/18 22:56
 */

public class BaseDao<T> {

    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> c;
    {
        Class aClass = this.getClass();
        Type genericSuperclass = aClass.getGenericSuperclass();
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
        c = (Class<T>) actualTypeArguments[0];
    }

    //通用的修改(增删改)方法
    public int update( String sql, Object ...args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            int update = queryRunner.update(connection, sql, args);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }

    }

    //通用的单行查询方法
    public <T> T query(Class<T> c,String sql, Object ...args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            BeanHandler<T> BeanHandler = new BeanHandler<>(c);

            return queryRunner.query(connection, sql, BeanHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    //通用的多行查询方法
    public <T> List<T> queryList(Class<T> c,String sql, Object ...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            BeanListHandler<T> tBeanListHandler = new BeanListHandler<>(c);

            return queryRunner.query(connection, sql, tBeanListHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);

        }
    }

    //通用的特殊值查询
    public <E> E queryForSingleValue(String sql, Object ...args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            ScalarHandler scalarHandler = new ScalarHandler();

            Object query = queryRunner.query(connection, sql, scalarHandler, args);
            return (E) query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

}
