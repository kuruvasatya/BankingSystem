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
@WebServlet("/balanceEnquiry")

public class BalanceEnquiryServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		DB db = new DB();
		HttpSession session = req.getSession();
		String accountNumber = (String) session.getAttribute("AccountNumber");
		try {
			double balance = db.currentBalance(accountNumber);
			RequestDispatcher rd = 	req.getRequestDispatcher("BalanceEnquiry.jsp");
			req.setAttribute("balance", balance);
			req.setAttribute("BalanceEnquiryStatus", "success");
			rd.forward(req, res);
		} 
		catch (SQLException e) {
			System.out.println("failed to fetch the data from the db");
		}
	}
}
