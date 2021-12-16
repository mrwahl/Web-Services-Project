package com.mycompany.bank.resources;

import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.models.Transaction;
import com.mycompany.bank.services.AccountService;
import com.mycompany.bank.services.CustomerService;
import com.mycompany.bank.services.TransactionService;
import java.util.Date;
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

    //create a new account for an existing customer.
    @POST
    @Path("/{customerID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account addCustomerAccount(@PathParam("customerID") int cid, Account account) {
        //Get the customer you will be adding the account to
        Customer cust = customerService.getCustomer(cid);
        //Get a list of the accounts in that customer
        List<Account> accounts = cust.getAccounts();
        // increment the account id by 1
        account.setAccid(accounts.size() + 1);
        //Add the new account to the list of accounts
        accounts.add(account);
        //Set the list of accounts within the customer to the updated list
        cust.setAccounts(accounts);
        //update the customer entry within customersService
        customerService.setCustomer(cid, cust);
        //Return the newly create account
        return customerService.getCustomer(cid).getAccounts().get(accounts.size() - 1);
    }

    //Get balance for specific customers account
    @GET
    @Path("/{customerID}/{accountID}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBalance(@PathParam("customerID") int cid, @PathParam("accountID") int aid) {
        //Get specific customer from customers using id
        Customer c = customerService.getCustomer(cid);
        //Get a list of the accounts on that customer
        List<Account> accounts = c.getAccounts();
        Account a = accounts.get(aid - 1);

        Double newBalance = a.getCurrentBalance();
        return "Balance for Customer ID " + cid + " with account ID " + aid + " is " + newBalance;

    }

    // Make a withdrawal for a given Customers account.
    @POST
    @Path("/{customerID}/{accountID}/withdrawals/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account withdrawMoney(@PathParam("customerID") int cid, @PathParam("accountID") int aid, @PathParam("amount") Double amount, Transaction transaction) {
        //Get specific customer from customers using id
        Customer c = customerService.getCustomer(cid);
        //Get a list of the accounts on that customer
        List<Account> accounts = c.getAccounts();
        //get the account we got from our request.
        Account a = accounts.get(aid - 1);
        //set the new balance
        Double newBalance = a.getCurrentBalance() - amount;
        a.setCurrentBalance(newBalance);
        /// Now we need to create a transaction of type withdraw
        List<Transaction> transactions = a.getTransactions();
        //assign an id to the transaction
        transaction.setTransid(transactions.size() + 1);
        //set the post balance.
        transaction.setPostBalance(newBalance);
        //assign a new date
        Date d = new Date();
        transaction.setPaid(d);
        //assign withdraw as a type of transaction
        String type = "Withdraw";
        transaction.setTransactionType(type);
        //Add the new transaction to the list of transactions
        transactions.add(transaction);
        //Set the list of transactions within the account to the updated list
        a.setTransactions(transactions);
        //update the account
        accountService.setAccount(aid, a);
        return accounts.get(aid - 1);
    }

    // Make a lodgement for a given Customers account.
    @POST
    @Path("/{customerID}/{accountID}/lodgements/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account lodgeMoney(@PathParam("customerID") int cid, @PathParam("accountID") int aid, @PathParam("amount") Double amount, Transaction transaction) {
        Customer c = customerService.getCustomer(cid);
        //Get a list of the accounts on that customer
        List<Account> accounts = c.getAccounts();
        //get the account we got from our request.
        Account a = accounts.get(aid - 1);
        //set the new balance
        Double newBalance = a.getCurrentBalance() + amount;
        a.setCurrentBalance(newBalance);
        /// Now we need to create a transaction of type withdraw
        List<Transaction> transactions = a.getTransactions();
        //assign an id to the transaction
        transaction.setTransid(transactions.size() + 1);
        //set the post balance.
        transaction.setPostBalance(newBalance);
        //assign a new date
        Date d = new Date();
        transaction.setPaid(d);
        //assign lodgement as a type of transaction
        String type = "Lodgement";
        transaction.setTransactionType(type);
        //Add the new transaction to the list of transactions
        transactions.add(transaction);
        //Set the list of transactions within the account to the updated list
        a.setTransactions(transactions);
        //update the account
        accountService.setAccount(aid, a);
        return accounts.get(aid - 1);
    }

}
