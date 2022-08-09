import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Login")
public class LoginCheckServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("Login service called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");

		//capture the user data coming from html form
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");

		//connect with db
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");

			String vsql = "select * from userdetails where uname=? and pwd=?";

			PreparedStatement pstmt = con.prepareStatement(vsql);
			pstmt.setString(1,uname);
			pstmt.setString(2,pwd);
			ResultSet rs = pstmt.executeQuery();
			
if( rs.next() ){
				req.setAttribute("uname",uname);
				RequestDispatcher rd = req.getRequestDispatcher("/welcome");
				rd.forward(req,res);
				
			}else{
				out.println("<br>Invalid username/password<br>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req,res);
			}
			out.println("</body>");
			out.println("<html>");
			con.close();
		}catch(Exception e){
			res.sendError(500,"Our application is failed due to:" + e);
		}
	
	}
}
