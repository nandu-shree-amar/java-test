<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Events Page</title>
</head>
<body>
<h1>All Events Details</h1>
	
	<% ResultSet rs=(ResultSet)request.getAttribute("rs");
	%>
	<table border=2px rules=all cellpadding='8px'>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Location</th>
			<th>Date</th>
			<th>Guest</th>
			<th colspan="2">Action</th>
		</tr>
	<%
	while(rs.next()){
	%>
	<tr>
		<td><%=rs.getInt(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(4)%></td>
		<td><%=rs.getString(5)%></td>
		<td><a href="delete?id=<%=rs.getInt(1)%>"><button>Delete</button></a></td>
		<td><a href="updateevent?id=<%=rs.getInt(1)%>"><button>Update</button></a></td>	
	</tr>
	<%} %>
	</table>

</body>
</html>