package event;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/update")
public class Update extends HttpServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
			PreparedStatement ps=con.prepareStatement("update event set title=?,loc=?,date=?,guest=? where id=?");
			ps.setString(1,req.getParameter("title"));
			ps.setString(2,req.getParameter("loc"));
			ps.setString(3,req.getParameter("date"));
			ps.setString(4, req.getParameter("guest"));
			ps.setInt(5, Integer.parseInt(req.getParameter("id")));
			ps.executeUpdate();
			RequestDispatcher rd=req.getRequestDispatcher("all");
			rd.forward(req, res);
			ps.close();
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}