/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.resources;

import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.models.Transaction;
import com.mycompany.bank.services.CustomerService;
import com.mycompany.bank.services.TransactionService;
import java.util.List;
//import com.mycompany.bank.services.TransactionService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */

@Path("/transactions")

public class TransactionResource {
    
   /*TransactionService transactionService = new TransactionService();

   CustomerService customerService = new CustomerService();


   @PUT
    @Path("/{customerID}/{accountID}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account lodgeMoney(@PathParam("customerID") int cid, @PathParam("accountID") int aid,@PathParam("amount") Double amount ) {
       Customer c = customerService.getCustomer(cid);
        //Get a list of the accounts on that customer
        List<Account> accounts = c.getAccounts();
        //get the account we got from our request.
        Account a = accounts.get(aid-1);
        //set the new balance
        Double newBalance = a.getCurrentBalance()+amount;
        a.setCurrentBalance(newBalance);
	return accounts.get(aid-1); //Get specific custom
   /* @PUT
    @Path("/{customerID}/{accountID}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account makeTransaction(@PathParam("customerID") int cid, @PathParam("accountID") int aid,@PathParam("amount") Double amount){
    //Find account from
    Customer cFrom = customerService.getCustomer(cid);
    //Find account to
    Customer cTo = customerService.getCustomer(aid);
    //Create a List of all accounts for A
    List<Account> accounts = cFrom.getAccounts();
    //Create a List of all accounts for B\
    List<Account> accounts2 = cTo.getAccounts();
    //Get the ID
    Account a = accounts.get(aid-1);
    Account b = accounts2.get(cid-1);

    Double balance = a.getCurrentBalance()-amount;
    //Update the new balance
    a.setCurrentBalance(balance);
    //Get balance from B
    Double balance2 = b.getCurrentBalance()+amount;
    //Send it to the new account
    b.setCurrentBalance(balance2);
    
    return accounts.get(aid-1);*/
   } 
    
/*request body " test in postman
    {"transactionType" : "Transfer",    
      "transactionDescription : "December rent"
      "transactionAmount" : 350,
      "transferToAccountNumner" :  "12345"
    }
       
     {"transactionType" : "withdrawal",    
      "transactionDescription : "Tesco"
      "transactionAmount" : 350,
      "transferToAccountNumner" :  "12345"
    }
    
     {"transactionType" : "lodgement",    
      "transactionDescription : "rent from Alex"
      "transactionAmount" : 350,
      "transferToAccountNumner" :  "12345"
    }
*/  /*
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Double postWithdraw(Account c,Double amount) {
        
        return transactionService.transferMoneyFromOutgoing(c, amount);
    } */
    
    
    

