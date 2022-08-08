package com.hms.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	JdbcTemplate jdbc;
	
	@Autowired
	CustomerDao dao;
	
	public List<Customer> getall(){
		List<Customer> customer = new ArrayList<Customer>();
		customerrepository.findAll().forEach(customer1->customer.add(customer1));
		return customer;
	}
	
	public String AuthenticateUser(String emailId,String customerPassword) {
		return dao.AuthenticateUser(emailId, customerPassword);
	}
	public Customer getcustomerById(String emailId) {
		return customerrepository.findById(emailId).get();
	}
	
	
	public Customer getcustomerByUserName(String customerUserName) {
		return customerrepository.searchCustomerByUsername(customerUserName);
	}
	
	public void addnewCustomer(Customer customer) {
		 customerrepository.save(customer);
		
	}
}
