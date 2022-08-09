import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Cin")
public class CarInsertionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("Login service called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");

		//capture the user data coming from html form
		String c_id = req.getParameter("i_cid");
		String c_name = req.getParameter("i_cname");
		String c_photo = req.getParameter("i_photo");
		String c_price = req.getParameter("i_price");
		String c_desc = req.getParameter("i_desc");
		//connect with db
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");

			String vsql = "select * from car_details where car_id=?";

			PreparedStatement pstmt = con.prepareStatement(vsql);
			pstmt.setString(1,c_id);
			ResultSet rs = pstmt.executeQuery();
			
			if( rs.next() ){
				req.setAttribute("i_cid",c_id);
				out.println("<br>Invalid car id exist<br>");
				System.out.print("Invalid car id exist");
				
				
			}else{
				String a = "insert into car_details values(?,?,?,?,?)";
				PreparedStatement pstmt1 = con.prepareStatement(a);
				pstmt1.setString(1,c_id);
				pstmt1.setString(2,c_name);
				pstmt1.setString(3,c_desc);
				pstmt1.setString(4,c_photo);
				pstmt1.setString(5,c_price);
				pstmt1.executeUpdate();
				out.println("<br>Insertion completed<br>");
				System.out.print("Insertion completed");
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
