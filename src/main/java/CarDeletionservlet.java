import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Cde")
public class CarDeletionservlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("Login service called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");

		//capture the user data coming from html form
		String c_id = req.getParameter("d_cid");
		//connect with db
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");

			String vsql = "select * from car_details where car_id='"+c_id+"'";

			PreparedStatement pstmt = con.prepareStatement(vsql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(c_id);
			System.out.println(vsql);
			if( rs.next() ){
				String a = "delete from car_details where car_id='"+c_id+"'";
				PreparedStatement pstmt1 = con.prepareStatement(a);
				pstmt1.executeUpdate();
				out.println("<br>Deletion completed<br>");
				System.out.print("Deletion completed");
				
				
			}else{
				req.setAttribute("i_cid",c_id);
				out.println("<br>Invalid car id does not exist<br>");
				System.out.print("Invalid car id does not exist");
			}
			RequestDispatcher rd = req.getRequestDispatcher("vehicles.jsp");
			rd.forward(req,res);
			out.println("</body>");
			out.println("<html>");
			con.close();
		}catch(Exception e){
			res.sendError(500,"Our application is failed due to:" + e);
		}
	
	}
}
