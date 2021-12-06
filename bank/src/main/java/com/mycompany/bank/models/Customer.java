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
    private String name;
    private String address;
    private String email;
    private int pin;
    private List<Account> accounts = new ArrayList<>();
    
    
    public Customer(){ 
    }

    public Customer(String name, String address, String email, int pin, List<Account> accounts) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.pin = pin;
        this.accounts = accounts;
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
    
    public String printAllAccounts() {
         String allAccs = "";
         for ( int i=0; i<accounts.size(); i++)
             allAccs=allAccs+accounts.get(i).printAccount()+" ";
	return allAccs;
    }
    
    
    
    
    
} // end of class
