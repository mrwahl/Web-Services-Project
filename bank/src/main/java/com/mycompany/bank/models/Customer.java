/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.models;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 *
 * @author Filip
 */
@XmlRootElement
public class Customer {
    private int id;
    private String name;
    private String address;
    private String email;
    private int pin;
    private List<Account> accounts = new ArrayList<>();
    
    
    public Customer(){ 
    }
    
    public Customer(int id,String name, String address, String email, int pin, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.pin = pin;
        this.accounts = accounts;
    } 
    /*
    public Customer(int id,String name, String address, String email, int pin) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.pin = pin;
        
    } */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
//getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void addAccount(Account account){
        (this.accounts).add(account);
    }
    
    public String printCustomer() {
        String str = this.getId()+" "+ this.getName()+" "+this.getAddress()+ " "+this.getEmail()+" "+this.getPin();
        return str;
    }
    
    
    public String printAllAccounts() {
         String allAccs = "";
         for ( int i=0; i<accounts.size(); i++)
             allAccs=allAccs+accounts.get(i).printAccount()+" ";
	return allAccs;
    }
    
    
    
    
    
} // end of class
