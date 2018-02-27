package escallation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import escallation.Registration.GoogleMail;
import escallation.Registration.RegistrationModule;
import escallation.Users.Users;

/**
 * Servlet implementation class BaseController
 */
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int userid=10;
	static int row=1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseController() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("Inside Main Controller---------------");
		Users ure=new Users();
		HttpSession session = request.getSession();
		Object newuser=session.getAttribute("NewUsers");
		if(newuser instanceof Users){
			Users use=(Users) newuser;
			//out.println(use.getFirstname()+"-----------------"+use.getEmail());
			ure.setFirstname(use.getFirstname());
			ure.setEmail(use.getEmail());
			}
		String st1=request.getParameter("name11");
		String st2=request.getParameter("pwd11");
		ure.setUserid(userid);
		ure.setUsername(st1);
		ure.setPassword(st2);

		//out.println(st1+" "+st2);
		RegistrationModule reg=new RegistrationModule();
		int output=reg.register(ure, row);

		userid++;
		row++;
		String username="kingshuk.nandy@spi.com";
		String password="$picity123456";
		String subject="Successful Registration in ABC TeChnology"; 
		String body="You have Successfully Registerd to ABC Technology";
		if(output==1){
			GoogleMail gp=new GoogleMail();
			gp.sendSpimail(username, password, ure.getEmail(), " ", subject, body, "");
			RequestDispatcher rd=request.getRequestDispatcher("RegistrationSuccess.jsp");
			rd.forward(request, response);
			
		}else{
			
			RequestDispatcher rd=request.getRequestDispatcher("RegistrationFailure.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
