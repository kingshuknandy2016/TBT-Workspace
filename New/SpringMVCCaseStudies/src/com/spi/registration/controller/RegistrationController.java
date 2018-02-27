package com.spi.registration.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spi.dao.EmployeeDAO;
import com.spi.exception.RegistrationEmployeeException;
import com.spi.model.Employee;

@Controller
public class RegistrationController {

	@RequestMapping("/insert.htm")
	public ModelAndView create(HttpServletRequest request , HttpServletResponse response ){
		
		ModelAndView model=null;
		
		String empid=request.getParameter("eid");
		String name=request.getParameter("name");
		String emaild=request.getParameter("emailid");
		String pin=request.getParameter("pincode");
		String cellno=request.getParameter("cellno");
		
		
		try {
			  int eid=Integer.parseInt(empid);
			  int ipin=Integer.parseInt(pin);
			  long cno=Long.parseLong(cellno);
			  Employee emp=new Employee();
			  emp.setEmpid(eid);
			  emp.setName(name);
			  emp.setEmailid(emaild);
			  emp.setPincode(ipin);
			  emp.setCellno(cno);
			  System.out.println("Acceepted the values");
			  EmployeeDAO dao=new EmployeeDAO();
			  boolean flag=dao.insertEmployee(emp);
			  if(flag){
				  System.out.println("sucessss *******"+flag);
				  model=new ModelAndView("success","message","created");
			  }else{
				  model=new ModelAndView("../../registration","message","Unsuccessful");
			  }
			  
			  
			  
				
			  
		} catch (NumberFormatException nfe) {
			try {
				throw new RegistrationEmployeeException(nfe);
			} catch (RegistrationEmployeeException e) {
				// TODO Auto-generated catch block
				model=new ModelAndView("../../error","message",e.getMessage());
			}
		}
		
		
		
		
		return model;
		
	}
	
	//@ExceptionHandler///scope within class

	
}


//@ControllerAdvice//
