package com.atguigu.service.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.BookService;
import com.atguigu.service.OrderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/1 2:14
 */

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookService bookService = new BookServiceImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        int i = 1 / 0;

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookService.queryBookById(cartItem.getId());
            book.setSales( book.getSales() + cartItem.getCount());
            book.setStock( book.getStock() - cartItem.getCount());
            bookService.updateBook(book);

        }

        cart.clear();
        return orderId;
    }
}
