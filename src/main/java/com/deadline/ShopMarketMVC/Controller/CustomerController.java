/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.Model.Customers;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Admin
 */
@Controller
public class CustomerController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    @RequestMapping(value = "/customers")
    @Transactional
    public String loadCustomerList(Model model) {
        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        
        List<Customers> list = session.createQuery("FROM Customers", Customers.class).list();
        
        model.addAttribute("customerList", list);
        
        return "customers";
    }
    
    @RequestMapping(value = "/hello")
    public String show(Model model) {
        model.addAttribute("customerList", "Hello");
        
        return "index";
    }
    
}
