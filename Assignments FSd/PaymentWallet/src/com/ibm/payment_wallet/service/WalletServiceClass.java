package com.ibm.payment_wallet.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.payment_wallet.dao.WalletDaoClass;
import com.ibm.payment_wallet.dao.WalletDaoInterface;
import com.ibm.payment_wallet.model.UserWalletAccount;

public class WalletServiceClass implements WalletServiceInterface {
	WalletDaoInterface dao = new WalletDaoClass();
	UserWalletAccount user_wallet;

	/*public boolean isValidMobileNumber(long mobile_no) {
		// TODO Auto-generated method stub
		String pattern = "[7-9]{1}[0-9]{9}";
		return (Pattern.matches(pattern, String.valueOf(mobile_no)));

	}

	public boolean isPasswordMatch(String password, String conf_pass) {

		return (password.equals(conf_pass));
	}
*/
	public boolean createWallet(HttpServletRequest request,HttpServletResponse response) {
		long mobile_no=Long.parseLong(request.getParameter("mobile_no"));
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		
		user_wallet=new UserWalletAccount(mobile_no,password);
		
		return dao.createWallet(user_wallet);

	}

	public boolean isWalletExist(HttpServletRequest request,HttpServletResponse response) {
		long mobile_no=Long.parseLong(request.getParameter("mobile_no"));
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("mobile_no",mobile_no);
		session.setAttribute("password",password);
		return dao.checkWalletDatabase(mobile_no, password);
	}

	public int showBalance(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		long mobile_no=(Long)session.getAttribute("mobile_no");
		String password=(String)session.getAttribute("password");

		return dao.showBalance(mobile_no, password);
	}

	public String depositMoney(HttpServletRequest request,HttpServletResponse response) {
		long mobile_no=(Long)request.getSession().getAttribute("mobile_no");
		String password=(String)request.getSession().getAttribute("password");
		int money=Integer.parseInt(request.getParameter("amount"));
		return dao.depositMoney(mobile_no, password, money);
	}

	public String withdrawMoney(HttpServletRequest request,HttpServletResponse response) {
		long mobile_no=(Long)request.getSession().getAttribute("mobile_no");
		String password=(String)request.getSession().getAttribute("password");
		int money=Integer.parseInt(request.getParameter("amount"));

		return dao.withdrawMoney(mobile_no, password, money);

	}

	public ArrayList<String> printAllTransaction(long mobile_no, String password) {

		 return dao.printAllTransaction(mobile_no, password);
	}

	public boolean passwordValidate(long mobile_no, String password) {

		return dao.passwordValidate(mobile_no, password);
	}

	public String transferMoney(long sender_mobile_no, String password, long receiver_mobile_no, int money) {
		return dao.transferMoney(sender_mobile_no, password, receiver_mobile_no, money);

	}
}
