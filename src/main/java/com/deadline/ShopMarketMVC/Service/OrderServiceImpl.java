/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Model.Customers;
import com.deadline.ShopMarketMVC.Model.Order;
import com.deadline.ShopMarketMVC.Model.OrderDetail;
import com.deadline.ShopMarketMVC.Model.OrderdetailPK;
import com.deadline.ShopMarketMVC.Repository.OrderRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailService orderDetailService;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Override
    public void addOrder(Customers user, String note) {
        int insertID = orderRepository.getLastInsertedID() + 1;
        
        List<OrderDetail> cartList = new ArrayList(orderDetailService.getAllItems());
        for(var cart: cartList) {
            cart.setOrderdetailPK(new OrderdetailPK(insertID,cart.getVegetable().getVegetableID()));
        }
        
        Order order = new Order();
            order.setOrderID(insertID);
            order.setCustomerID(user);
            order.setDate(Calendar.getInstance());
            order.setTotal((float) orderDetailService.getTotal());
            order.setOrderdetailList(cartList);
            order.setNote(note);
        
        orderRepository.save(order);
        
        orderDetailService.clear();
    }
}
