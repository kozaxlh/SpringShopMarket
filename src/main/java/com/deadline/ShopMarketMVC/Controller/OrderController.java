/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.Model.Customers;
import com.deadline.ShopMarketMVC.Service.OrderServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/orders/add")
    public String page(HttpSession session) {
        orderService.addOrder((Customers) session.getAttribute("user"));
        return "redirect:/";
    }
}
