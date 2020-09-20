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

@WebServlet("/transfer")
public class transferServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException
	{
		//creating session to fecth session details
		HttpSession session= req.getSession();
		
		//fetching account numbers
		String accountNumber = (String) session.getAttribute("AccountNumber");
		String toAccountNumber = req.getParameter("toaccountNumber");
		
		//creating request dispatcher
		RequestDispatcher rd = req.getRequestDispatcher("Transfer.jsp");
		
		//Instatiating data base
		DB db = new DB();
		
		try {
			//checking if there is account to be transfered
			if(db.isThereAccount(toAccountNumber)) 
			{
				//fetching corresponding persons balance
				double from_account_bal = db.currentBalance(accountNumber);
				double to_account_bal = db.currentBalance(toAccountNumber);
			
				//fetching amount to transfer and checking its type
				double amount_to_transfer=0;
				try 
				{
					amount_to_transfer= Double.parseDouble(req.getParameter("amount"));
				}
				catch(Exception e)
				{
					req.setAttribute("tranStatus","invalid");
				}
				
				//if amount to transfer is negative
				if(amount_to_transfer <= 0)
				{
					req.setAttribute("tranStatus", "incorrect");
				}
				//if amount to transfer is greater than persons balance
				else if(amount_to_transfer > from_account_bal)
				{
				req.setAttribute("tranStatus","insufficient");
				}
				else
				{
					double newBalance = from_account_bal - amount_to_transfer;
					db.withdraw(accountNumber, newBalance);
					db.deposit(toAccountNumber, amount_to_transfer);
					req.setAttribute("tranStatus", "success");
				}
				rd.forward(req, res);
			}
			else
			{
				req.setAttribute("tranStatus", "noAccount");
				rd.forward(req, res);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
