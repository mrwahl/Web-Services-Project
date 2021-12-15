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

    private int transid;
    private String transactionType;
    private Date date;
    private String transactionDescription;
    private double postBalance;

    public Transaction() {
    }

    public Transaction(int transid, String transactionType, String transactionDescription, double postBalance) {
        this.transid = transid;
        this.transactionType = transactionType;
        this.date = new Date();
        this.transactionDescription = transactionDescription;
        this.postBalance = postBalance;
    }
//getters and setters

    public int getTransid() {
        return transid;
    }

    public void setTransid(int transid) {
        this.transid = transid;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getPaid() {
        return date;
    }

    public void setPaid(Date paid) {
        this.date = paid;
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
        String str = this.getTransid() + " " + this.getTransactionType() + " " + this.getPaid() + " " + this.getTransactionDescription() + " " + this.getPostBalance();
        return str;
    }

}
