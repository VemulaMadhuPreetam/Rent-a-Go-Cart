import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/Books")
public class book extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("book called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");

		//capture the user data coming from html form
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String lnumber = req.getParameter("lnumber");
		String date = req.getParameter("date");
		
		double cost = Double.parseDouble(req.getParameter("cost").substring(1));
		System.out.print(cost);
		String time = req.getParameter("time");
		//connect with db
		String c_id =  req.getParameter("c_id");
		String car_photo = "logo.png";
		String car_name = "Car name";
		int hrs =  Integer.parseInt(req.getParameter("hrs"));
		String un = req.getParameter("uname");
		System.out.print(c_id+"456"+un);
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");

			String vsql = "insert into booking values(?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(vsql);
			pstmt.setString(1,name);
			pstmt.setString(2,email);
			pstmt.setString(3,lnumber);
			pstmt.setString(4,date);
			pstmt.setString(5,time);
			pstmt.setDouble(6,cost);
			pstmt.setString(7,c_id);
			pstmt.setInt(8, hrs);
			pstmt.executeUpdate();
			System.out.print("step1 done");
			String car_query = "select * from car_details where car_id = ?";
			System.out.print("step1 done");
			PreparedStatement pstmt1 = con.prepareStatement(car_query);
			pstmt1.setString(1,c_id);
			System.out.print("step1 done");
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next())
			{
				car_name = rs.getString("car_name");
				car_photo = rs.getString("car_photo");
			}
			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "    <head>\r\n"
					+ "        <title>Get in Touch | Rent a Go-Cart</title>\r\n"
					+ "        <link rel = \"icon\" href=\"logo.png\" type = \"image/png\">\r\n"
					+ "        <style>\r\n"
					+ "            *{margin: 0;padding: 0;}\r\n"
					+ "            body{background-image: url(back.png);background-attachment: fixed;background-repeat: no-repeat;background-size: cover;}\r\n"
					+ "            footer{color: whitesmoke;text-align: center;background-color: rgb(26,29,35);}\r\n"
					+ "            form{background-color: rgb(192, 128, 8); padding: 100px 150px;}\r\n"
					+ "            table, td, th {\r\n"
					+ "            border: 1px solid;\r\n"
					+ "            padding: 20px 30px;\r\n"
					+ "            }\r\n"
					+ "\r\n"
					+ "            table {\r\n"
					+ "            width: 100%;\r\n"
					+ "            border-collapse: collapse;\r\n"
					+ "            }\r\n"
					+ "            .home_top{text-align: center;background-color:black;color: white;}\r\n"
					+ "            .logodown{font-size: 28px;padding: 10px;}\r\n"
					+ "            .bill{padding: 100px 300px;}\r\n"
					+ "            .bill p{font-size: 96px;}\r\n"
					+ "        </style>\r\n"
					+ "    </head>\r\n"
					+ "    <body>\r\n"
					+ "        <div class = home_top>\r\n"
					+ "            <br><br>\r\n"
					+ "            <img src =\"logo.png\" height=\"70\" width=\"70\">\r\n"
					+ "            <p><div class = logodown >Rent a Go-Cart</div>Your Key for rental car<br> '</p>\r\n"
					+ "        </div> \r\n"
					+ "        <div class = \"tb_middle\">\r\n"
					+ "            <a href = HomePage.html >  Home</a>\r\n"
					+ "            <a href = \"BookOnline.jsp\" >Book Online</a>\r\n"
					+ "            <a href = \"OurVehicles.jsp\">Our Vehicles</a>\r\n"
					+ "            <a href = \"AboutUS.html\">About</a>\r\n"
					+ "            <a href = \"GetInTouch.html\">Get In Touch</a>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"bill\">\r\n"
					+ "        <form>\r\n"
					+ "            <p><img src =\"logo.png\" height=\"70\" width=\"70\">&emsp;Bill</p><br>\r\n"
					+ "            <img src=\""+car_photo+"\" height=\"360px\" width=\"450px\" >\r\n"
					+ "            <table>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td><b>Car Name</b></td>\r\n"
					+ "                    <td>"+car_name+"</td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td><b>Car id</b></td>\r\n"
					+ "                    <td>"+c_id+"</td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td><b>Custmor Name</b></td>\r\n"
					+ "                    <td>"+name+"</td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td><b>License Number</b></td>\r\n"
					+ "                    <td>"+lnumber+"</td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td><b>From Date/Time</b></td>\r\n"
					+ "                    <td>"+date+"/"+time+"</td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td><b>To Date/Time</b></td>\r\n"
					+ "                    <td>To Date/Time</td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td><b>Total cost</b></td>\r\n"
					+ "                    <td>"+"$"+String.valueOf(cost)+"</td>\r\n"
					+ "                </tr>\r\n"
					+ "            </table>\r\n"
					+ "        </form>\r\n"
					+ "        </div>\r\n"
					+ "    </body>\r\n"
					+ "    <footer>\r\n"
					+ "        <p>gocart@gmail.com</p>\r\n"
					+ "        <p>999999999</p>\r\n"
					+ "        <div class=\"buttons\">\r\n"
					+ "            <button type=\"button\"><img src=\"footer-fb.png\" height=\"30\" width=\"30\"></button>\r\n"
					+ "            <button type=\"button\"><img src=\"footer-insta.png\" height=\"30\" width=\"30\"></button>\r\n"
					+ "        </div>\r\n"
					+ "        <p>©2021 by Rent a Go-Cart.</p>\r\n"
					+ "    </footer>\r\n"
					+ "</html>");
			con.close();
		}catch(Exception e){
			res.sendError(500,"Our application is failed due to:" + e);
		}
	
	}
}
