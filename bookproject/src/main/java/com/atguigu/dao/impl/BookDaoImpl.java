package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/8/27 10:56
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`)values(?,?,?,?,?,?)";

        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?, author = ?, price = ?,sales=?, stock = ?, img_path=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath FROM t_book WHERE id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public <List> java.util.List<Book> queryBooks() {
        String sql="select id,name,price,author,sales,stock,img_path imgPath FROM t_book";
        return queryFoList(Book.class,sql);
    }
}
