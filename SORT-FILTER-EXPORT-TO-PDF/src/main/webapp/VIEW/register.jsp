<%@page import="com.sun.swing.internal.plaf.metal.resources.metal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register page</title>
<style type="text/css">
table {
	border: 3px solid grey;
	padding: 2px;
	border-radius: 2%;
	box-shadow: red;
	background: #fbfcf0;
	align-content: center;
	background: #fbfcf0;
	align-items: center;
	align-self: center;
}

td {
	color: blue;
}
</style>
</head>
<body>
	<h2 align="center">Register Here</h2>

	<form action="reg">
		<table align="center" border="1">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" placeholder="Enter ID"></td>

			</tr>

			<tr>
				<td>User Name</td>
				<td><input type="text" name="uname"
					placeholder="Enter user Name"></td>

			</tr>

			<tr>
				<td>Password</td>
				<td><input type="text" name="pass" placeholder="Enter Password"></td>

			</tr>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name" placeholder="Enter Name"></td>

			</tr>

			<tr>
				<td>Mobile No</td>
				<td><input type="text" name="mobno"
					placeholder="Enter Mob Number"></td>

			</tr>
			<tr>
				<td>Pin code</td>
				<td><input type="text" name="address.pincode"
					placeholder="Enter Pincode"></td>

			</tr>

			<tr>
				<td>Local Area</td>
				<td><input type="text" name="address.areaname"
					placeholder="Enter area name"></td>

			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="address.cityname"
					placeholder="Enter city name"></td>

			</tr>

			<tr>
				<td><input type="submit" value="register"></td>
				<td><a href="log">Click here for login</a></td>

			</tr>

		</table>


		<%
		String message = (String) request.getAttribute("msg");

		if (message != null) {
		%>

		<h3 style="color: red; text-shadow: yellow; font: italic;"
			align="center">${msg}</h3>

		<%
		}
		%>

	</form>
</body>
</html>
