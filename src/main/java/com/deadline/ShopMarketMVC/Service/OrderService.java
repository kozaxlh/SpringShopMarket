/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Model.Customers;

/**
 *
 * @author Admin
 */
public interface OrderService {

    void addOrder(Customers user, String note);
    
}
