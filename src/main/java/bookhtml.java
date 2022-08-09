import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/Book_html")
public class bookhtml extends HttpServlet
 {
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("Bookhtml service called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");	
		Double cost_ph = 15.26;
		String c_id = req.getParameter("carid");
		req.setAttribute("c_id",c_id);
		System.out.println(c_id);
		out.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <title>Book</title>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <style>\r\n"
				+ "       *{margin: 0;padding: 0;}\r\n"
				+ "       .home_top{text-align: center;background-color:black;color: white;}\r\n"
				+ "       .bill{background-image:linear-gradient(to right,#c6ffdd,#fbd786,#f7797d);color: black;padding: 100px 500px;display: flex;}\r\n"
				+ "       .tb{ background-color:whitesmoke;border-radius:10px;padding: 10px 20px;width: 40%;width: 350px;height: 250px;}\r\n"
				+ "    </style>\r\n"
				+ "   <script>\n"
				+ " function costup() {"
				+ " var hrs = document.getElementById(\"hrs\").value;"
				
				+ " document.getElementById(\"cost\").value = hrs*"+String.valueOf(cost_ph)+";"
				+ " var Cost = document.getElementById(\"cost\").value;"
				+ " document.getElementById(\"cost\").value = \"$\"+Cost"
				+ "}"
		 		+ "    </script> \n"
				+ "  </head>\r\n"
				+ "  <body >\r\n"
				+ "    <div class = home_top>\r\n"
				+ "      <br><br>\r\n"
				+ "      <img src =\"logo.png\" height=\"70\" width=\"70\">\r\n"
				+ "      <p><div class = logodown >Rent a Go-Cart</div>Your Key for rental car<br> '</p>\r\n"
				+ "  </div> \r\n"
				+ "  <div class=\"bill\" >\r\n"
				+ "    <form  action = \"Books\" method=\"post\">\r\n"
				+ "    <table class = \"tb\">\r\n"
				+ "      <tr>\r\n"
				+ "        <td><label for=\"name\">Name</label></td>\r\n"
				+ "        <td><input type=\"text\" name=\"name\" id=\"name\" required></td>\r\n"
				+ "      </tr>\r\n"
				+ "      <br><br>\r\n"
				+ "      <tr>\r\n"
				+ "        <td><label for=\"email\">Email</label></td>\r\n"
				+ "        <td><input type=\"email\" name=\"email\" id=\"email\" required></td>\r\n"
				+ "      </tr>\r\n"
				+ "      <!-- Linsnce number-->\r\n"
				+ "      <tr>\r\n"
				+ "        <td><label for=\"lnumber\">License Number</label></td>\r\n"
				+ "        <td><input type=\"text\" name=\"lnumber\" id=\"lnumber\" required></td>\r\n"
				+ "      </tr>\r\n"
				+ "      <!-- time and date of the solt booking-->\r\n"
				+ "      <tr>\r\n"
				+ "        <td><label for=\"date\">Date</label></td>\r\n"
				+ "        <td><input type=\"date\" name=\"date\" id=\"date\" required></td>\r\n"
				+ "      </tr>\r\n"
				+ "      <tr>\r\n"
				+ "        <td><label for=\"time\">Time</label></td>\r\n"
				+ "        <td><input type=\"time\" name=\"time\" id=\"time\"  required></td>\r\n"
				+ "		<tr>\r\n"
				+ "        <td><label for=\"hrs\">Number of hours</label></td>\r\n"
				+ "        <td><input type=\"number\" name=\"hrs\" id=\"hrs\" min=\"0\" value = \"1\" onchange=\"costup()\" required></td>\r\n"
				+ "      </tr>\r\n"
				+"<input type=\"hidden\" name=\"c_id\" id = \"c_id\" value=\""+c_id+"\" >"
				+ "      </tr>\r\n"
				+ "      <tr>\r\n"
				+ "        <td><label for=\"cost\">Cost</label></td>\r\n"
				+ "        <td><input type=\"text\" name=\"cost\" id=\"cost\" value = "+"$"+String.valueOf(cost_ph)+" onchange=\"costup()\" required></td>\r\n"
				+ "      </tr>\r\n"
				+ "      <tr>\r\n"
				+ "        <td><input type=\"submit\" value=\"Pay Now\"></td>\r\n"
				+ "      </tr>\r\n"
				+ "    </table>\r\n"
				+ "    </form>\r\n"
				+ "  </div>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
	}
}
