package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 0);
        pageNum +=1;

        //获取参数
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //插入数据库
        bookService.addBook(book);
        //请求重定向
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + pageNum);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的id
        String id = request.getParameter("id");
        int i = WebUtils.parseInt(id, 0);

        //数据库删除
        int i1 = bookService.deleteBookById(i);

        //请求重定向
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //进行修改后的数据,id不会改变,有人发送到这里就行
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //数据库
        bookService.updateBook(book);
        //重定向
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page");

    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.queryBook();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要显示的数据的id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //查询指定的数据
        Book book = bookService.queryBookById(id);
        //发送到修改页面
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        int pageNum = WebUtils.parseInt(request.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //封装到Page,返回Page对象
        Page<Book> bookPage = bookService.page(pageNum, pageSize);
        bookPage.setUrl("manager/bookServlet?action=page");

        //发送到请求域
        request.setAttribute("page", bookPage);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
