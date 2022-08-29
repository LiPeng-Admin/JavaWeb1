package com.atguigu.test;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "笑傲江湖", "林正英", new BigDecimal(500), 500, 900, null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(20, "康熙王朝", "康熙", new BigDecimal(500), 500, 900, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(14));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, 4));
    }
    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, 4,10,50));
    }


}