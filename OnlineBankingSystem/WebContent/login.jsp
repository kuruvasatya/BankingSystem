<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Banking</title>
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<!-- user entered content-->
	
	<div class="login-page">
 		 <div class="form">
 		 	 <!-- Dynamic content (verifying credentials)-->
 		 	 <% 
 		 		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
 	       	 	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
 	        	response.setDateHeader("Expires", 0);
 		 	 try
 		 	 {
 		 	 if(request.getAttribute("error").equals("true"))
				{
 		 		 out.println("<h5 style=\"color:red; marin-bottom:4px; margin-top:0px;\">*Wrong Credentials</h5>");
				}
 		 	 }
 		 	 catch(Exception e)
 		 	 {
 		 		 
 		 	 }
			%>
 		 	<!-- creating the form -->
   			  <form  action="HomePage" method ="post">
      			<input autocomplete="false" type="text" placeholder="Enter User Name" name = "username"/>
     			 <input autocomplete="false" type="password" placeholder="password" name = "password" />
     			 <button>login</button>
      			<p class="message">Not registered? <a href="signin.jsp">Create an account</a></p>
  			  </form>
  		</div>
	</div>
</body>
</html>