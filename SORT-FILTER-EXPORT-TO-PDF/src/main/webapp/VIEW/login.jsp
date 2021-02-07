<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Login page</title>
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

		tr {
			color: blue;
		}
	</style>
</head>

<body style="align-content: center;">
	<h2 align="center">Login here</h2>
	<form action="login" style="align-content: center;">

		<table align="center" border="1">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="uname" placeholder="Enter User Name"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="pass" placeholder="Enter Password"></td>
			</tr>
			<tr>
				<td>Login</td>
				<td><input type="submit" value="submit"></td>
			</tr>
			<tr>
				<td>for registration</td>
				<td><a href="register">click here </a></td>
			</tr>
		</table>

		<%
		String message =(String) request.getAttribute("msg");

		if (message != null) {
		%>

		<h3 style="color: red; text-shadow: yellow; font: italic; font-weight: bold;" align="center">${msg}</h3>

		<%
		}
		%>
	</form>
</body>

</html>
