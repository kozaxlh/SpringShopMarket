/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.Model.Customers;
import com.deadline.ShopMarketMVC.Service.CustomerServiceImpl;
import com.deadline.ShopMarketMVC.Service.OrderDetailService;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/customers")
    public String loadCustomerList(Model model) {
        List<Customers> list = customerService.getCustomerList();

        model.addAttribute("customerList", list);

        return "customers";
    }

    @RequestMapping(value = "/customers/{id}")
    public String findCustomerByID(@PathVariable Integer id, Model model) {
        model.addAttribute("customerList", customerService.getCustomerByID(id));
        return "customers";
    }

    @RequestMapping(value = "/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/checklogin")
    public String login(Model model,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {
        Customers user = customerService.checkLogin(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:";
        }
        else {
            model.addAttribute("ERROR", "Username or password is wrong");
            return "login";
        }
    }

    @RequestMapping(value = "/logout")
    public String login(HttpSession session) {
        session.removeAttribute("user");
        orderDetailService.clear();
        return "redirect:";
    }

    @RequestMapping(value = "/register")
    public String showRegister() {
        return "register";
    }

    @RequestMapping(value = "/checkregister")
    public String register(@ModelAttribute("user") Customers user, HttpSession session, Model model) {
        Customers customer = customerService.save(user);
        if (customer != null) {
            session.setAttribute("user", user);
        }
        else {
            model.addAttribute("ERROR", "Username đã tồn tại");
            return "register";
        }
        return "redirect:";
    }
}
