package studentManagment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/studentdata")
public class Student extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Random r = new Random();
		int id = 10+r.nextInt(99);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String yop = req.getParameter("yop");
		String gender = req.getParameter("gender");
		String branch = req.getParameter("branch");
		
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagment","root","saurabh@123");
			PreparedStatement ps = con.prepareStatement("insert into student_table(id,name,email,yop,gender,branch) values(?,?,?,?,?,?)");
			
			
			System.out.println("id : "+id);
			System.out.println("Student name : "+name);
			System.out.println("email : "+email);
			System.out.println("yop : "+yop);
			System.out.println("gender : "+gender);
			System.out.println("branch : "+branch);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, yop);
			ps.setString(5, gender);
			ps.setString(6, branch);
			
			ps.execute();
			
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
