/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deadline.ShopMarketMVC.DTO;

import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class VegetableSearch {

    private Integer catagoryID;
    private String vegetableName;
    protected VegetableSearchEnum condition;

    VegetableSearch(Integer categoryID, String vegetableName) {
        this.catagoryID = categoryID;
        this.vegetableName = vegetableName;

    }

    public void setCondition() {
        if (catagoryID != null && vegetableName != null) {
            condition = VegetableSearchEnum.BOTH;
        }
        else if (catagoryID != null) {
            condition = VegetableSearchEnum.CATEGORY;
        }
        else if (vegetableName != null) {
            condition = VegetableSearchEnum.VEGETABLENAME;
        }
        
    }

}
