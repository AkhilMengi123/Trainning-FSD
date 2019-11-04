package com.ibm.training.beans;

public class RechargeApp {
	
	private long mobile_number;
	
	private String name;
	
	private  String password;
	
	private  int balance;
	
	private String type;
	
	public String transaction;

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public RechargeApp( long mobile_number, String name, String password)
	{
		this.mobile_number = mobile_number;
		this.name = name;
		this.password = password;
	}
	public RechargeApp(long mobile_number ,String name ,int balance)
	{
		this.mobile_number =  mobile_number;
		this.name= name;
		this.balance = balance;
	}
	public RechargeApp(long mobile_number, String name, int balance , String transaction)
	{
		this.mobile_number =  mobile_number;
		this.name = name;
		this.balance= balance;
		this.transaction = transaction;
	}
	
	

}
