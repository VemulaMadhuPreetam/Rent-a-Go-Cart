import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet
{
	private static final long serialVersionUID = 4805983713800417420L;

	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		System.out.println("service welcome called...");
		//to send the response to the browser
		PrintWriter out = res.getWriter();

		res.setContentType("text/html");

		
		String uname = (String)req.getParameter("uname");
		//out.println("Welcome to: " + uname);
		if(uname.equals("20@gmail.com"))
		{
			System.out.print(uname);
			RequestDispatcher rd = req.getRequestDispatcher("ad_book.jsp");
			rd.include(req, res);
		}
		else {
		RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
		rd.include(req,res);
		}
	}

}