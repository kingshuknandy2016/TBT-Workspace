package com.spi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spi.database.UserDao;
import com.spi.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		System.out.println("Registration view called ::");
		return new ModelAndView("registration", "registrationModel", new User());
	}
	
	@RequestMapping(value = "/addToDatabase", method = RequestMethod.POST)
	public ModelAndView addToDatabase(@ModelAttribute("registrationModel") User user, ModelMap model) {
		if (user != null) { 
			System.out.println("User : " + user);
			System.out.println("Adding user to database.");
			
			userDao.insertUser(user);
		}
		
	    return new ModelAndView("successfullyregistered", "msg", user.getFirstname());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("Login view called ::");
		return new ModelAndView("login", "loginmodel", new User());
	}
	
	@RequestMapping(value = "/checkForUser", method = RequestMethod.POST)
	public  ModelAndView checkForUser(@ModelAttribute("loginmodel") User user, ModelMap model) {
		ModelAndView model11 = null;
		if (user != null) { 
			System.out.println("User : " + user);
			System.out.println("Checking in database");
			
			User CheckedUser=userDao.retrieveUser(user.getUsername());
			if(CheckedUser != null){
				if(user.getPassword().equals(CheckedUser.getPassword())){
					model11=new ModelAndView("success", "msg", "welcome  "+CheckedUser.getFirstname() +" "+CheckedUser.getLastname());
				}else{
					model11=new ModelAndView("login", "msg", "Please check your password");
				}
					
			}else {
				model11=new ModelAndView("unregistered");
				System.out.println("you are not registered");
				
			}
		}
		
	   return model11;
	}
}