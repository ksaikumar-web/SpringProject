package com.hms.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService service;
	@CrossOrigin("http://localhost:3000/")
	@GetMapping("/showcustomers")
	public List<Customer> getallcustomers(){
		return service.getall();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/searchById/{emailId}")
	public Customer searchById(@PathVariable String emailId) {
		return service.getcustomerById(emailId);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/searchByUserName")
	public Customer seaechByUserName(@PathVariable String customerUserName) {
		return service.getcustomerByUserName(customerUserName);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/registernewCustomer")
	public Customer savecustomer(@RequestBody Customer customer) {
		 service.addnewCustomer(customer);
		 return customer;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/custAuthenticate/{emailId}/{customerPassword}")
	public String authenticateUser(@PathVariable String emailId,@PathVariable String customerPassword) {
		return service.AuthenticateUser(emailId, customerPassword);
		
	}
}
