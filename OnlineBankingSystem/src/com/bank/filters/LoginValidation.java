package com.bank.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.database.DB;

@WebFilter("/HomePage")
public class LoginValidation implements Filter {

    
    public LoginValidation() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//type cast request to Http servlet request
		HttpServletRequest req  = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//getting the parameters from the form
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		//starting data base
		DB db = new DB();
		String accountNumber;
		
		//fetching data from data base
		try {
			accountNumber = db.isUserRegistered(user,pass);
		} catch (SQLException e1) {
			accountNumber = "false";
			e1.printStackTrace();
		}
		
		try {
			//when credentials are wrong redirect to login page
			if(accountNumber.equals("false"))
			{
				// indicating that there is an error occured
				req.setAttribute("error","true");
				String url = "login.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			//when credential are correct
			else
			{
				//creating a session for the user
				HttpSession session = req.getSession();
				session.setAttribute("Name", user);
				session.setAttribute("AccountNumber",accountNumber);
				
				req.setAttribute("error","false");
				chain.doFilter(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
