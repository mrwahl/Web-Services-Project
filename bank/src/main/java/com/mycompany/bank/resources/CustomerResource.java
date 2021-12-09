/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.resources;
import com.mycompany.bank.models.Account;
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

    // Get all customers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomersJSON() {
        return customerService.getAllCustomer();
    }
   
    
    /*
    e.g. how to send the post request to create a customer
    { 
    "name": "batman",
    "address": "blueroad",
    "email": "fakeEMAIL",
    "pin":7800,
    "accounts": 
    }
    
    */
    //create a new Customer with an account . You can create a customer with or without an account.
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
