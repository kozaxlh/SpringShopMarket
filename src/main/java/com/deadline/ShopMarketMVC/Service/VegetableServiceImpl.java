/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.DTO.VegetableSearch;
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
public class VegetableServiceImpl implements VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    public List<Vegetable> getVegetableList() {
        List<Vegetable> list = vegetableRepository.findAll();
        return list;
    }

    public List<Vegetable> searchVegetableList(VegetableSearch search) {
        search.setCondition();
        List<Vegetable> list = null;
        list = switch (search.getCondition()) {
            case CATEGORY ->
                vegetableRepository.findByCatagoryID(search.getCategoryID());
            case VEGETABLENAME ->
                vegetableRepository.findByVegetableNameContaining(search.getVegetableName());
            case BOTH ->
                vegetableRepository.findByCatagoryIDAndVegetableNameContaining(
                        search.getCategoryID(), 
                        search.getVegetableName()
                );
        };
        return list;
    }
    
    public List<Vegetable> getBestSale() {
        List<Vegetable> list = vegetableRepository.getBestSaleVegetable();
        list.forEach(System.out::println);
        return list;
    }
}
