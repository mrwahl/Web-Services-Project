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
    
    
    
    
}
