/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Model.Category;
import com.deadline.ShopMarketMVC.Repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getCategoryList() {
        List<Category> list = categoryRepository.findAll();
        return list;
    }
}
