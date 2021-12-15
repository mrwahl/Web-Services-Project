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
import com.mycompany.bank.services.AccountService;
import com.mycompany.bank.services.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
/**
 *
 * @author Filip
 */

@Path("/accounts")
public class AccountResource {
   CustomerService customerService = new CustomerService();
   AccountService accountService = new AccountService();
   TransactionService transactionService = new TransactionService();
   
     /* how to post a request in JSON to create a new account for a customer 
        /*
        {               
                "sortCode":654545454,
                "accNumber":999,
                "accType":"debit",
                "currentBalance":787.0
    }
        */
     //create a new account for an existing customer.
    @POST
    @Path("/{customerID}/createAccount")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account addCustomerAccount(@PathParam("customerID") int cid, Account account) {         
       //Get the customer you will be adding the account to
        Customer cust = customerService.getCustomer(cid);
        //Get a list of the accounts in that customer
        List<Account> accounts = cust.getAccounts();
        // increment the account id by 1
        account.setAccid(accounts.size()+1);
        //Add the new account to the list of accounts
        accounts.add(account);
        //Set the list of accounts within the customer to the updated list
        cust.setAccounts(accounts);
        //update the customer entry within customersService
        customerService.setCustomer(cid, cust);
        //Return the newly create account
	return customerService.getCustomer(cid).getAccounts().get(accounts.size()-1);
    }
    
   //Get balance for specific customers account
    @GET
    @Path("/{customerID}/{accountID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBalancet(@PathParam("customerID") int cid, @PathParam("accountID") int aid ) {
        //Get specific customer from customers using id
        Customer c = customerService.getCustomer(cid);
        //Get a list of the accounts on that customer
        List<Account> accounts = c.getAccounts();
        Account a = accounts.get(aid-1);
        
        Double newBalance = a.getCurrentBalance();
	return "Balance for Customer ID "+cid+" with account ID "+aid+" is " +newBalance;
        
    }
    
    // Make a withdrawal for a given Customers account.
    @PUT
    @Path("/{customerID}/{accountID}/withdraw/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account withdrawMoney(@PathParam("customerID") int cid, @PathParam("accountID") int aid,@PathParam("amount") Double amount, Transaction t) {
        //Get specific customer from customers using id
        Customer c = customerService.getCustomer(cid);
        //Get a list of the accounts on that customer
        List<Account> accounts = c.getAccounts();
        //get the account we got from our request.
        Account a = accounts.get(aid-1);
        //set the new balance
        Double newBalance = a.getCurrentBalance()-amount;
        a.setCurrentBalance(newBalance);
        
        
	return accounts.get(aid-1);
    }
    
    //get all transactions of specific customer's account
    @GET
    @Path("/{customerID}/{accountID}/allTransactions")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllTransactions(@PathParam("customerID") int cid, @PathParam("accountID") int aid){
    Customer c = customerService.getCustomer(cid);
        List<Account> accounts = c.getAccounts();
        Account a = accounts.get(aid-1);
        return accounts.get(aid-1).printAllTransactions();
    }
    
    // Make a lodgement for a given Customers account.
    @PUT
    @Path("/{customerID}/{accountID}/lodge/{amount}")
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
       
        return accounts.get(aid-1); //Get specific customer from customers using id
     }
    
    @PUT
    @Path("/{customerID}/{accountID}/{recieverCustId}/{recieverAccId}/transfer/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public String makeTransfer(@PathParam("customerID") int cid, @PathParam("accountID") int aid, @PathParam("recieverCustId") int recieverCid, @PathParam("recieverAccId") int recieverAid, @PathParam("amount") Double amount){
   
        
    //Find account from
    Customer cFrom = customerService.getCustomer(cid);
    //Find account to
    Customer cTo = customerService.getCustomer(recieverCid);
    //Create a List of all accounts for A
    List<Account> accounts = cFrom.getAccounts();
    //Create a List of all accounts for B\
    List<Account> accounts2 = cTo.getAccounts();
    //Get the ID
    Account a = accounts.get(cid-1);
    Account b = accounts2.get(recieverAid-1);

    Double oldBalanceA, oldBalanceB;
    oldBalanceA = a.getCurrentBalance();
    oldBalanceB = b.getCurrentBalance();
    
    Double newBalanceA = oldBalanceA-amount;
    Double newBalanceB = oldBalanceB+amount;
    
    //Update the new balance
    a.setCurrentBalance(newBalanceA);
    b.setCurrentBalance(newBalanceB);
    
    return "Sender's old balance: "+oldBalanceA+ "Sender's new balance: "+newBalanceA+ "Receiver's old balance: "+oldBalanceB+"Receiver's new balance: "+newBalanceB;
     
        
      }
}