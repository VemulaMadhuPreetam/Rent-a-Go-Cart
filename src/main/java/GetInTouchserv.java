import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/get_touch")
public class GetInTouchserv extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("GetInTouch service called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String Email = req.getParameter("Email");
		String Message = req.getParameter("Message");
		String Subject = req.getParameter("Subject");
		try
		{
			GetInTouchDAO obj = new GetInTouchDAO();
			obj.addfeedback(name,Email,Message,Subject);
			out.print("alert(\"Your Message was received\nWe will shortly get in touch with you\")");
			res.sendRedirect("GetInTouch.html");
		}
		catch(Exception e){
			res.sendError(500,"Our application is failed due to:" + e);
		}
			
	}
}
