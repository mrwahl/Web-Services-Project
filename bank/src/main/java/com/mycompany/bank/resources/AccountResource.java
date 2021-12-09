/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.resources;
import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.services.CustomerService;
import com.mycompany.bank.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    
    
}
