<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Our Vehicles | Rent a Go-Car</title>
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
            .our{background-color: black;color:white;padding: 20px 225px;}
            .our .heading{font-size: 35px;text-align: center;padding: 30px 0px;}
            .our .para1{text-align: center;line-height: 1.5;}
            .HomeCars{background-color: black;color: white;padding: 100px 200px;display: flex;}
            .HomeCar{width: 33%;width: 301px;height: 500px;}
            .HomeCar p{line-height: 1.8;}
            .HomeCar img{padding: 50px 0px;}
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
            <a href = LoginPage.html class = "right"><img src ="d2.png" height="17" class="right">Log In </a>
        </div>
        <div class= "our">
            <div class = "heading">
                <p>Book a Vehicle</p>
            </div>
            <div class="para1">
                <p>Need a little more room? Extra storage space? No matter what you are looking for, we have got a great 
                selection of all the latest and greatest brands and models for rent. Browse below to book a vehicle 
                today!
                </p>
            </div>
        </div>
		<div class="HomeCars">
            &emsp;
<%

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");
	
	String sql = "Select * from car_details";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	String car_id, car_name, car_description, car_photo;
	int i = 1;
	while(rs.next()) {
		
		car_id = rs.getString("car_id");
		car_name = rs.getString("car_name");
		car_description = rs.getString("car_description");
		car_photo = rs.getString("car_photo");
	
	
	%>
	&emsp;
	<div class="HomeCar">
                <h3><%=car_name %></h3>
                <img src = <%=car_photo %> width="301px" height="240px">
                <p>
                    <%= car_description %>
                </p>
            </div>
	
	<%if(i%3 == 0){ %>
	</div>
	<div class="HomeCars">
        &emsp;&emsp;
     <%} %>
<%i += 1; } %>
</div>
</body>
</html>