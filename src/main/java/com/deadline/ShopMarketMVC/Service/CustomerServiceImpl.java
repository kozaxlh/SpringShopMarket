/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.deadline.ShopMarketMVC.Service;

import com.deadline.ShopMarketMVC.Exception.AppException;
import com.deadline.ShopMarketMVC.Model.Customers;
import com.deadline.ShopMarketMVC.Repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository ;
    
    @Override
    public List<Customers> getCustomerList() {
        List<Customers> customers = customerRepository.findAll();
        return customers;
    }
    
    @Override
    public Customers getCustomerByID(Integer id) {
        Optional<Customers> customer = customerRepository.findById(id);
        if(customer.isEmpty())
            throw new AppException(404,"Customers not found");
        return customer.get();
    }
    
    @Override
    public Customers checkLogin(String username, String password) {
        Customers customer = customerRepository.findByFullnameAndPassword(username, password);
        
        return customer;
    }

    @Override
    public Customers save(Customers customer) {
        if(customerRepository.findByFullname(customer.getFullname()) == null)
            return customerRepository.save(customer);
        return null;
    }
}
