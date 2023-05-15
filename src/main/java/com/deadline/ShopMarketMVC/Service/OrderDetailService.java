/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Model.OrderDetail;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OrderDetailService {

    void add(OrderDetail item);

    void clear();

    Collection<OrderDetail> getAllItems();

    int getCount();

    double getTotal();

    void remove(int id);

    OrderDetail update(int id, int quantity);
    
}
