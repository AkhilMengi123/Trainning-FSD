package com.ibm.payment_wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ibm.payment_wallet.model.UserWalletAccount;

public class WalletDaoClass implements WalletDaoInterface {

	public static Connection con = null;

	public WalletDaoClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/axiz?serverTimezone=UTC", "root",
					"");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public boolean createWallet(UserWalletAccount user_wallet) {
		boolean result=false;
		try {
			

			PreparedStatement ps = con.prepareStatement(
					"insert into userwalletaccount(mobile_number,password,name) values(?,?,?)");
			ps.setLong(1, user_wallet.getMobile_number());
			ps.setString(2, user_wallet.getPassword());
			ps.setString(3, user_wallet.getName());
			
			if (ps.executeUpdate() > 0) {
				
				result=true;
			} else {
				
				result=false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public boolean checkWalletDatabase(long mobile_no, String password) {
		boolean result = false;
		try {

			PreparedStatement ps = con
					.prepareStatement("select * from userwalletaccount where mobile_number=? and password=?");
			ps.setLong(1, mobile_no);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public int showBalance(long mobile_no, String password) {
		
		int balance = 0;
		try {

			PreparedStatement ps = con
					.prepareStatement("select balance from userwalletaccount where mobile_number=? and password=?");
			ps.setLong(1, mobile_no);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				balance = rs.getInt("balance");
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return balance;
	}

	public String depositMoney(long mobile_no, String password, int money) {
			String transaction="";
		try {

			PreparedStatement ps = con.prepareStatement(
					"update userwalletaccount set balance=balance+? where mobile_number=? and password=?");
			ps.setInt(1, money);
			ps.setLong(2, mobile_no);
			ps.setString(3, password);

			if (ps.executeUpdate() > 0) {
				SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
				//SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");
				Date d=new Date();
				String date = simpleformat.format(d);
				//String time=timeFormat.format(d);
				transaction = money + " deposited in wallet on " + date;

				this.transactionRecord(mobile_no, transaction);
			
		
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return transaction;
	}

	public String withdrawMoney(long mobile_no, String password, int money) {
	
		String showWithdrawMsg="";
		try {

			PreparedStatement ps2 = con
					.prepareStatement("select balance from userwalletaccount where mobile_number=? and password=?");
			ps2.setLong(1, mobile_no);
			ps2.setString(2, password);
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				int balance_before = rs.getInt("balance");
				if ((balance_before > money) || (balance_before - money) > 0) {
					PreparedStatement ps = con.prepareStatement(
							"update userwalletaccount set balance=balance-? where mobile_number=? and password=?");
					ps.setInt(1, money);
					ps.setLong(2, mobile_no);
					ps.setString(3, password);

					if (ps.executeUpdate() > 0) {
						SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
						//SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");
						Date d=new Date();
						String date = simpleformat.format(d);
						//String time=timeFormat.format(d);
					
						String transaction = money + " withdrawn from wallet on " + date;
 
						this.transactionRecord(mobile_no, transaction);
						
						showWithdrawMsg=transaction;
					}
				} else {
					showWithdrawMsg="Cannot withdraw!!!";
					
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return showWithdrawMsg;
	}

	public void transactionRecord(long mobile_no, String record) {
		
		String sql = "";
		try {
			PreparedStatement ps1 = con
					.prepareStatement("select transactions from userwalletaccount where mobile_number=? ");
			ps1.setLong(1, mobile_no);

			ResultSet rs = ps1.executeQuery();
			String ck = "";
			if (rs.next()) {
				ck = rs.getString("transactions");
				
				if (ck.equals("No Data")) {
					sql = "update userwalletaccount set transactions=? where mobile_number=?";
				} else {
					sql = "update userwalletaccount set transactions=CONCAT(transactions,';',?) where mobile_number=?";
				}
			}

			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setString(1, record);
			ps2.setLong(2, mobile_no);
			int x =ps2.executeUpdate();
		} catch (Exception e) {

		}
	}

	public ArrayList<String> printAllTransaction(long mobile_no, String password) {
		ArrayList<String> transaction = new ArrayList<String>();
		try {
			PreparedStatement ps1 = con.prepareStatement(
					"select transactions from userwalletaccount where mobile_number=? and password=?");
			ps1.setLong(1, mobile_no);
			ps1.setString(2, password);
			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {
				String tran = rs.getString("transactions");
				String tran_arr[] = tran.split(";");
				
				for (String a : tran_arr) {
					
					transaction.add(a);
				}

			}

		} catch (Exception e) {

		}
		return transaction;
	
	}

	public boolean passwordValidate(long mobile_no, String password) {
		boolean result = false;
		try {

			PreparedStatement ps = con
					.prepareStatement("select * from userwalletaccount where mobile_number=? and (not password=?)");
			ps.setLong(1, mobile_no);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
				
			} else {
				result = false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public String transferMoney(long sender_mobile_no, String password, long receiver_mobile_no, int money) {
		String showTransferMsg="";
		try {
			PreparedStatement check_account = con
					.prepareStatement("select * from userwalletaccount where mobile_number=?");
			check_account.setLong(1, receiver_mobile_no);
			ResultSet result_acc=check_account.executeQuery();
			if(result_acc.next()) {

			PreparedStatement ps2 = con
					.prepareStatement("select balance from userwalletaccount where mobile_number=? and password=?");
			
			ps2.setLong(1, sender_mobile_no);
			ps2.setString(2, password);
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				int balance_before = rs.getInt("balance");
				if ((balance_before > money) || (balance_before - money) > 0) {
					PreparedStatement ps = con.prepareStatement(
							"update userwalletaccount set balance=balance-? where mobile_number=? and password=?");
					PreparedStatement receiver = con
							.prepareStatement("update userwalletaccount set balance=balance+? where mobile_number=?");
					ps.setInt(1, money);
					ps.setLong(2, sender_mobile_no);
					ps.setString(3, password);
					receiver.setInt(1, money);
					receiver.setLong(2, receiver_mobile_no);
					receiver.executeUpdate();
					if (ps.executeUpdate() > 0) {
						
						SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
						//SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");
						Date d=new Date();
						String date = simpleformat.format(d);
						//String time=timeFormat.format(d);
						String transaction_sender = money + " transferred to wallet " + receiver_mobile_no + " on "
								+ date;
						String transaction_receiver = money + " deposited in wallet from " + sender_mobile_no + " on "
								+ date;

						this.transactionRecord(sender_mobile_no, transaction_sender);
						this.transactionRecord(receiver_mobile_no, transaction_receiver);
						
						showTransferMsg=transaction_sender;
					}
				} else {
					
					showTransferMsg="Cannot Transfer";
				}
			}
			}else {
				showTransferMsg="Receiver account does not exist!!";
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return showTransferMsg;
	}
}
