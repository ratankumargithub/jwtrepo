package p1;

import java.io.IOException;
import java.security.Key;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwt;

/**
 * Servlet implementation class Srv
 */
@WebServlet("/Srv")
public class Srv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Srv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String loginAs=request.getParameter("loginAs");
		
		
		String page="invalidLogin.jsp";
		
		if(loginAs.equals("Admin")){
			
			if(uname.equals("ram") && pass.equals("123")){
				
	
				
				page="adminHome.jsp";
			}
		}
		
		if(loginAs.equals("Clerk")){
			
			if(uname.equals("ramesh") && pass.equals("123"))
				page="clerkHome.jsp";
			
		}
		
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
