package com.hms.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	@Query("from Customer where customerUserName=:username")
	public Customer searchCustomerByUsername(@Param("username") String username);
}
