/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.deadline.ShopMarketMVC.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Admin
 */
@Getter
@AllArgsConstructor

public class AppException extends RuntimeException {
    private int code;
    private String message;
    
    
}
