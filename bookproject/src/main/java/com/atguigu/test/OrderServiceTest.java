package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(500), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "时间简史", 1, new BigDecimal(600), new BigDecimal(800)));
        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart, 1));

    }
}