package com.spi.basics;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccessController
 */
public class SuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
    		throws ServletException, IOException {
    	super.service(arg0, arg1);
    	System.out.println("////////////////////////");
    	doGet(arg0, arg1);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	

}
