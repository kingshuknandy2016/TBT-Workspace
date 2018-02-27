package com.spi.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control of servlet1 initiation");
		
		 String n=request.getParameter("userName");  
		 String p=request.getParameter("userPass"); 
		// System.out.println("---------"+n+p);
		 request.setAttribute("s1a", "1");
		 request.setAttribute("s1b", "2");
		 ApplicationContext acApplicationContext;
		 
		 RequestDispatcher rd=request.getRequestDispatcher("Welcome");
		
		// rd.forward(request, response);
		 //rd.forward(request, response);
		 System.out.println("control of servlet1");
		 PrintWriter out=response.getWriter();
		
		 out.println("<h1>calling command</h1>");
		 rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
