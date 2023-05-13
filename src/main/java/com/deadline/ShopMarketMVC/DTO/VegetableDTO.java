/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deadline.ShopMarketMVC.DTO;

import com.deadline.ShopMarketMVC.Model.Vegetable;
import lombok.Data;

/**
 *
 * @author Admin
 */
@Data
public class VegetableDTO {
    private Integer vegetableID;
    private String vegetableName;
    private String image;
    private Integer categoryID;
    private String unit;
    private Integer amount;
    private Float price;
    
    public void loadFromEntity(Vegetable entity) {
        this.vegetableID = entity.getVegetableID();
        this.vegetableName = entity.getVegetableName();
        this.image = entity.getImage();
        this.categoryID = entity.getCatagoryID();
        this.unit = entity.getUnit();
        this.amount = entity.getAmount();
        this.price = entity.getPrice();
    }
}
