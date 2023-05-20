/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.deadline.ShopMarketMVC.Repository;

import com.deadline.ShopMarketMVC.Model.Vegetable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {
    Vegetable findByVegetableID(Integer vegetableID);
    
    List<Vegetable> findByCatagoryID(Integer catagoryID);
    
    List<Vegetable> findByVegetableNameContaining(String name);
    
    List<Vegetable> findByCatagoryIDAndVegetableNameContaining(Integer catagoryID, String name);
    
    @Query("SELECT V\n" +
            "FROM Vegetable V INNER JOIN OrderDetail OD ON OD.vegetable.vegetableID = V.vegetableID\n" +
            "                 INNER JOIN `Order` O INNER JOIN OrderDetail ON O.orderID = OD.order.orderID\n" +
            "WHERE month(O.date) = month(CURRENT_DATE) - 1 AND year(O.date) = year(CURRENT_DATE)\n" +
            "GROUP BY V.vegetableName\n" +
            "ORDER BY sum(OD.quantity) DESC")
    List<Vegetable> getBestSaleVegetable();

}
