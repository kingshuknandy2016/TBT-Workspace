package com.spi.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.pool.impl.GenericKeyedObjectPool.Config;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public DemoServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
    
    String str;
    ServletConfig config ;
    ServletContext context;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	config = getServletConfig();
    	context=config.getServletContext();
    	context.setAttribute("tool", "RAM");
    							
    	//System.out.println(context.getInitParameter("pass")+"-------------------");
    	//str=config.getInitParameter("user");
    	//System.out.println("config parameter:"+ str);
//    	Enumeration enu=config.getInitParameterNames();
//    	while(enu.hasMoreElements())
//    	{
//    		System.out.println(enu.nextElement()+"---------");
//    	}
    	
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("Demo2");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
