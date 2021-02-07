<%@page import="java.util.List"%>
<%@page import="com.cjc.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>success page</title>

<script type="text/javascript">
	function editrecord() {
		alert("Are you sure, you want to edit record?")
		document.myfunction.action = "edit";
		document.myfunction.submit();
	}

	function deleterecord() {
		alert("Are you sure, you want to delete record?")
		document.myfunction.action = "delete";
		document.myfunction.submit();
	}

	function addrecord() {
		alert("Are you sure, you want to add record?")
		document.myfunction.action = "register";
		document.myfunction.submit();
	}

	function sortrecord() {
		alert("Are you sure, you want to sort record?")
		document.myfunction.action = "sort";
		document.myfunction.submit();
	}

	function clearFilter() {
		alert("Are you sure, you want to clear Filter?")
		document.myfunction.action = "clear";
		document.myfunction.submit();
	}
</script>

<style>
label {
	color: green;
	text-align: center;
	align-content: center;
	align-items: center;
	align-self: center;
}

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

th {
	color: blue;
	background-color: #def0da;
	border: 2PX solid grey;
}

td {
	background-color: #fbfcf0;
	border: 2PX solid grey;
	color: neon;
	align-content: center;
}

#btn {
	height: 25PX;
	border-radius: 20px;
	color: blue;
	background-color: #def0da;
	font-weight: bold;
}
</style>
</head>

<body>

	<div align="center">

		<h1 style="color: red;" align="center">Employee Management System</h1>
		<h2 style="color: red;" align="center">Employee Details:</h2>
		<br> 
		<table>
		<tr>
		<td><a href="/exportpdf">Export to PDF</a></td>
		<td><a href="/exportexcel">Export to Excel</a> </td>
		 </tr>		
		</table>
		
		

		<form action="filter">
			<br>
			<table>
				<tr>
					<td>Enter Keyword to Filter</td>
					<td><input type="text" name="keyword" required="required"
						value="${keyword}"></td>
					<td><input type="submit" value="Search" id="btn"></td>
					<td><input type="button" value="clear" id="btn"
						onclick="clearFilter()"></td>
				</tr>

			</table>

			<br>


		</form>

	</div>

	<div align="center">

		<form name="myfunction">

			<table border="1" style="width: 80%" title="Student Details">
				<tr>
					<th><label>Select </label></th>
					<th><label>ID </label></th>
					<th><label>User name </label></th>
					<th><label>Password </label></th>
					<th><label>Name </label></th>
					<th><label>Mobile No </label></th>
					<th><label>Pin code</label></th>
					<th><label>Area Name </label></th>
					<th><label>City Name</label></th>
				</tr>
				<c:forEach items="${data}" var="stu">
					<tr align="center">
						<td><input type="radio" name="select" value="${stu.id}"></td>
						<td><c:out value="${stu.id}"></c:out></td>
						<td><c:out value="${stu.uname}"></c:out></td>
						<td><c:out value="${stu.pass}"></c:out></td>
						<td><c:out value="${stu.name}"></c:out></td>
						<td><c:out value="${stu.mobno}"></c:out></td>
						<td><c:out value="${stu.address.pincode}"></c:out></td>
						<td><c:out value="${stu.address.areaname}"></c:out></td>
						<td><c:out value="${stu.address.cityname}"></c:out></td>
					</tr>
				</c:forEach>

				<tr align="center">
					<td colspan="2" align="center">Click here to edit selected
						record <input type="button" id="btn" value="EDIT"
						onclick="editrecord()">
					</td>
					<td colspan="2" align="center">Click here to delete selected
						record <input type="button" id="btn" value="DELETE"
						onclick="deleterecord()">
					</td>
					<td colspan="2" align="center">Click here to add record <input
						type="button" id="btn" value="ADD" onclick="addrecord()">
					</td>
					<td colspan="3" align="center"><select name="sortvalue"
						id="btn" onchange="sortrecord()">
							<option id="btn">Select to Sort</option>
							<option value="1">Sort by ID Accending</option>
							<option value="2">Sort by ID Descending</option>
							<option value="3">sort by Name Accending</option>
							<option value="4">sort by Name Descending</option>
							<option value="5">sort by Pincode Accending</option>
							<option value="6">sort by Pincode Descending</option>
							<option value="7">sort by AreaName Accending</option>
							<option value="8">sort by AreaName Descending</option>
							<option value="9">sort by CityName Accending</option>
							<option value="10">sort by CityName Descending</option>
					</select></td>
				</tr>

			</table>
		</form>
	</div>
</body>

</html>