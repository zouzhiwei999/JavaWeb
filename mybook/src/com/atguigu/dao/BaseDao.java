package com.atguigu.dao;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @author AOA
 * @version 1.0
 * @description: 通用的查询方法
 * @date 2022/4/19 19:28
 */

public class BaseDao<T> {

    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> c;
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType genericSuperclass1 = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = genericSuperclass1.getActualTypeArguments();
        c = (Class<T>)actualTypeArguments[0];
    }

    //通用的增删改操作
    public int update(String sql,Object ...args){
        Connection conn = null;
        int update = 0;
        try {
            conn = JDBCUtils.getConnection();
            update = queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return update;
    }

    //通用的查询单条数据
    public <T> T query(Class<T> c,String sql, Object ...args){
        Connection conn = null;
        BeanHandler<T> tBeanHandler = new BeanHandler<>(c);
        T query = null;
        try {
            conn = JDBCUtils.getConnection();
            query = queryRunner.query(conn, sql, tBeanHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return query;
    }

    //通用的查询多条数据
    public <T> List<T> queryForList(Class<T> c,String sql, Object ...args){
        Connection conn = null;
        BeanListHandler<T> tBeanListHandler = new BeanListHandler<>(c);
        List<T> query = null;
        try {
            conn = JDBCUtils.getConnection();
            query = queryRunner.query(conn, sql, tBeanListHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return query;
    }

    //返回特殊的值
    public <E> E queryForSingleValue(String sql, Object ...args){
        Connection conn = null;
        ScalarHandler scalarHandler = new ScalarHandler();
        Object query = null;
        try {
            conn = JDBCUtils.getConnection();
            query = queryRunner.query(conn, sql, scalarHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn);
        }
        return (E) query;
    }
}
