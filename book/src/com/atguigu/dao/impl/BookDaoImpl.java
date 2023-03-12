package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/25 18:23
 */

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?, price = ?, author = ?, sales = ?, stock = ?, img_path = ? where id = ?";
        return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where id = ?";
        return query(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBook() {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotal() {
        String sql = "select count(*) from t_book";
        Number o = (Number) queryForSingleValue(sql);
        return o.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,? ";
        return queryList(Book.class, sql, begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalForPrice(int min,int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number o = (Number) queryForSingleValue(sql, min, max);
        return o.intValue();
    }

    @Override
    public List<Book> queryForPageItemsForPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where price between ? and ? order by price limit ?,? ";
        return queryList(Book.class, sql, min, max, begin, pageSize);
    }
}
