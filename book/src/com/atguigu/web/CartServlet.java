package com.atguigu.web;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/30 12:37
 */

public class CartServlet extends BaseServlet {

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        System.out.println(id);

        //获取商品信息封装到购物车
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = bookDao.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        //将商品信息放进购物车,购物车信心储存在Session域
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);


        String referer = req.getHeader("Referer");
        System.out.println(referer);

        //跳转回原有页面
        resp.sendRedirect(referer);

        req.getSession().setAttribute("lastName", book.getName());
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        System.out.println(id);

        //获取商品信息封装到购物车
        BookDaoImpl bookDao = new BookDaoImpl();
        Book book = bookDao.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        //将商品信息放进购物车,购物车信心储存在Session域
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName", cartItem.getName());

        Map<String, Object> map = new HashMap<>();

        map.put("totalCount", cart.getTotalCount());
        map.put("lastName", cartItem.getName());

        Gson gson = new Gson();
        String s = gson.toJson(map);

        resp.getWriter().write(s);


    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要删除的id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //判断要删除的id的商品是否存在
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.delete(id);
        }

        String referer = req.getHeader("Referer");
        System.out.println(referer);

        //跳转回原有页面
        resp.sendRedirect(referer);

    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }

        String referer = req.getHeader("Referer");
        System.out.println(referer);

        //跳转回原有页面
        resp.sendRedirect(referer);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            cart.updateCount(id, count);
        }

        String referer = req.getHeader("Referer");
        System.out.println(referer);

        //跳转回原有页面
        resp.sendRedirect(referer);

    }
}