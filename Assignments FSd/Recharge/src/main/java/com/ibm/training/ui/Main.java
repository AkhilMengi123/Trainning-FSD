package com.ibm.training.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ibm.training.beans.RechargeApp;
import com.ibm.training.service.RechargeServiceClass;
import com.ibm.training.service.RechargeServiceInterface;

public class Main {

	public static void main(String[] args) throws IOException {

		RechargeServiceInterface service = new RechargeServiceClass();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int option = 0;

		do {
			long mobile_no = 0L;
			String password = "";

			System.out.println("Kindly Decide ");
			System.out.println("1, New User");
			System.out.println("2, Existing User");
			System.out.println("3 , EXIT");
			System.out.println("Choose 1/2/3");

			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			switch (option) {
			case 1:
				String name = "";
				System.out.println("Enter your Mobile Number");
				try {
					mobile_no = Long.parseLong(br.readLine());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (service.isValidMobileNumber(mobile_no)) {
					System.out.println("Enter your Password");
					try {
						password = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("Enter your Name");
					try {
						name = br.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					RechargeApp user_account = new RechargeApp(mobile_no, password, name);

					if (service.createAccount(user_account)) {
						System.out.println("Account Created Successfully");
					} else {
						System.out.println("NOt cReated ");
					}

				} else {
					System.out.println("Invalid PhoneNumber");
				}
				break;

			case 2:

				do {
					
					System.out.println("Enter your  Mobile Number");
					mobile_no = Long.parseLong(br.readLine());
					System.out.println("Enter Your Password");
					password = br.readLine();
					if (service.passwordValidate(mobile_no, password)) {
						System.out.println("OOps! wrong password");

					}
				} while (service.passwordValidate(mobile_no, password));
				if (service.isAccontExist(mobile_no, password)) {
					int option2 = 0;
					do {
						int money = 0;
						
						System.out.println("Kindly Made A Choice");
						System.out.println("1, Show Balance");
						System.out.println("2, Recharge the AccountBalance");
						System.out.println("3,Transactions");
						System.out.println("CHOICE 1/2/3");

						option2 = Integer.parseInt(br.readLine());

						switch (option2) {
						case 1:
							System.out.println("Your Account balance is" + service.showBalance(mobile_no, password));
							break;
						case 2:
							System.out.println("Enter the amount you want to recharge");
							money = Integer.parseInt(br.readLine());
							System.out.println(service.depositMoney(mobile_no, password, money));
							

						}

					} while (option2 > 0 && option2 < 3);

				} else {
					System.out.println("Dono exist");
				}
				break;
				
			
				

			}

		} while (option > 0 && option < 3);
	}
}
