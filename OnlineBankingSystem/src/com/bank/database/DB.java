package com.bank.database;
import java.sql.*;

public class DB {
	Connection con;
	String url = "jdbc:mysql://localhost:3306/bank";
	String uid="root";
	String pass="";
	PreparedStatement stmnt;
	
	//constructor to make database connections
	public DB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			System.out.println("please connect to mysql data base");
			e.printStackTrace();
		}
	}
	
	//Checking if user is valid 
	public String isUserRegistered(String username, String password) throws SQLException
	{
		String SQL = "select Name,Password,AccountNumber from customers where Name = ? and Password = ?";
		stmnt = con.prepareStatement(SQL);
		stmnt.setString(1, username);
		stmnt.setString(2,password);
		ResultSet rs = stmnt.executeQuery();
		if(rs.next())
		{
			return (String)rs.getString(3);
		}
		return "false";
	}
	
	public Boolean makeEntry(String userName, String password, String accountNumber, double Balance) throws SQLException
	{
		String SQL ="select * from customers where AccountNumber=?";
		stmnt = con.prepareStatement(SQL);
		stmnt.setString(1,accountNumber);
		ResultSet rs = stmnt.executeQuery();
		if(rs.next())
		{
			return false;
		}
		else
		{
			SQL = "insert into customers(AccountNumber,Name,Password,Balance)"
					+ "values(?,?,?,?)";
			stmnt = con.prepareStatement(SQL);
			stmnt.setString(1,accountNumber);
			stmnt.setString(2,userName);
			stmnt.setString(3, password);
			stmnt.setDouble(4,Balance);
			stmnt.executeUpdate();
			return true;
		}
	}

	public void deposit(String accountNumber, double amount) throws SQLException {
		double prev_balance = currentBalance(accountNumber);
		double current_balance = prev_balance + amount;
		String SQL = "update customers set Balance=? where AccountNumber = ?";
		stmnt = con.prepareStatement(SQL);
		stmnt.setDouble(1, current_balance);
		stmnt.setString(2, accountNumber);
		stmnt.executeUpdate();
	}
	
	public double currentBalance(String accountNumber) throws SQLException
	{
		String SQL = "select Balance from customers where AccountNumber=?";
		stmnt = con.prepareStatement(SQL);
		stmnt.setString(1, accountNumber);
		ResultSet rs = stmnt.executeQuery();
		rs.next();
		return rs.getDouble(1);
	}

	public void withdraw(String accountNumber, double newBalance) throws SQLException {
		String SQL = "update customers set Balance = ? where AccountNumber=?";
		stmnt = con.prepareStatement(SQL);
		stmnt.setDouble(1,newBalance);
		stmnt.setString(2,accountNumber);
		stmnt.executeUpdate();
	}
	
	public boolean isThereAccount(String accountNumber) throws SQLException
	{
		String SQL = "select * from customers where AccountNumber=?";
		stmnt = con.prepareStatement(SQL);
		stmnt.setString(1,accountNumber);
		ResultSet rs = stmnt.executeQuery();
		if(rs.next())
			return true;
		return false;
	}
	
}
