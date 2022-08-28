package com.atguigu.test;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookDaoImpl bookService = new BookDaoImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"笑傲江湖","林正英",new BigDecimal(500),500,900,null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(20,"康熙王朝","康熙",new BigDecimal(500),500,900,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(14));
    }

    @Test
    public void queryBooks() {
        for (Book book :  bookService.queryBooks()){
            System.out.println(book);
        }
    }
}