package com.ibm.payment_wallet.dao;

import java.util.ArrayList;

import com.ibm.payment_wallet.model.UserWalletAccount;

public interface WalletDaoInterface {

	boolean createWallet(UserWalletAccount user_wallet);

	boolean checkWalletDatabase(long mobile_no, String password);
	
	int showBalance(long mobile_no, String password);
	String depositMoney(long mobile_no, String password,int money);
	String withdrawMoney(long mobile_no, String password,int money);
	void transactionRecord(long mobile_no, String record);
	ArrayList<String> printAllTransaction(long mobile_no, String password);
	boolean passwordValidate(long mobile_no,String password);
	String transferMoney(long sender_mobile_no,String password,long receiver_mobile_no,int money);

}
