/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Model.OrderDetail;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author Admin
 */
@SessionScope
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    Map<Integer, OrderDetail> maps = new HashMap<>();

    @Override
    public void add(OrderDetail item) {
        OrderDetail cartItem = maps.get(item.getVegetable().getVegetableID());
        if (cartItem == null) {
            maps.put(item.getVegetable().getVegetableID(), item);
        }
        else {
            cartItem.setQuantity((short) (cartItem.getQuantity() + 1));
            cartItem.setPrice(cartItem.getQuantity() * cartItem.getVegetable().getPrice());
        }
    }

    @Override
    public void remove(int id) {
        maps.remove(id);
    }

    @Override
    public OrderDetail update(int id, int quantity) {
        OrderDetail cartItem = maps.get(id);
        cartItem.setQuantity((short)quantity);
        cartItem.setPrice(cartItem.getQuantity() * cartItem.getVegetable().getPrice());
        return cartItem;
    }

    @Override
    public void clear() {
        maps.clear();
    }

    @Override
    public Collection<OrderDetail> getAllItems() {
        return maps.values();
    }

    @Override
    public int getCount() {
        return maps.values().size();
    }

    @Override
    public double getTotal() {
        return maps.values()
                .stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}
