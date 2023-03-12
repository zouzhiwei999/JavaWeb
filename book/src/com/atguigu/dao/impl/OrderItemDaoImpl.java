package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/1 1:27
 */

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`, count, price, total_price, order_id) values(?,?,?,?,?) ";
        int update = update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
        return update;
    }
}
