package com.hms.demo;
import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Registration {

	@Id
	@Column
	private int id;	
	@Column
	private String FirstName;
	@Column
	private String LastName;
	@Column
	private String Dob;
	@Column
	private double mobile;
	@Column
	private String Pan_Id;
	@Column
	private String password;
	@Column
	private String user_id;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	
	public double getMobile() {
		return mobile;
	}
	public void setMobile(double mobile) {
		this.mobile = mobile;
	}
	public String getPan_Id() {
		return Pan_Id;
	}
	public void setPan_Id(String pan_Id) {
		Pan_Id = pan_Id;
	}
	
}
