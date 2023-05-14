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

@WebServlet("/update")
public class UpdateStudent extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
//		String email = req.getParameter("email");
//		String yop = req.getParameter("yop");
//		String gender = req.getParameter("gender");
//		String branch = req.getParameter("branch");
		
		int id1 = Integer.parseInt(id); 
		
		
		Connection con =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagment","root","saurabh@123");
			PreparedStatement pr = con.prepareStatement("update student_table set name=? where id=?");
			
			System.out.println("id :"+id1);
			System.out.println("name :"+name);
			
//			System.out.println("email :"+email);
//			System.out.println("yop :"+yop);
//			System.out.println("gender :"+gender);
//			System.out.println("branch :"+branch);
//			
			
			pr.setInt(2, id1);
			pr.setString(1, name);
//			pr.setString(3, email);
//			pr.setString(4, yop);
//			pr.setString(5, gender);
//			pr.setString(6, branch);
			
			pr.execute();
		
			
			
		} catch (ClassNotFoundException e) {
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
