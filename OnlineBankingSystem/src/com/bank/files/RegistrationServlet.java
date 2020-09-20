package com.bank.files;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.database.DB;

@WebServlet("/addEntry")
public class RegistrationServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userName = request.getParameter("username");
		String pass1 = request.getParameter("password1");
		String pass2 = request.getParameter("password2");
		if(!(pass1.equals(pass2)))
		{
			request.setAttribute("flag","true");
			RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("flag","false");
			DB db = new DB();
			String accountNumber;
			while(true)
			{
			 accountNumber = AccountNumberGenerator.generateAccountNumber();
			 try 
			 	{
				 	if(db.makeEntry(userName, pass1, accountNumber, 0))
				 	{
				 		request.setAttribute("userName",userName);
				 		request.setAttribute("accountNumber",accountNumber);
				 		RequestDispatcher rd = request.getRequestDispatcher("AccountSuccess.jsp"); 
				 		rd.forward(request, response);
				 		break;
				 	}
				 	
			 	} 
			 catch (SQLException e) 
			 	{	
				 	e.printStackTrace();
			 	}
			}
			
		}
	}
}
