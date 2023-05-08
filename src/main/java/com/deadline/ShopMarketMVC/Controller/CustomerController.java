/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.Model.Customers;
import com.deadline.ShopMarketMVC.Service.CustomerServiceImpl;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/customers")
    public String loadCustomerList(Model model) {
//        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);

//        List<Customers> list = session.createQuery("FROM Customers", Customers.class).list();
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
        if (customerService.checkLogin(username, password)) {
            session.setAttribute("user", username);
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
            return "redirect:";
        }
}
