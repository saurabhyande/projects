package studentManagment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.cj.protocol.Resultset;


@WebServlet("/read")
public class ReadStudent extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id =Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagment","root","saurabh@123");
			
			PreparedStatement ps = con.prepareStatement("select * from student_table where id=?");
			ps.setInt(1, id);
			
			System.out.println("<table width=75% border=1>");
			System.out.println("<caption>student Result : </caption>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
