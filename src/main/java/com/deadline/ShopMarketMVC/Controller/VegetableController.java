/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.DTO.VegetableSearch;
import com.deadline.ShopMarketMVC.Model.Vegetable;
import com.deadline.ShopMarketMVC.Service.CategoryServiceImpl;
import com.deadline.ShopMarketMVC.Service.OrderDetailService;
import com.deadline.ShopMarketMVC.Service.VegetableServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class VegetableController {
    @Autowired
    private VegetableServiceImpl vegetableService;
    
    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private OrderDetailService orderDetailService;

    
    @RequestMapping(value = "/")
    public String loadVegetableList(Model model) {
        List<Vegetable> list = vegetableService.getVegetableList();
        
        model.addAttribute("categoryList", categoryService.getCategoryList());
        model.addAttribute("vegetableList", list);
        model.addAttribute("cartLength", orderDetailService.getCount());

        return "index";
    }
    
    @RequestMapping(value = "/missing")
    public String errorLoad(@RequestParam("error") String error, Model model) {
        List<Vegetable> list = vegetableService.getVegetableList();
        
        model.addAttribute("categoryList", categoryService.getCategoryList());
        model.addAttribute("vegetableList", list);
        model.addAttribute("cartLength", orderDetailService.getCount());
        model.addAttribute("error",error);

        return "index";
    }
    
    @RequestMapping(value = "/searchvegetable", method = RequestMethod.GET)
    public String searchVegetable(@ModelAttribute("search") VegetableSearch search, Model model) {
        List<Vegetable> list = vegetableService.searchVegetableList(search);
        
        model.addAttribute("categoryList", categoryService.getCategoryList());
        model.addAttribute("vegetableList", list);
        model.addAttribute("cartLength", orderDetailService.getCount());

        return "index";
    }
    
    @RequestMapping(value = "/bestsale", method = RequestMethod.GET)
    public String getBestSale(Model model) {
        List<Vegetable> list = vegetableService.getBestSale();
        
        model.addAttribute("categoryList", categoryService.getCategoryList());
        model.addAttribute("vegetableList", list);
        model.addAttribute("cartLength", orderDetailService.getCount());

        return "index";
    }
    
}
