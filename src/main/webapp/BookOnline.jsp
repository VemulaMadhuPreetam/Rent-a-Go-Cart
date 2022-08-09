<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Online</title>
 <link rel = "icon" href="logo.png" type = "image/png">
    <style>
        *{margin: 0;padding: 0;}
        footer{color: whitesmoke;text-align: center;background-color: rgb(26,29,35);line-height: 1.8;padding: 30px 0px;}
        .home_top{text-align: center;background-color:black;color: white;}
        .logodown{font-size: 28px;padding: 10px;}
        .tb_middle{overflow: hidden;text-align: center;background-color: white;padding: 10px 0px;}
        .tb_middle a{color: black;text-decoration: none;padding: 0px 5px;}
        .tb_middle a.right{float:right;padding: 0px 20px;}
        .tb_middle a:hover{background-color: white;color: red;}
        .HomeCars{background-color: black;color: white;padding: 100px 50px;display: flex;}
        .HomeCar{width: 33%;border-style: solid;border-color: gray;border-width: 1px;width: 360px;height: 650px;}
        .HomeCar img{width:360px ;height:360px;}
        .HomeCar p{font-size: 30px;padding: 0px 30px;}
        .HomeCar p1{font-size: 20px;padding: 0px 30px;}
        .HomeCar button{font-size: 16px;padding: 10px 25px;background-color: blueviolet;border-width: 0px;cursor: pointer;}
    </style>
</head>
<body>
	<div class = home_top>
        <br><br>
        <img src ="logo.png" height="70" width="70">
        <p><div class = logodown >Rent a Go-Cart</div>Your Key for rental car<br> '</p>
    </div> 
    <div class = "tb_middle">
        <a href = HomePage.html >  Home</a>
        <a href = "BookOnline.jsp" >Book Online</a>
        <a href = "OurVehicles.jsp">Our Vehicles</a>
        <a href = "AboutUS.html">About</a>
        <a href = "GetInTouch.html">Get In Touch</a>
       <!--  <a href = LoginPage.html class = "right"><img src ="d2.png" height="17" class="right">Log In </a> -->
    </div>
    <div class="HomeCars">
        &emsp;&emsp;
<% 

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");
	
	String sql = "Select * from car_details";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	String car_id, car_name, car_price, car_photo;
	int i = 1;
	while(rs.next()) {
		
		car_id = rs.getString("car_id");
		car_name = rs.getString("car_name");
		car_price = rs.getString("car_price");
		car_photo = rs.getString("car_photo");
	
	
	%>
	
    
        <div class="HomeCar">
            <img src = "<%=car_photo%>">
            <p> <%=car_name %><br>____________________<br></p>
            <p1>1 hr</p1>
            <br><br>
            <p1>$<%=car_price %></p1>
            <br><br>&emsp;&nbsp;&nbsp;
            <form action="book2" style="padding: 0px 30px;">
            	 <input type="hidden" id="carid" name="carid" value="<%=car_id%>">
                <button> Book Now</button>
            </form>
        </div>
     
        &emsp;&emsp;
        
	
	<%if(i%3 == 0){ %>
	</div>
	<div class="HomeCars">
        &emsp;&emsp;
     <%} %>
<%i += 1; } %>
</div>
<footer>
    <p>gocart@gmail.com</p>
    <p>999999999</p>
    <div class="buttons">
        <button type="button"><img src="footer-fb.png" height="30" width="30"></button>
        <button type="button"><img src="footer-insta.png" height="30" width="30"></button>
    </div>
    <p><br>&copy;2021 by Rent a Go-Car.</p>
</footer>

</body>
</html>