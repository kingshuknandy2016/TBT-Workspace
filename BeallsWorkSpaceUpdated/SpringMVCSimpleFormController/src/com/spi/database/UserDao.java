package com.spi.database;

import com.spi.model.User;

public interface UserDao {

    public void insertUser(User user);
    
    public User retrieveUser(String username);
}
