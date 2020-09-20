<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="login.css">
<title>Online Banking</title>
</head>
<body>
	<div class="login-page">
 		 <div class="form">
   			 <form class="login-form" autocomplete="off" action="addEntry">
   			  <!--  Dynamic Content -->
   			  <% 
   			  try{
 		 	 	if(request.getAttribute("flag").equals("true"))
				{
 		 		 out.println("<h5 style=\"color:red; marin-bottom:4px; margin-top:0px;\"> *passwod did not match</h5>");
				}
   			  }
   			  catch(Exception e){}
				%>
   			 
      			 <input autocomplete="false" type="text" placeholder="Enter Your Name"/ name="username">
     			 <input autocomplete="false" type ="password" placeholder="Create a Password" name="password1"/>
     			 <input autocomplete="false" type ="password" placeholder="Re-enter Your Password" name="password2"/>
     			 <button>Create Account</button>
      			<p class="message">Already registered? <a href="login.jsp">Login into your account</a></p>
  			  </form>
  		</div>
	</div>
</body>
</html>