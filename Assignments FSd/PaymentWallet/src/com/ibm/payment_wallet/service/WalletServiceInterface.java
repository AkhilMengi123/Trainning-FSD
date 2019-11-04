package com.ibm.payment_wallet.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WalletServiceInterface {

	
	boolean createWallet(HttpServletRequest request,HttpServletResponse response);

	boolean isWalletExist(HttpServletRequest request,HttpServletResponse response);
	int showBalance(HttpServletRequest request,HttpServletResponse response);
	String depositMoney(HttpServletRequest request,HttpServletResponse response);
	String withdrawMoney(HttpServletRequest request,HttpServletResponse response);
	boolean passwordValidate(long mobile_no,String password);
	String transferMoney(long sender_mobile_no,String password,long receiver_mobile_no,int money);

	ArrayList<String> printAllTransaction(long mobile_no, String password);
	

}
