import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/SignUp")
class SignUpCheck extends HttpServlet{

  private static final long serialVersionUID = 1L;

  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
	  System.out.println("Signup service called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		//set the contentType as html using res object
		res.setContentType("text/html");
        String email = req.getParameter("Username");
        String pwd = req.getParameter("Password");
        String cpwd = req.getParameter("C-Password");
        if(pwd.equals(cpwd)) {
        	try{
        		Class.forName("oracle.jdbc.OracleDriver");
        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");
            
        		String vsql = "select * from userdetails where uname=?";

    			PreparedStatement pstmt = con.prepareStatement(vsql);
    			pstmt.setString(1,email);
    			ResultSet rs = pstmt.executeQuery();
    			
    			if( rs.next() ){
    				req.setAttribute("email",email);
    				out.println("<br>Invalid username exist<br>");
    				System.out.print("Invalid username exist");
    				RequestDispatcher rd = req.getRequestDispatcher("SignupPage.html");
        			rd.forward(req,res);
    				
    			}else{
    				String a = "insert into userdetails values(?,?)";
    				PreparedStatement pstmt1 = con.prepareStatement(a);
    				pstmt1.setString(1,email);
    				pstmt1.setString(2,pwd);
    				pstmt1.executeUpdate();
    				out.println("<br>Insertion completed<br>");
    				System.out.print("Insertion completed");
    				RequestDispatcher rd = req.getRequestDispatcher("login.html");
        			rd.forward(req,res);
    			}
    			
    			out.println("</body>");
    			out.println("<html>");
    			con.close();
        		
        		
        		
        		
        	}catch(Exception e){
        		PrintWriter out1 = res.getWriter();
        		out1.println(e);
        	}
        }
        else {
        	out.print("Password and Confirm Password must be same");
        	RequestDispatcher rd = req.getRequestDispatcher("SignupPage.html");
			rd.forward(req,res);
        }
  }
}