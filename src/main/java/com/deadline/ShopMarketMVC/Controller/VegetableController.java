/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import com.deadline.ShopMarketMVC.Model.Vegetable;
import com.deadline.ShopMarketMVC.Service.VegetableServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class VegetableController {
    @Autowired
    private VegetableServiceImpl vegetableService;
    
    @RequestMapping(value = "/vegetable")
    public String loadVegetableList(Model model) {
        List<Vegetable> list = vegetableService.getVegetableList();

        model.addAttribute("vegetableList", list);

        return "vegetable";
    }
    
}
