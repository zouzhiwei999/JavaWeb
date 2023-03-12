package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"盗墓笔记",new Integer(1),new BigDecimal(10),new BigDecimal(10)));
        System.out.println(cart);
    }

    @Test
    public void delete() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"盗墓笔记",new Integer(1),new BigDecimal(10),new BigDecimal(10)));
        cart.delete(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"盗墓笔记",new Integer(1),new BigDecimal(10),new BigDecimal(10)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"龙族",new Integer(1),new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"盗墓笔记",new Integer(1),new BigDecimal(10),new BigDecimal(10)));
        cart.updateCount(1, 3);
        System.out.println(cart);
    }
}