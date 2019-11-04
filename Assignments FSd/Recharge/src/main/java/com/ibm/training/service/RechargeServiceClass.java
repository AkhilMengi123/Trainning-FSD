package com.ibm.training.service;

import java.util.regex.Pattern;

import com.ibm.training.beans.RechargeApp;
import com.ibm.training.dao.RechargeDaoClass;
import com.ibm.training.dao.RechargeDaoInterface;

public class RechargeServiceClass implements RechargeServiceInterface {
	RechargeDaoInterface dao = new RechargeDaoClass();

	public boolean isValidMobileNumber(long mobile_no) {
		String pattern = "[7-9]{1}[0-9]{9}";
		return (Pattern.matches(pattern, String.valueOf(mobile_no)));

	}

	public boolean createAccount(RechargeApp user_account) {
		return dao.createAccount(user_account);

	}
	
	public boolean isAccontExist(long mobile_no, String password)
	{
		return dao.checkAccountDatabase(mobile_no, password);
	}
	
	public int showBalance(long mobile_no, String password)
	{
		return dao.showbalance(mobile_no, password);
	}

	public boolean passwordValidate(long mobile_no, String password) {
		// TODO Auto-generated method stub
		return dao.passwordValidate(mobile_no, password);
	}
	 public String depositMoney(long mobile_no, String password, int money) {
		return dao.depositMoney(mobile_no, password, money);
		 
		 
	 }

}
