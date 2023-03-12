package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取购物车信息
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        //获取用户ID
        User user = (User) request.getSession().getAttribute("user");


        if (user == null){
            //如果还没有登陆，生成不了订单号,转发到登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }

        Integer id = user.getId();

        //创建订单需要购物车和用户ID,返回订单号
        String orderId = null;
        orderId = orderService.createOrder(cart, id);

        //存在request域中
        request.setAttribute("orderId", orderId);

        //转发到结算页面
        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);

    }


}
