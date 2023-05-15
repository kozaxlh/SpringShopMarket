/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.Model.OrderDetail;
import com.deadline.ShopMarketMVC.Model.Vegetable;
import com.deadline.ShopMarketMVC.Service.OrderDetailService;
import com.deadline.ShopMarketMVC.Service.VegetableService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/shoppingcart")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private VegetableService vegetableService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadCart(Model model) {
        model.addAttribute("cartList", orderDetailService.getAllItems());
        model.addAttribute("total", orderDetailService.getTotal());
        return "cart";
    }

    @RequestMapping(value = "/add/{id}")
    public ModelAndView addCart(@PathVariable("id") Integer id, HttpSession session) {
        
        if (session.getAttribute("user") != null) {
            OrderDetail item = new OrderDetail();
            Vegetable product = vegetableService.findByID(id);

            item.setVegetable(product);
            item.setQuantity((short) 1);
            item.setPrice(product.getPrice());

            orderDetailService.add(item);
            return new ModelAndView("redirect:/vegetable");
        }
        else {
            return new ModelAndView("redirect:/vegetable/missing","error", "Bạn phải đăng nhập trước khi mua hàng");
        }
    }
    
    @RequestMapping(value = "/clear")
    public String clearCart() {
        orderDetailService.clear();
        return "redirect:";
    }

    @RequestMapping(value = "/delete/{id}")
    public String clearCart(@PathVariable("id") Integer id) {
        orderDetailService.remove(id);
        return "redirect:/shoppingcart";
    }
    
    @RequestMapping(value = "/update")
    public String updateCart(@RequestParam("id") Integer id, @RequestParam("quantity") short quantity) {
        orderDetailService.update(id, quantity);
        return "redirect:/shoppingcart";
    }
}
