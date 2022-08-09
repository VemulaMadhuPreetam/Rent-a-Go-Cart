<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Vehicles | Rent a Go-Car</title>
    <link rel = "icon" href="logo.png" type = "image/png">
    <style>
    	*{margin: 0;padding: 0;}
        footer{color: whitesmoke;text-align: center;background-color: rgb(26,29,35);line-height: 1.8;padding: 30px 0px;}
        .home_top{text-align: center;background-color:black;color: white;}
        .tb_middle{overflow: hidden;text-align: center;background-color: white;padding: 10px 0px;}
        .tb_middle a{color: black;text-decoration: none;padding: 0px 5px;}
        .tb_middle a.right{float:right;padding: 0px 20px;}
        .tb_middle a:hover{background-color: white;color: red;}
        .feedback1{display:none}
        .feedback2{display:none}
        .feedback3{display:none}
        .insert-button {
            color: red;
            }
            .update-button {
            color: red;
            }
            .delete-button {
            color: red;
            }
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
    <script>
            function insertForm() {
                document.getElementById("myForm1").style.display = "block";
                document.getElementById("myForm2").style.display = "none";
                document.getElementById("myForm3").style.display = "none";
                }
            function deleteForm() {
                document.getElementById("myForm2").style.display = "block";
                document.getElementById("myForm1").style.display = "none";
                document.getElementById("myForm3").style.display = "none";
                }
            function updateForm() {
                document.getElementById("myForm3").style.display = "block";
                document.getElementById("myForm2").style.display = "none";
                document.getElementById("myForm1").style.display = "none";
                }

            function closeForm() {
            document.getElementById("myForm1").style.display = "none";
            document.getElementById("myForm2").style.display = "none";
            document.getElementById("myForm3").style.display = "none";
            }
        </script>
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
    <div class="Social" style="text-align: center;">
        <button class="insert-button" onclick="insertForm()">Insert</button>
        <button class="update-button" onclick="deleteForm()">Delete</button>
        <button class="delete-button" onclick="updateForm()">Update</button>
    <div class="feedback1" id="myForm1">
        <form  class="Ratecontainer" action = "Cin" method= "post" >
               Car Id: <input type = "text" id="i_cid" name = "i_cid" placeholder="Enter car id"  maxlength="100" required><br>
               Car Name:<input type = "text" id="i_cname" name = "i_cname" placeholder="Enter car name"  required><br>
               Car Photo: <input type = "text" id="i_photo" name = "i_photo" placeholder="Enter car photo name"  required><br>
               Car Price: <input type = "number" id="i_price" name = "i_price" placeholder="Enter car price"  required><br>
               Car Description <textarea  id="i_desc" name = "i_desc" placeholder="Enter Your car description"  required></textarea><br>
                <button type="submit" class="btn">Insert</button>
                <button class="open-button" onclick="closeForm()">Close</button>
        </form>
    </div>
    <div class="feedback2" id="myForm2" >
        <form  class="Ratecontainer" action = "Cde" method= "post">
            Car Id: <input type = "text" id="d_cid" name = "d_cid" placeholder="Enter car id"  maxlength="100" required><br>
            <button type="submit" class="btn">Delete</button>
            <button class="open-button" onclick="closeForm()">Close</button>
        </form>
    </div>
    <div class="feedback3" id="myForm3">
        <form  class="Ratecontainer">
               Car Id: <input type = "text" id="u_cid" name = "u_cid" placeholder="Enter car id"  maxlength="100" required><br>
               Car Name:<input type = "text" id="u_cname" name = "u_cname" placeholder="Enter car name"  required><br>
               Car Photo: <input type = "text" id="u_photo" name = "u_photo" placeholder="Enter car photo name"  required><br>
               Car Price: <input type = "number" id="u_price" name = "u_price" placeholder="Enter car price"  required><br>
               Car Description <textarea  id="u_desc" name = "u_desc" placeholder="Enter Your car description"  required></textarea><br>
                <button type="submit" class="btn">Update</button>
                <button class="open-button" onclick="closeForm()">Close</button>
        </form>
    </div>
    </div>
    <table cellspacing="0">
    <%
     Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","preetam");
	


	String sql = "select * from car_details";
	

	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	String c_id,c_name,c_photo,c_price;
	while(rs.next()) {
		c_id = rs.getString("car_id");
		c_name = rs.getString("car_name");
		c_photo = rs.getString("car_photo");
		c_price = rs.getString("car_price");
		%>
	    <tr>
	    	<td><img src = <%="\""+c_photo+"\"" %> height="300" width="300" ></td>
	    	<td><%=c_id %></td>
	    	<td><%=c_name %></td>
	    	<td><%=c_price %></td>
	    </tr>
	    <%} %>
	</table>
</body>
</html>