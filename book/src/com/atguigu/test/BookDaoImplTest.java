package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        int i = bookDao.addBook(new Book(null, "妇科圣手", "zzw", new BigDecimal(4545), 154, 1, null));
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        int i = bookDao.updateBook(new Book(21, "妇科圣手", "zzw", new BigDecimal(4545), 154, 1, "static/img/default.jpg"));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBook() {
        List<Book> books = bookDao.queryBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotal() {
        System.out.println(bookDao.queryForPageTotal());
    }

    @Test
    public void queryForPageItems() {
        for (Book queryForPageItem : bookDao.queryForPageItems(0, 4)) {
            System.out.println(queryForPageItem);
        }
    }

    @Test
    public void queryForPageTotalForPrice() {
        System.out.println(bookDao.queryForPageTotalForPrice(0, 50));
    }

    @Test
    public void queryForPageItemsForPrice() {
        for (Book book : bookDao.queryForPageItemsForPrice(1, 4, 0, 50)) {
            System.out.println(book);

        }
    }
}