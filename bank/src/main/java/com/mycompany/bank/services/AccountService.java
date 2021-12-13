/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.services;

import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.myblog.databases.Database;
import java.util.List;

/**
 *
 * @author Filip
 */
public class AccountService {
    CustomerService customerService = new CustomerService();  
    Database d = new Database();
    public  List<Account> aList = d.getAccountsDB();
       
    public AccountService(){
        
    }
    
    public List<Account> getAllAccount() {
        return aList;
    }
     
    
    public Account getAccount(int accid) {
        return aList.get(accid-1);
    }
    
    public void setAccount(int accid, Account accountIn) {
        aList.set(accid-1, accountIn);
    }
    
    
    public Account createAccount(Account a) {
	a.setAccid(aList.size() + 1);
	aList.add(a);
	
        System.out.println("Updated Message:"+a.printAccount());
	return a;
    }
    
    
    
    
    
}
