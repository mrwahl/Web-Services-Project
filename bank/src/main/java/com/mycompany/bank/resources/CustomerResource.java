/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.resources;
import com.mycompany.bank.models.Customer;
import com.mycompany.bank.services.CustomerService;
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

@Path("/customers")
public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    
    /*
    If using POSTMAN as client, remember setting a Header 
    "Accept:application/json" for retrieving JSON format
    "Accept:application/xml" for retrieving XML format
    */  
   
    
    
    // simple get to retrieve all customers and produce in json
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomersJSON() {
        return customerService.getAllCustomer();
    }
    //create a new customer 
    
    
    /*
    * When using POSTMAN remember to include in Headers: Content-type : application/json
    * and include in the body of the request in RAW format the object in JSON notation
    e.g. how to send the post request to create a customer with an account as well
    {  "id": 3131, 
    "name": "batman",
    "address": "blueroad",
    "email": "fakeEMAIL",
    "pin":7800,
    "accounts": {
                "id":6,
                "sortCode":654545454,
                "accNumber":999,
                "accType":"debit",
                "currentBalance":787.0
    }
    }
    
    

    */
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(Customer c) {
        
        return customerService.createCustomer(c);
    } 
    
    //Get a specific customer based on their id 
    @GET
    @Path("/{customerID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getSpecificCustomer(@PathParam("customerID") int cID ) {
        //gets customer for CustomerServices and returns it
	return customerService.getCustomer(cID);
    }
    
}
