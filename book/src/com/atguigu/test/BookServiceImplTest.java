package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.util.List;
import java.util.PrimitiveIterator;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        int i = bookService.addBook(new Book(null, "草拟吗", "傻逼", new BigDecimal(656), 100, 1, null));
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        int i = bookService.updateBook(new Book(22, "草拟吗", "傻逼", new BigDecimal(656), 101, 0, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
        int i = bookService.deleteBookById(22);
        System.out.println(i);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(5);
        System.out.println(book);
    }

    @Test
    public void queryBook() {
        for (Book book : bookService.queryBook()) {
            System.out.println(book);

        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, 2));
    }

    @Test
    public void pageForPrice() {
        System.out.println(bookService.pageForPrice(1, 4, 0, 50));
    }
}