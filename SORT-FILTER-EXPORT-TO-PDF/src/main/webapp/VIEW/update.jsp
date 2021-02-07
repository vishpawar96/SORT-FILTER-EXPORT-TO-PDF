<%@page import="com.cjc.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>update page</title>

	<style>
		form {
			padding: 15px;
			align-content: center;
		}

		h2 {
			color: red;
		}

		label {
			color: blue;
			font-size: large;
			font-weight: bold
		}

		table {
			border: 1px solid black;
			padding: 35px;
			border-radius: 10%;
			background: #fbfcf0;
			align-content: center;
			align-items: center;
			align-self: center;
		}

		#btn {
			width: 100PX;
			height: 25PX;
			border-radius: 20px;
			color: grey;
			background-color: #fbfcf0;
			font-weight: bold;
		}
	</style>
</head>

<body>
	<div align="center">

		<%
		Student s = (Student) request.getAttribute("stu");
		%>
		<h2>Update Student Data</h2>
		<form action="update" method="get">
			<table style="with: 80%;">

				<tr>
					<td><label>ID: </label></td>
					<td><input type="text" name="id" required="required" value="<%=s.getId()%>"
							contenteditable="false" /></td>
				</tr>

				<tr>
					<td><label>User Name: </label></td>
					<td><input type="text" name="uname" required="required" value="<%=s.getUname()%>" /></td>
				</tr>
				<tr>
					<td><label>Password: </label></td>
					<td><input type="password" name="pass" required="required" value="<%=s.getPass()%>" /></td>
				</tr>
				<tr>
					<td><label>Name: </label></td>
					<td><input type="text" name="name" required="required" value="<%=s.getName()%>" /></td>
				</tr>
				<tr>
					<td><label>Contact No: </label></td>
					<td><input type="text" name="mobno" required="required" value="<%=s.getMobno()%>" /></td>
				</tr>
				<tr>
					<td><label>Pin code: </label></td>
					<td><input type="text" name="address.pincode" placeholder="Enter Pincode"
							value="${stu.address.pincode}"></td>

				</tr>

				<tr>
					<td><label>Local Area: </label></td>
					<td><input type="text" name="address.areaname" placeholder="Enter area name"
							value="<%=s.getAddress().getAreaname()%>"></td>

				</tr>
				<tr>
					<td><label>City: </label></td>
					<td><input type="text" name="address.cityname" placeholder="Enter city name"
							value="<%=s.getAddress().getCityname()%>"></td>

				</tr>
				<tr>
					<td align="center"><input type="submit" value="UPDATE" id="btn" /></td>
					<td align="center"><input type="reset" name="RESET" id="btn" /></td>
				</tr>
			</table>




		</form>



	</div>
</body>

</html>