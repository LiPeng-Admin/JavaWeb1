package com.atguigu.dao;

import com.atguigu.pojo.Book;

public abstract interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public <List> java.util.List<Book> queryBooks();
}
