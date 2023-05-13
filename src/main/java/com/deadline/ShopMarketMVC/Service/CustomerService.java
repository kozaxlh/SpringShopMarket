/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Model.Customers;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CustomerService {
    List<Customers> getCustomerList();
    
    Customers getCustomerByID(Integer id);
    
    Customers checkLogin(String username, String password);
            
    Customers save(Customers customer);
}
