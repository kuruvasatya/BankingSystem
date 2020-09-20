package com.bank.files;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.database.DB;

@WebServlet("/WithDraw")
public class WithdrawServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		//creating request dispatcher 
		RequestDispatcher rd = req.getRequestDispatcher("Withdraw.jsp");
		
		//creating instance of the database
		DB db = new DB();
		
		//using session to get the account number
		HttpSession session = req.getSession();
		
		//fetching the account number
		String accountNumber = (String) session.getAttribute("AccountNumber");
		
		//fetching the current balance from the database
		double current_balance = 0;
		
		//fetching the amount that is present in the data base
		try 
		{ 
			current_balance = db.currentBalance(accountNumber);
		} 
		catch (SQLException e) 
		{
			System.out.println("error occured while fetching the data from the database");
			e.printStackTrace();
		} 
		
		//fetching the amount that need to be withdrawn and checking its type
		double withdrawBalance = 0;
		try 
		{
			 withdrawBalance = Double.parseDouble(req.getParameter("amount"));
		}
		catch(Exception e)
		{
			req.setAttribute("wdStatus", "invalid");
			rd.forward(req, res);
		}
		
		//if withdraw balance is negative
		if(withdrawBalance <=0)
		{
			req.setAttribute("wdStatus", "incorrect");
			rd.forward(req, res);
		}
		//if there is no sufficient funds
		else if(withdrawBalance > current_balance)
		{
			req.setAttribute("wdStatus", "insufficient");
			rd.forward(req, res);
		}
		//if every thing is correct
		else
		{
			// finding the new balance
			double newBalance = current_balance - withdrawBalance;
			//withdrawing money
			try {
				db.withdraw(accountNumber,newBalance);
				req.setAttribute("wdStatus", "success");
				rd.forward(req, res);
			} catch (SQLException e) {
				System.out.println("failed while updating data");
				e.printStackTrace();
			}
		}
	}
}
