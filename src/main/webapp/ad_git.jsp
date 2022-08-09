<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Bookings | Rent a Go-Car</title>
    <link rel = "icon" href="logo.png" type = "image/png">
    <style>
    	*{margin: 0;padding: 0;background-color:grey}
        footer{color: whitesmoke;text-align: center;background-color: rgb(26,29,35);line-height: 1.8;padding: 30px 0px;}
        .home_top{text-align: center;background-color:black;color: white;}
        .tb_middle{overflow: hidden;text-align: center;background-color: white;padding: 10px 0px;}
        .tb_middle a{color: black;text-decoration: none;padding: 0px 5px;}
        .tb_middle a.right{float:right;padding: 0px 20px;}
        .tb_middle a:hover{background-color: white;color: red;}
        .logodown{background-color:white}
		table
        {
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
        }
        table tr td
        {
            padding: 15px;
            border: 1px black solid;
        }
        table .head th
        {
            padding: 10px;
            border: 1px black solid;
            background-color: grey;
        }}
    </style>
</head>
<body>
	<div class = home_top>
        <br><br>
        <img src ="logo.png" height="70" width="70">
        <p><div class = logodown >Rent a Go-Cart</div>Your Key for rental car<br> '</p>
    </div> 
    <div class = "tb_middle">
    	<a href = "userdetails.jsp" >User Details</a>
        <a href = "ad_book.jsp" >  Booking</a>
        <a href = "vehicles.jsp">Vehicles</a>
        <a href = "ad_git.jsp">Get In Touch</a>
       <!--  <a href = LoginPage.html class = "right"><img src ="d2.png" height="17" class="right">Log In </a> -->
    </div>
    <table cellspacing="0">
    <tr class="head">
    	<th>email</th>
    	<th>subject</th>
    	<th>message</th>

    </tr>
    <%
    Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");

	String sql = "Select email,subject,message from feedback";
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	String email,subject,message;
	int i = 1;
	while(rs.next()) {
		
		email = rs.getString("email");
		subject = rs.getString("subject");
		message = rs.getString("message");
	
		
    %>
    <tr>
    	<td><%=email %></td>
    	<td><%=subject %></td>
    	<td><%=message %></td>
    </tr>
    <%} %>
    </table>
</body>
</html>