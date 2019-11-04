package com.ibm.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.training.beans.RechargeApp;

public class RechargeDaoClass implements RechargeDaoInterface {

	public static Connection con = null;

	public RechargeDaoClass() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcd?serverTimezone=UTC", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean createAccount(RechargeApp user_account) {
		boolean result = false;

		try {
			PreparedStatement ps = con
					.prepareStatement("insert into recharge(mobile_number,name,password) values(?,?,?)");

			ps.setLong(1, user_account.getMobile_number());
			ps.setString(2, user_account.getName());
			ps.setString(3, user_account.getPassword());

			if (ps.executeUpdate() > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public boolean checkAccountDatabase(long mobile_no, String password) {
		boolean result = false;

		try {
			PreparedStatement ps = con.prepareStatement("select * from recharge where mobile_number=? and password=?");

			ps.setLong(1, mobile_no);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			} else {
				result = false;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		}
	public int showbalance(long mobile_no ,  String password)
	{
		int balance = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement
					("select balance from recharge where mobile_number=? and password=?");
			ps.setLong(1,mobile_no);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				balance = rs.getInt("balance");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}
	 public boolean passwordValidate(long mobile_no, String password)
	 {
		  boolean result = false;
		  
		 try {
			PreparedStatement ps = con.prepareStatement
					 ("select * from recharge where mobile_number=? and (not Password=?)");
			
			ps.setLong(1,mobile_no);
			ps.setString(2,password);
			ResultSet rs  = ps.executeQuery();
			
			if(rs.next())
			{
				result= true;
			}
			else
			{
				result= false;
				
			}
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		 
		}
	 public String depositMoney(long mobile_no, String password, int money)
	 
	 {
		 String showAfterDeposit="";
		 
		 PreparedStatement ps;
		try {
			ps = con.prepareStatement
					 ("update recharge set balance= balance +? where mobile_number=? and password=?");
			ps.setInt(1,money);
			 ps.setLong(2, mobile_no);
			 ps.setString(3, password);
			 
			 if(ps.executeUpdate() >0)
			 {
				 showAfterDeposit = "the balance in your account is" +this.showbalance(mobile_no, password);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showAfterDeposit;
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
