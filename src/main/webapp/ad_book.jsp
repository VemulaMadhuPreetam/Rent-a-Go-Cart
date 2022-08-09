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
    	<th>name</th>
    	<th>l_no</th>
    	<th>c_id</th>
    	<th>date</th>
    	<th>time</th>
    	<th>hrs</th>
    	<th>cost</th>

    </tr>
    <form action="ad_book.jsp">
    	<tr class="head">
    	<th><input type= "text" id = "name" name = "name"></th>
    	<th><input type= "text" id = "l_no" name = "l_no"></th>
    	<th><input type= "text" id = "c_id" name = "c_id"></th>
    	<th><input type= "text" id = "date" name = "date"></th>
    	<th><input type= "text" id = "time" name = "time"></th>
    	<th><input type= "number" id = "hrs" name = "hrs" min=0></th>
    	<th><input type = "text" id ="cost" name = "cost" ><input type = "submit" value="apply" ></th>
    	</tr>
    </form>
    <%
    System.out.print("'"+"    yigiygrgireg");
    Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");
	
	String cri_name = request.getParameter("name");
	String cri_l_no = request.getParameter("l_no");
	String cri_c_id = request.getParameter("c_id");
	String cri_date = request.getParameter("date");
	String cri_time = request.getParameter("time");
	String cri_hrs  = request.getParameter("hrs");
	String cri_cost = request.getParameter("cost");
	int flag = 0;
	
	String sql = "Select  name,l_no,data,time,hrs,cost,c_id from booking";
	
	if(cri_name != null)
	{
		if(cri_name.equals("") == false)
		{
			if(flag == 0)
			{
				sql += " where";
				flag = 1;
			}
			sql += " name = '"+cri_name+"'";
		}
	}
	if( cri_l_no != null)
	{
		if(cri_l_no.equals("") == false){
		if(flag == 0)
		{
			sql += " where";
			flag = 1;
		}
		else
		{
			sql += " and ";
		}
		sql += " l_no = '"+cri_l_no+"'";
	}}
	if(cri_c_id != null)
	{
		if((cri_c_id.equals("") == false)){
		if(flag == 0)
		{
			sql += " where";
			flag = 1;
		}
		else
		{
			sql += " and ";
		}
		sql += " c_id = '"+cri_c_id+"'";
	}}
	if( cri_date != null)
	{
	if(cri_date.equals("") == false){
		if(flag == 0)
		{
			sql += " where";
			flag = 1;
		}
		else
		{
			sql += " and ";
		}
		sql += " data = '"+cri_date+"'";
	}
	}
	if(cri_time != null)
	{
	if(cri_time.equals("") == false){
		if(flag == 0)
		{
			sql += " where";
			flag = 1;
		}
		else
		{
			sql += " and ";
		}
		sql += " time = '"+cri_time+"'";
	}}
	if(cri_hrs != null)
	{
		if(cri_hrs.equals("") == false) {
		if(flag == 0)
		{
			sql += " where";
			flag = 1;
		}
		else
		{
			sql += " and ";
		}
		sql += " hrs = "+cri_hrs;
	}}
	if(cri_cost != null)
	{
		if(cri_cost.equals("") ==false){
		if(flag == 0)
		{
			sql += " where";
			flag = 1;
		}
		else
		{
			sql += " and ";
		}
		sql += " cost = '"+cri_cost+"'";
	}}
	System.out.print(sql+"     1"+cri_name+"1      "+cri_c_id);
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	String name,l_no,date,time,hrs,cost,c_id;
	int i = 1;
	while(rs.next()) {
		
		name = rs.getString("name");
		l_no = rs.getString("l_no");
		c_id = rs.getString("c_id");
		date = rs.getString("data");
		time = rs.getString("time");
		hrs = rs.getString("hrs");
		cost = rs.getString("cost");
		request.getParameter("name");
		
    %>
    <tr>
    	<td><%=name %></td>
    	<td><%=l_no %></td>
    	<td><%=c_id %></td>
    	<td><%=date %></td>
    	<td><%=time %></td>
    	<td><%=hrs %></td>
    	<td>$<%=cost %></td>

    </tr>
    <%} %>
    </table>
</body>
</html>