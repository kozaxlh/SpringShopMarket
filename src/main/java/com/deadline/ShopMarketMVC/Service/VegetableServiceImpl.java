/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Model.Vegetable;
import com.deadline.ShopMarketMVC.Repository.VegetableRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class VegetableServiceImpl implements VegetableService{
    @Autowired
    private VegetableRepository vegetableRepository;
    
    public List<Vegetable> getVegetableList() {
        List<Vegetable> list = vegetableRepository.findAll();
        return list;
    }
    
    public List<Vegetable> getVegetableListByCategory(int categoryID) {
        List<Vegetable> list = vegetableRepository.findByCatagoryID(categoryID);
        return list;
    }
}
