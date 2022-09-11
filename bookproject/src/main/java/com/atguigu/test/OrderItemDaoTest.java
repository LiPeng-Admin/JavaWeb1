package com.atguigu.test;

import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(1,"我们三",100,new BigDecimal(100),new BigDecimal(10000),"123456"));
        orderItemDao.saveOrderItem(new OrderItem(null,"白夜黑羽",2,new BigDecimal(100),new BigDecimal(200),"123456"));
        orderItemDao.saveOrderItem(new OrderItem(null,"bili",3,new BigDecimal(100),new BigDecimal(300),"123456"));
    }
}