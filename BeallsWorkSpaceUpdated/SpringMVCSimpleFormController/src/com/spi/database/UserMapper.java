package com.spi.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spi.model.User;

public class UserMapper implements  RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		  User user = new User();
		  user.setFirstname(rs.getString("fname"));
		  user.setLastname(rs.getString("lname"));
		  user.setUsername(rs.getString("username"));
		  user.setPassword(rs.getString("password"));
		  user.setGender(rs.getString("gender"));
		return user;
	}

}
