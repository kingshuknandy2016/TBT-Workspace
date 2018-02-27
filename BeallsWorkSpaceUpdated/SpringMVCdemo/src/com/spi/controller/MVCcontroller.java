package com.spi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.Contended;


@Controller
public class MVCcontroller {

	
	@RequestMapping(value = "/click", method = RequestMethod.GET)
	public ModelAndView registration() {
		System.out.println("Success view called ::");
		return new ModelAndView("success");
	}
}
