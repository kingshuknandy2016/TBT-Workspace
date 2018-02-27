package com.spi.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Servlet implementation class FlowTest
 */
public class FlowTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static int init1=0;
	static int service1=0;
	static int destroy1=0;
	
    public FlowTest() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Inside constructor");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Inside inti");
		init1++;
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Inside destroy");
		destroy1++;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside service");
		service1++;
		PrintWriter out=response.getWriter();
		out.println("Init"+init1);
		out.println("service"+service1);
		out.println("destroy"+destroy1);
		destroy();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		System.out.println("Inside doget");
		PrintWriter out=resp.getWriter();
		out.println("INside doget");
	}

}
