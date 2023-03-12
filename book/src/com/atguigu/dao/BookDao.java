package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {

    //添加图书
    public int addBook(Book book);

    //修改图书
    public int updateBook(Book book);

    //删除
    public int deleteBookById(Integer id);

    //查询
    public Book queryBookById(Integer id);

    //查询全部
    public List<Book> queryBook();

    Integer queryForPageTotal();

    List<Book> queryForPageItems(int begin,int pageSize);

    //按价格返回总页数
    Integer queryForPageTotalForPrice(int min,int max);

    //按价格返回Book集合
    List<Book> queryForPageItemsForPrice(int begin, int pageSize, int min, int max);
}
