package com.hms.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	@Autowired
	JdbcTemplate jdbc;
	
	public Customer searchByCustomerUserName() {
		return null;
		
	}
	public String AuthenticateUser(String emailId,String customerPassword) {
		String cmd="select count(*) cnt from customer where email_Id=?"+"AND customer_password=?";
		List str=jdbc.query(cmd, new Object[] {emailId,customerPassword},new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs,int rowNum)throws SQLException{
				return rs.getInt("cnt");
			}
		});
		return str.get(0).toString();
		
	}
}
