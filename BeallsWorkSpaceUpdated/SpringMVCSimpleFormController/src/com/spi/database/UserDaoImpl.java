package com.spi.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spi.model.User;

public class UserDaoImpl implements UserDao {

	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	

	private final String user_insert = "INSERT INTO userregistration (fname, lname, username, password, gender) VALUES (?, ?, ?, ?,?)";

	public void insertUser(User user) {
          System.out.println("Inside insert user");
	      jdbcTemplate.update(this.user_insert, user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getGender() );
	}

	@Override
	public User retrieveUser(String username) {
		
		User user=null;
		System.out.println("Inside retrieveUser user");
		String SQL = "select * from userregistration where username = ?";
		try {
			user = jdbcTemplate.queryForObject(SQL,new Object[]{username}, new UserMapper());
			} catch (Exception e) {
			// TODO: handle exception
		}
       return user;
	}

	
}
