package com.spi.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static int i;
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// int a=Integer.parseInt((request.getParameter("a")));
		// if(a==1){
		// // List li=new ArrayList();
		// // li.add("2b");
		// // li.add("1a");
		// // li.add("3c");
		// System.out.println("a=1");
		// //
		// }else{
		//
		// System.out.println("a=2");
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Inside controller");
		 List li=new ArrayList();
	 li.add("1a");
		 li.add("2b");
		 
		 li.add("3c");
		Integer s = Integer.parseInt(request.getParameter("input"));
		System.out.println(s);
		if (s == 1) {
			
			System.out.println("a=1");
			i=0;
			request.setAttribute("pat", li.get(i));
			
			RequestDispatcher rd=request.getRequestDispatcher("questions.jsp");
			rd.forward(request, response);

		} else {
			i++;
			request.setAttribute("pat", li.get(i));
			
		RequestDispatcher rd=request.getRequestDispatcher("questions.jsp");
		rd.forward(request, response);
			System.out.println("a=2");
	}
	}

}
