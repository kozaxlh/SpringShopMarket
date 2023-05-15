/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.DTO.VegetableSearch;
import com.deadline.ShopMarketMVC.Model.Vegetable;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface VegetableService {
    List<Vegetable> getVegetableList();
    
    List<Vegetable> searchVegetableList(VegetableSearch search);
    
    List<Vegetable> getBestSale();

    Vegetable findByID(Integer id);
}
