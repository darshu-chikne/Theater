<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% double totalAmount=(Double)request.getAttribute("TotalBill");


%>
 
<h1>Total Bill is<%= totalAmount%> </h1>
 
</html>