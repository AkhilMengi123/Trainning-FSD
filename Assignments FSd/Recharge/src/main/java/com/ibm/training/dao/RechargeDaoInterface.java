package com.ibm.training.dao;

import com.ibm.training.beans.RechargeApp;

public interface RechargeDaoInterface {
	
	
	boolean createAccount(RechargeApp user_account);
	
	
	boolean checkAccountDatabase( long  mobile_no, String password);
	
	 int showbalance(long mobile_no ,  String password);
	 
	 boolean passwordValidate(long mobile_no, String password);
	 
	 String depositMoney(long mobile_no, String password, int money);

}
