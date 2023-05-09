/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.deadline.ShopMarketMVC.Repository;

import com.deadline.ShopMarketMVC.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {
    Customers findByFullnameAndPassword(String fullname, String password);
    Customers findByFullname(String fullname);
}
