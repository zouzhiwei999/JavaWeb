package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 19:19
 */

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBook() {
        return bookDao.queryBook();
    }

    @Override
    public Page<Book> page(int pageNum, int pageSize) {
        //返回Page对象
        Page<Book> bookPage = new Page<>();

        //设置总记录
        Integer integer = bookDao.queryForPageTotal();
        bookPage.setPageTotalCount(integer);
        //设置页容量
        bookPage.setPageSiza(bookPage.getPageSiza());
        //设置总页码
        Integer pageTotal = integer / pageSize;
        if (integer % pageSize > 0){
            pageTotal += 1;
        }
        bookPage.setPageTotal(pageTotal);

        if (pageNum < 1){
            pageNum = 1;
        } else if (pageNum > pageTotal) {
            pageNum = pageTotal;
        }

        //设置当前页码
        bookPage.setPageNum(pageNum);

        //设置内容
        int begin = (pageNum-1)*pageSize;
        List<Book> books = bookDao.queryForPageItems(begin, pageSize);
        bookPage.setItems(books);

        return bookPage;
    }

    @Override
    public Page<Book> pageForPrice(int pageNum, int pageSize, int min, int max) {
        //返回Page对象
        Page<Book> bookPage = new Page<>();

        //设置总记录
        Integer integer = bookDao.queryForPageTotalForPrice(min, max);
        bookPage.setPageTotalCount(integer);
        //设置页容量
        bookPage.setPageSiza(pageSize);
        //设置总页码
        Integer pageTotal = integer / pageSize;
        if (integer % pageSize > 0){
            pageTotal += 1;
        }
        bookPage.setPageTotal(pageTotal);

        if (pageNum < 1){
            pageNum = 1;
        } else if (pageNum > pageTotal) {
            pageNum = pageTotal;
        }

        //设置当前页码
        bookPage.setPageNum(pageNum);

        //设置内容
        int begin = (pageNum-1)*pageSize;
        List<Book> books = bookDao.queryForPageItemsForPrice(begin, pageSize, min, max);
        bookPage.setItems(books);

        return bookPage;
    }
}
