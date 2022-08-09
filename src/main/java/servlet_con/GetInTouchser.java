package servlet_con;


import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/get-touch")
public class GetInTouchser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("Login service called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String message = req.getParameter("message");
		String subject = req.getParameter("subject");
		String fid = email+subject;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");
			System.out.println("Login service called...");
			String a = "insert into feedback (fid,name,email,subject,message) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(a);
			pstmt.setString(1,fid);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setString(4,subject);
			pstmt.setString(5,message);
			System.out.println("Login service called...");
			pstmt.executeUpdate();
			System.out.println("Login service called...");
			out.print("<script>alert(\"We Get in touch shortly\")</script>");
			RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
			rd.forward(req,res);
			con.close();
		}catch(Exception e){
			res.sendError(500,"Our application is failed due to:" + e);
		}
	
	}
}
