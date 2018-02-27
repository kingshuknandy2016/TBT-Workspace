package com.spi.controller;

import java.awt.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		ModelAndView model;
		/*if(user.equals("sid") && pass.equals("h")){
			System.out.println("--------------------------");
			model=new ModelAndView("success","msg","welcome to SPI,Mysore");
		}else
			model=new ModelAndView("failure","msg","Please Re-Try");
		*/
		ArrayList li=new ArrayList();
		li.add("123");
		li.add("xyz");
		li.add("pqr");
		li.add("lmn");
		
		return new ModelAndView("success","message",li);
		
		
		
		
		
	}

}
