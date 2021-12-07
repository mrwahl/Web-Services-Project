/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.models;

import java.util.Date;

/**
 *
 * @author Filip
 */
public class Transaction {
    private int id;
    private String transactionType;
    private Date paid;
    private String transactionDescription;
    private double postBalance;
    
    public Transaction(){
    }

    public Transaction(int id, String transactionType, String transactionDescription, double postBalance) {
        this.id = id;
        this.transactionType = transactionType;
        this.paid = new Date();
        this.transactionDescription = transactionDescription;
        this.postBalance = postBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//getters and setters
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getPaid() {
        return paid;
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public double getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(double postBalance) {
        this.postBalance = postBalance;
    }
    
    //print transaction 
    public String printTransaction() {
        String str = this.getId()+" "+ this.getTransactionType()+" "+this.getPaid()+" "+ this.getTransactionDescription()+" "+ this.getPostBalance();
        return str;
    }
    
    
}
