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


@WebServlet("/Deposit")
public class depositServlet extends HttpServlet {
       public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
       {
    	   double amount_to_deposit=0;
    	   
    	   //creating request dispatcher
    	   RequestDispatcher rd= req.getRequestDispatcher("Deposit.jsp");
    	   
    	   //checking for if the data is not numeric
    	   try
    	   {
    		   amount_to_deposit = Double.parseDouble(req.getParameter("amount"));
    	   }
    	   catch(Exception e)
    	   {
    		   req.setAttribute("DepositStatus","invalid");
    		   rd.forward(req, res);
    	   }
    	   
    	   DB db;
    	   HttpSession session = req.getSession();
    	   
    	   //if amount to deposit less than 0 (min Balance)
    	   if(amount_to_deposit < 0)
    	   {
    		   req.setAttribute("DepositStatus","failed");
    		   rd.forward(req,res);
    	   }
    	   
    	   //if amount greater than min balance
    	   else
    	   {
    		   db = new DB();
    		   try 
    		   {
    			   //entering the data into database
    			   String accountNumber =(String) session.getAttribute("AccountNumber");
    			   db.deposit(accountNumber,amount_to_deposit);
    		   } 
    		   catch (Exception e) 
    		   {
				System.out.println("Exception occured during deposit");
				e.printStackTrace();
    		   }
    		   
    		   req.setAttribute("DepositStatus","success");
    		   rd.forward(req, res);
    	   }
       }
}
