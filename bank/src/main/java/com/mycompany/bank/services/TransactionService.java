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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Filip
 */
public class TransactionService {

    Database d = new Database();
    public List<Transaction> tList = d.getTransactionsDB();

    public TransactionService() {
    }

    //get all transactions
    public List<Transaction> getAllTransactions() {
        return tList;
    }

    public Transaction getTransaction(int id) {
        return tList.get(id - 1);
    }

    public void setTransaction(int id, Transaction transid) {
        tList.set(id - 1, transid);
    }

    public Transaction createTransaction(Transaction t) {
        t.setTransid(tList.size() + 1);
        tList.add(t);

        System.out.println("Updated Message:" + t.printTransaction());
        return t;
    }

}
