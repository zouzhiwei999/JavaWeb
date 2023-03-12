package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/30 1:33
 */

public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Integer getTotalCount() {
        Integer totalCount = new Integer(0);
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

    //添加商品
    public void addItem(CartItem item){
        /*查看当前商品是否已经被添加，因为map集合的key值是唯一的，可以商品的id作为key值来判断是否已经添加
        以map的形式来存储(商品的id,商品全部信息)
        * */

        //此id值的商品是否存在
        CartItem cartItem = items.get(item.getId());

        //如果这个id不存在,添加此商品
        if (cartItem == null){
            items.put(item.getId(), item);
        }else {
            //如果此id已经存在，商品信息内部叠加

            //数量加一
            cartItem.setCount(cartItem.getCount() + 1);
            System.out.println(cartItem.getCount());

            //单价*数量
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
            System.out.println(cartItem.getTotalPrice());
        }
    }

    //删除商品
    public void delete(Integer id){
        items.remove(id);
    }

    //清空购物车
    public void clear(){
        items.clear();
    }

    //修改商品数量
    public void updateCount(Integer id, Integer count) {
        //商品是否存在
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            //修改商品内部信息
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(count)));
        }

    }



}
