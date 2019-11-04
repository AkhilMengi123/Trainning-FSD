package com.ibm.training.service;

import com.ibm.training.beans.RechargeApp;

public interface RechargeServiceInterface {

	boolean isValidMobileNumber(long mobile_number);

	public boolean createAccount(RechargeApp user_account);
	
	boolean isAccontExist(long mobile_no, String password);
	
	int showBalance(long mobile_no, String password);

	boolean passwordValidate(long mobile_no, String password);
	
	String depositMoney(long mobile_no, String password, int money);

}
