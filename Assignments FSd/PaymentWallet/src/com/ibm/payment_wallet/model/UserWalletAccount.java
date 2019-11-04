package com.ibm.payment_wallet.model;

public class UserWalletAccount {
	private long mobile_number;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String name;
	private int balance;
	private String transaction;

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

	public UserWalletAccount(long mobile_number, String password, String name) {
		this.mobile_number = mobile_number;
		this.name = name;

		this.password = password;
	}

	public UserWalletAccount(long mobile_number, String name,  int balance,
			String transaction) {
		this.mobile_number = mobile_number;
		this.name = name;
		
		this.balance = balance;
		this.transaction = transaction;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public UserWalletAccount() {
		// TODO Auto-generated constructor stub
	}

}
