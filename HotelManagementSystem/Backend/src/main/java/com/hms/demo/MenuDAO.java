package com.hms.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAO {

	@Autowired  
    JdbcTemplate jdbc;  
	
	public Menu searchMenu(int menuId) {
		String cmd = "select * from Menu where menu_id=?";
		List<Menu> menuList=jdbc.query(cmd,new Object[] {menuId}, new RowMapper<Menu>() {

			@Override
			public Menu mapRow(ResultSet rs, int arg1) throws SQLException {
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("MENU_ID"));
				menu.setMenuName(rs.getString("MENU_NAME"));
				menu.setMenuPrice(rs.getDouble("MENU_PRICE"));
				menu.setMenuSpeciality(rs.getString("MENU_SPECIALITY"));
				return menu;
			}	
		});
		return menuList.get(0);
		
	}
}
