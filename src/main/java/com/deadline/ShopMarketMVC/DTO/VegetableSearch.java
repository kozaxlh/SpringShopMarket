/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deadline.ShopMarketMVC.DTO;

import com.deadline.ShopMarketMVC.Repository.VegetableSearchEnum;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class VegetableSearch {

    private Integer categoryID;
    private String vegetableName;
    protected VegetableSearchEnum condition;

    VegetableSearch(Integer categoryID, String vegetableName) {
        this.categoryID = categoryID;
        this.vegetableName = vegetableName;

    }

    public void setCondition() {
        if (categoryID != null && vegetableName != null) {
            condition = VegetableSearchEnum.BOTH;
        }
        else if (categoryID != null) {
            condition = VegetableSearchEnum.CATEGORY;
        }
        else if (vegetableName != null) {
            condition = VegetableSearchEnum.VEGETABLENAME;
        }
        
    }

}
