/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.resources;

import com.mycompany.bank.models.Transaction;
import com.mycompany.bank.services.TransactionService;
//import com.mycompany.bank.services.TransactionService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    private TransactionService ts = new TransactionService();

    
    //localhost:8080/api/customers/1/accounts/{12345/transactions
    @POST
    @Path("/{accid}")
    public Transaction makeTransaction(@PathParam("accid") int accId, Transaction t){
        accId = accId-1;
        if(t.getTransactionType().equals("transfer")){
            return ts.makeTransfer(accId, t);
        }
         else if(t.getTransactionType().equals("withdrawal")){
            return ts.makeLodgement(accId, accId, t);
        }
        else if(t.getTransactionType().equals("lodgement")){
            return ts.makeWithdrawl(accId, accId, t);
        }
       return t;
   }
    
/*request body for test in postman
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
*/
}
