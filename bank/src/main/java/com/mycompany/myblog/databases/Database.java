/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myblog.databases;
import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.models.Transaction;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Filip
 */

// using SOC design 
public class Database {
    public static List<Customer> customerDB = new ArrayList<>();
    public static List<Account> accountDB = new ArrayList<>();
    public static List<Account> accountDB2 = new ArrayList<>();
    public static List<Transaction> transactionDB = new ArrayList<>();
    public static List<Transaction> transactionDB2 = new ArrayList<>();
    public static boolean init = true;
    public Database(){
        // transaction data 
        if(init){
        Transaction t1 = new Transaction (1,"Debit","Bought shoes", 500.0);
        Transaction t2 = new Transaction (2,"Debit","Gucci belt", 450.0); 
        Transaction t3 = new Transaction (3,"Credit","Pizza", 400.0);
        transactionDB.add(t1);
        transactionDB.add(t2);
        transactionDB.add(t3);
        
        t1 = new Transaction (1,"Credit","Mirror", 500.0);
        t2 = new Transaction (2,"Debit","Keys", 450.0); 
        t3 = new Transaction (3,"Credit","Burgers", 400.0);
        transactionDB2.add(t1);
        transactionDB2.add(t2);
        transactionDB2.add(t3);
        // account data
        Account a1 = new Account (1,889900, 12345, "Current", 700.0 , transactionDB);
        Account a2 = new Account (2,774489, 54321, "Saving", 800.0 , transactionDB2);
        accountDB.add(a1);
        accountDB2.add(a2);
        // customers
        Customer c1 = new Customer (1,"John Blue","123 yellow road", "john123@gmail.com", 4545 , accountDB);
        Customer c2 = new Customer (2,"Leo","5 blue road", "leo@gmail.com", 6666 , accountDB2);
        
        customerDB.add(c1);
        customerDB.add(c2);
        //so I dont get multiple instances recreated numerous times when I do any request
        init = false;
    }
    
    }
    
    public static List<Customer> getCustomersDB() {
        return customerDB;
    }
     public static List<Account> getAccountsDB() {
        return accountDB;
    }
    
    public static List<Transaction> getTransactionsDB() {
        return transactionDB;
    }
    
}// end of class
