/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.Model.Customers;
import com.deadline.ShopMarketMVC.Service.CustomerService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Admin
 */
@Controller
public class CustomerController {
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(value = "/customers")
    @Transactional
    public String loadCustomerList(Model model) {
//        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
        
//        List<Customers> list = session.createQuery("FROM Customers", Customers.class).list();
        List<Customers> list = customerService.getCustomerList();
        
        model.addAttribute("customerList", list);
        
        return "customers";
    }
    
    @RequestMapping(value = "/hello")
    public String show(Model model) {
        model.addAttribute("customerList", "Hello");
        
        return "index";
    }
    
    @RequestMapping(value = "/customers/{id}")
    public String findCustomerByID(@PathVariable Integer id, Model model) {
        model.addAttribute("customerList",customerService.getCustomerByID(id));
        return "customers";
    }
    
}
