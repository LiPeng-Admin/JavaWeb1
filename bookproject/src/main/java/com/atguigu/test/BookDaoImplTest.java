package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();


        @Test
        public void addBook() {
            bookDao.addBook(new Book(null, "斗罗大陆", "唐三", new BigDecimal(200), 2000, 800, null));
        }

        @Test
        public void deleteBookById() {
            bookDao.deleteBookById(21);
        }

        @Test
        public void updateBook() {
            bookDao.updateBook(new Book(22, "一人之下", "张三", new BigDecimal(300), 3000, 700, null));
        }

        @Test
        public void queryBookById() {
            System.out.println(bookDao.queryBookById(20));
        }

        @Test
        public void queryBooks() {
            for (Book book : bookDao.queryBooks()) {
                System.out.println(book + "\n");
            }
        }

        @Test
        public void queryForPageTotalCount() {
            System.out.println(bookDao.queryForPageTotalCount());

        }

        @Test
        public void queryForPageItems() {
            List<Book> books = bookDao.queryForPageItems(4, 4);
            for (Book book : books) {
                System.out.println(book);
            }

        }
    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));

    }
    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItemsByPrice(0, 4,10,50);
        for (Book book : books) {
            System.out.println(book);
        }

    }


}