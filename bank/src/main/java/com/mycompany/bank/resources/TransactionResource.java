package com.mycompany.bank.resources;

import com.mycompany.bank.models.Account;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.models.Transaction;
import com.mycompany.bank.services.AccountService;
import com.mycompany.bank.services.CustomerService;
import com.mycompany.bank.services.TransactionService;
import java.util.Date;
import java.util.List;
//import com.mycompany.bank.services.TransactionService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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

    CustomerService customerService = new CustomerService();
    AccountService accountService = new AccountService();
    TransactionService transactionService = new TransactionService();

    @POST
    @Path("/{customerID}/{accountID}/{recieverCustId}/{recieverAccId}/transfer/{amount}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String makeTransfer(@PathParam("customerID") int cid, @PathParam("accountID") int aid, @PathParam("recieverCustId") int recieverCid, @PathParam("recieverAccId") int recieverAid, @PathParam("amount") Double amount, Transaction transaction) {

        //Find account from
        Customer cFrom = customerService.getCustomer(cid);
        //Find account to
        Customer cTo = customerService.getCustomer(recieverCid);
        //Create a List of all accounts for A
        List<Account> accounts = cFrom.getAccounts();
        //Create a List of all accounts for B\
        List<Account> accounts2 = cTo.getAccounts();
        //Get the ID
        Account a = accounts.get(cid - 1);
        Account b = accounts2.get(recieverAid - 1);

        Double oldBalanceA, oldBalanceB;
        oldBalanceA = a.getCurrentBalance();
        oldBalanceB = b.getCurrentBalance();

        Double newBalanceA = oldBalanceA - amount;
        Double newBalanceB = oldBalanceB + amount;

        //Update the new balance
        a.setCurrentBalance(newBalanceA);
        b.setCurrentBalance(newBalanceB);
        //sender transaction 
        /// Now we need to create a transaction of type withdraw
        List<Transaction> transactions = a.getTransactions();
        //assign an id to the transaction
        transaction.setTransid(transactions.size() + 1);
        //set the post balance.
        transaction.setPostBalance(newBalanceA);
        //assign a new date
        Date d = new Date();
        transaction.setPaid(d);
        //assign lodgement as a type of transaction
        String type = "Transfered";
        transaction.setTransactionType(type);
        //Add the new transaction to the list of transactions
        transactions.add(transaction);
        //Set the list of transactions within the account to the updated list
        a.setTransactions(transactions);
        //update the account
        accountService.setAccount(aid, a);

        // receiver transaction
        List<Transaction> transactions2 = b.getTransactions();
        //assign an id to the transaction
        transaction.setTransid(transactions2.size() + 1);
        //set the post balance.
        transaction.setPostBalance(newBalanceB);
        //assign a new date
        Date d2 = new Date();
        transaction.setPaid(d2);
        //assign lodgement as a type of transaction
        String type2 = "Transfer";
        transaction.setTransactionType(type2);
        //Add the new transaction to the list of transactions
        transactions2.add(transaction);
        //Set the list of transactions within the account to the updated list
        b.setTransactions(transactions2);
        //update the account
        accountService.setAccount(recieverAid, b);

        return "Sender's old balance: " + oldBalanceA + "Sender's new balance: " + newBalanceA + "Receiver's old balance: " + oldBalanceB + "Receiver's new balance: " + newBalanceB;
    }

    // Get all transactions
    @GET
    @Path("/{customerID}/{accountID}/allTransactions")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllTransaction(@PathParam("customerID") int cid, @PathParam("accountID") int aid) {
        Customer c = customerService.getCustomer(cid);
        List<Account> accounts = c.getAccounts();
        Account a = accounts.get(aid - 1);
        return accounts.get(aid - 1).printAllTransactions();
    }

}
