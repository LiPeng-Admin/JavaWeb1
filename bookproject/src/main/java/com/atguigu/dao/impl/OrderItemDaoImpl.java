package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

/**
 * @author lipeng
 * @version 1.0
 * @description: TODO
 * @date 2022/9/5 8:51
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        System.out.println("OrderItemDaoImpl在线程【"+Thread.currentThread().getName()+"】中");
        String sql = "INSERT INTO t_order_item(`name`,count,price,total_price,order_id)VALUES(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
