package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "时间简史", 1, new BigDecimal(600), new BigDecimal(800)));
        System.out.println(cart.toString() + "\n");

    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "时间简史", 1, new BigDecimal(600), new BigDecimal(800)));

        cart.deleteItem(2);
        System.out.println(cart);

    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "时间简史", 1, new BigDecimal(600), new BigDecimal(800)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "时间简史", 1, new BigDecimal(600), new BigDecimal(800)));
        cart.clear();

        cart.addItem(new CartItem(2, "时间简史", 1, new BigDecimal(600), new BigDecimal(800)));
        cart.updateCount(2, 10);
        System.out.println(cart);


    }
}