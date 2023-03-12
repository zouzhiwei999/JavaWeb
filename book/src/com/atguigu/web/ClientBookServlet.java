package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //封装到Page,返回Page对象
        Page<Book> bookPage = bookService.page(pageNum, pageSize);
        bookPage.setUrl("client/bookServlet?action=page");

        //发送到请求域
        request.setAttribute("page", bookPage);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    protected void pageForPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求参数
        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);

        //封装到Page,有筛选条件的返回Page对象
        Page<Book> bookPage = bookService.pageForPrice(pageNum, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageForPrice");
        if (request.getParameter("min") != null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max") != null){
            sb.append("&max=").append(request.getParameter("max"));
        }

        bookPage.setUrl(new String(sb));

        //发送到请求域
        request.setAttribute("page", bookPage);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
