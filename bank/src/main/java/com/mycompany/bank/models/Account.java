/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Filip
 */
@XmlRootElement
public class Account {
    private int id;
    private int sortCode;
    private int accNumber;
    private String accType;
    private double currentBalance;   
    private List<Transaction> transactions = new ArrayList<>();
    
    public Account(){
    }

    public Account(int id,int sortCode, int accNumber, String accType, double currentBalance, List<Transaction> transactions) {
        this.id = id;
        this.sortCode = sortCode;
        this.accNumber = accNumber;
        this.accType = accType;
        this.currentBalance = currentBalance;
        this.transactions = transactions;
    }
    public Account(int id,int sortCode, int accNumber, String accType, double currentBalance) {
        this.id = id;
        this.sortCode = sortCode;
        this.accNumber = accNumber;
        this.accType = accType;
        this.currentBalance = currentBalance;
        this.transactions = transactions;
    }
    
//getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    
    // print account
    public String printAccount() {
        String str = this.getId()+" "+ this.getSortCode()+" "+this.getAccNumber()+" "+ this.getAccType()+" "+ this.getCurrentBalance();
        return str;
    }
    
    //print all transactions 
    public String printAllTransactions() {
         String allTrans = "";
         for ( int i=0; i<transactions.size(); i++)
             allTrans=allTrans+transactions.get(i).printTransaction()+" ";
	return allTrans;
    }
    
    
}// end of class 