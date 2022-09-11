package com.atguigu.test;

import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;


public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("12345678901",new Date(),new BigDecimal(500),0,1));
    }
}