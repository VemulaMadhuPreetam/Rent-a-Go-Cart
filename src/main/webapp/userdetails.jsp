<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>User Details | Rent a Go-Car</title>
    <link rel = "icon" href="logo.png" type = "image/png">
    <style>
    	*{margin: 0;padding: 0;}
        footer{color: whitesmoke;text-align: center;background-color: rgb(26,29,35);line-height: 1.8;padding: 30px 0px;}
        .home_top{text-align: center;background-color:black;color: white;}
        .tb_middle{overflow: hidden;text-align: center;background-color: white;padding: 10px 0px;}
        .tb_middle a{color: black;text-decoration: none;padding: 0px 5px;}
        .tb_middle a.right{float:right;padding: 0px 20px;}
        .tb_middle a:hover{background-color: white;color: red;}
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
        }
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
    	<th>User Name</th>
    	<th>Password</th>
    </tr>
    <tr class="head">
    <form action="userdetails.jsp">
    	<th><input type= "text" id = "name" name = "name"></th>
    	<th><select id="pwd" name = "pwd">
    	<option value="hide">Hide</option>
  			<option value="show">Show</option>
		</select>
    	<input type= "submit" value="Apply"></th>
    </form>
    </tr>
    <%
     Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");
	
	String cri_uname = request.getParameter("name");
	String cri_pwd = request.getParameter("pwd");
	int show = 0;
	
	String sql = "select * from userdetails";
	
	if(cri_uname != null)
	{
		if(cri_uname.equals("") == false)
		{
			sql += " where uname = '"+cri_uname+"'";
		}
	}
	if( cri_pwd != null)
	{
		if(cri_pwd.equals("show"))
		{
			show = 1;
		}
		System.out.println(cri_pwd);
	}
	
	System.out.println(sql+"    "+show);
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	String uname,pwd;
	while(rs.next()) {
		
		uname = rs.getString("uname");
		if(show == 1){pwd = rs.getString("pwd");}
		else{pwd = "************";}
		%>
	    <tr>
	    	<td><%=uname %></td>
	    	<td><%=pwd %></td>
	    </tr>
	    <%} %>
	</table>
</body>
</html>