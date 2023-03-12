package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {

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

    //返回分页的Book对象
    Page<Book> page(int pageNum, int pageSize);

    //返回有价格区间的分页对象
    Page<Book> pageForPrice(int pageNum, int pageSize, int min, int max);
}
