/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.services;

import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.models.Transaction;
import com.mycompany.myblog.databases.Database;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Filip
 */
public class CustomerService {
    
    Database d = new Database();
    private List<Customer> cList = d.getCustomersDB();
   public CustomerService(){
        
       
   }
    // get all customers , just to have somehting to test for the API if its working or not
   public List<Customer> getAllCustomer() {
        return cList;
    }
   
   public Customer getCustomer(int id) {
        return cList.get(id-1);
    }
    public void setCustomer(int id, Customer customerIn) {
        cList.set(id-1, customerIn);
    }
   
    
    public Customer createCustomer(Customer c) {
	c.setId(cList.size() + 1);
	cList.add(c);
	
        System.out.println("Updated Message:"+c.printCustomer());
	return c;
    }
    
    
    
    
    
    
}