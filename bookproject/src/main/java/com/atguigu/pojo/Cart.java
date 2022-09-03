package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lipeng
 * @version 1.0
 * @description: 购物车对象
 * @date 2022/9/3 15:55
 */
public class Cart {


    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * @description: 添加商品项
     * @param:
     * @return: java.lang.Integer
     * @author lipeng
     * @date: 2022/9/3 15:59
     */
    public void addItem(CartItem cartitem) {
        //先查看购物车是否已经添加此商品，若已经添加，则数量累加，总金额更细，若没有添加，则直接放到集合中

        CartItem item = items.get(cartitem.getId());
        if (item == null) {
            //之前没有添加过此商品
            items.put(cartitem.getId(), cartitem);
        } else {
            //已经添加过
            item.setCount(item.getCount() + 1);//数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount()))); //金额更细

        }
    }

    /**
     * @description: 删除商品项
     * @param:
     * @return: java.lang.Integer
     * @author lipeng
     * @date: 2022/9/3 16:00
     */
    public void deleteItem(Integer id) {
        items.remove(id);


    }

    /**
     * @description: 清空购物车
     * @param:
     * @return: java.lang.Integer
     * @author lipeng
     * @date: 2022/9/3 16:01
     */
    public void clear() {
        items.clear();

    }

    /**
     * @description: 修改商品数量
     * @param:
     * @return: java.lang.Integer
     * @author lipeng
     * @date: 2022/9/3 16:02
     */
    public void updateCount(Integer id, Integer count) {
        //查看购物车中是否有此商品，如果有，修改商品数量，更新金额，
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount()))); //金额更细

        }

    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
