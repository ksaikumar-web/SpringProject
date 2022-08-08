package com.hms.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Menu")
public class Menu {

	@Id
	private int menuId;
	private String menuName;
	private double menuPrice;
	private String menuSpeciality;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(double menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuSpeciality() {
		return menuSpeciality;
	}
	public void setMenuSpeciality(String menuSpeciality) {
		this.menuSpeciality = menuSpeciality;
	}
	
}
