package com.spi.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control of servlet2 initiation");
		//PrintWriter out=response.getWriter();
		//out.print("Welcome"+request.getAttribute("user").toString());
		//String s=request.getParameter("userName");
		//System.out.println("second:"+s);
		
		 request.setAttribute("s1a", "3");
		 request.setAttribute("s1b", "4");
		
		RequestDispatcher rd=request.getRequestDispatcher("Success");
		//rd.forward(request, response);
		System.out.println("control of servlet2");
		PrintWriter out=response.getWriter();
		out.println("<h1>World</h1>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	}

}
