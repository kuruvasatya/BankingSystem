<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<div class="container">
		<div class="ml-5">
 		<%
		out.println("<h3 class=\"display-3 \" >Thank You " + request.getAttribute("userName")+"</h3>");
		out.println("<br><h3>Your Account is successfully created </h3>");
		out.print("<br><h3>Your Account Number is " + request.getAttribute("accountNumber") +"</h3");
		%>
		<br>
		<br>
		<a class="btn btn-info" href="login.jsp" role="button">Login</a>
		</div>
	</div>
</body>
</html>