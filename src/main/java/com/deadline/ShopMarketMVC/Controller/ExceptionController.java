/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.deadline.ShopMarketMVC.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(NullPointerException.class)
    public String nullPointer(Exception ex) {
        ex.printStackTrace();
        return "error";
    }
    
}
