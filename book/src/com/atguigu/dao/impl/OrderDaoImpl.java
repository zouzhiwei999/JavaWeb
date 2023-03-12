package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/1 1:02
 */

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id, create_time, price, status, user_id) values(?,?,?,?,?) ";
        int update = update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
        return update;
    }
}
