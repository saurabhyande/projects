package studentManagment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginDetail extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		String email1 = "yande@123";
		String pass1 = "123";
		
		if(email.equalsIgnoreCase(email1) && pass.equalsIgnoreCase(pass1))
		{
			RequestDispatcher rd = req.getRequestDispatcher("LandingPage.html");
			rd.forward(req, res);
		}
		else
		{
			PrintWriter pout =res.getWriter();
			pout.write("Invalid cridentials");
			
			RequestDispatcher rd = req.getRequestDispatcher("LoginPage.html");
			rd.include(req, res);
			
			res.setContentType("text/html");
		}
		
	}

}
