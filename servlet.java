package serveletDemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Login")
public class Servlet6 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String Username = req.getParameter("UserName");
		String Email = req.getParameter("Email");
		String DateofBirth = req.getParameter("DateofBirth");
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch07","root","");
		    PreparedStatement ps = con.prepareStatement("insert into loginpage(Username,Email,DateofBirth) values(?,?,?)");
		   
		    
		    	System.out.println("Username :"+Username);
		    	System.out.println("Email :"+Email);
		    	System.out.println("DateofBirth :"+DateofBirth);
		    	
		    	ps.setString(1, Username);
		    	ps.setString(2, Email);
		    	ps.setString(3, DateofBirth);
		    	
		    	ps.execute();
		    	System.out.println("data is saved");
			
			PrintWriter pw = res.getWriter();
		    	res.setContentType("text/html");
		    	
		    	pw.println("User Name : "+Username+"<br>");
		    	pw.println("Email : "+Email+"<br>");
		    	pw.println("Date of Birth : "+DateofBirth);
		   
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
					System.out.println("connection close");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

