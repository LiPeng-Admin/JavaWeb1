package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/5 8:51
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        System.out.println("OrderDaoImpl在线程【"+Thread.currentThread().getName()+"】中");
        String sql = "INSERT INTO t_order(order_id ,create_time ,price,`status`,user_id )VALUES(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());

    }
}
