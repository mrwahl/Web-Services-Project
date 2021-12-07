/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.services;

import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.models.Transaction;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Filip
 */
public class CustomerService {
    
    public static List<Customer> cList = new ArrayList<>();
    public static List<Account> aList = new ArrayList<>();
    public static List<Transaction> tList = new ArrayList<>();
   public CustomerService(){
        //testing some data
          Transaction t1 = new Transaction (1,"Debit","Bought shoes", 500.0);     
          tList.add(t1);         
          ///////////
          Account a1 = new Account (1,889900, 12345, "Current", 700.0 , tList);
          aList.add(a1);
          //////////
          Customer c1 = new Customer (1, "John Blue","123 yellow road", "john123@gmail.com", 4545 , aList);
          cList.add(c1);
       
   }
    // get all customers , just to have somehting to test for the API if its working or not
   public List<Customer> getAllCustomer() {
        return cList;
    }
   
    
    public Customer createCustomer(Customer c) {
	
	cList.add(c);
	
        System.out.println("Updated Message:"+c.printCustomer());
	return c;
    }
    
    
    
    
    
    
}
