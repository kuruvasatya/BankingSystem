<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="bgImage.css" type="text/css">
    <title>Online Banking</title>
  </head>
  <body>
   <%
   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
   response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   response.setDateHeader("Expires", 0);
  	if(session.getAttribute("Name")==null)
  	{
  		response.sendRedirect("login.jsp");
  	}
  		
  %>
  <!--  NavBar Design -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="#">E-Bank</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav mx-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Deposit.jsp">Deposit</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Withdraw.jsp">WithDraw</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Transfer.jsp">Transfer</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="BalanceEnquiry.jsp">Balance Enquiry</a>
      </li>
      <li class="nav-item ml-auto">
        	<a class="nav-link" href="Logout">Logout</a>
      </li>
    </ul>
    </div>
  </nav>
  
 <div class="jumbotron jumbotron-fluid big-banner" >
  <div class="container">
    <h1  class="display-4"style="font-size:5vw;">Welcome</h1>
   	<% out.println("<h1 style=\"font-size:6vw;\">"+ session.getAttribute("Name")+"</h1>"); 
      out.println("<h1 style=\"font-size:2vw;\"> Account No : "+ session.getAttribute("AccountNumber")+"</h1>");
      %>
  </div>
</div>
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="../Bootstrap/bootstrap.min.js"></script>
  </body>
</html>
