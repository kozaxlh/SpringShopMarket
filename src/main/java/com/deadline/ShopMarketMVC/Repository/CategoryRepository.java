/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.deadline.ShopMarketMVC.Repository;

import com.deadline.ShopMarketMVC.Model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
}
