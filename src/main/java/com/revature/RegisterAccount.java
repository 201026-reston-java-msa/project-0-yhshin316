package com.revature;

import java.util.Scanner;

import com.revature.Model.User;
import com.revature.Service.AccountService;

public class RegisterAccount {
	
	Scanner scan = new Scanner(System.in);
	AccountService serv = new AccountService();
	String type;
	String status;
	double balance;
	int userid;
	boolean check;

	public RegisterAccount(User u) {
		if(u.getType().equals("Admin")) {
			
			balance = 0;
			System.out.println("Please type in the user id for the account");
			userid = Integer.parseInt(scan.nextLine());
			
			while (true) {
				System.out.println("Please choose a type");
				System.out.println("Plase type in the number.");
				System.out.println("1 = Checking");
				System.out.println("2 = Saving");
				type = scan.nextLine();
				if (type.equals("1")) {
					type = "Checking";
					break;
				} else if (type.equals("2")) {
					type = "Saving";
					break;
				} else {
					continue;
				}
			}
			while (true) {
				System.out.println("Please choose a status");
				System.out.println("Plase type in the number.");
				System.out.println("1 = Open");
				System.out.println("2 = Closed");
				status = scan.nextLine();
				if (status.equals("1")) {
					status = "Open";
					break;
				} else if (status.equals("2")) {
					status = "Closed";
					break;
				} else {
					continue;
				}

			}

			check = serv.createAccount(balance, status, type, userid);
			if(check) {
				System.out.println("Account Creation Success");
				new SeeAllAccounts(u);
			}else {
				System.out.println("Account Creation Failed");
				new SeeAllAccounts(u);
			}
			
		}else if(u.getType().equals("Customer")) {
			balance =0;
			userid = u.getId();
			status = "Open";
			while (true) {
				System.out.println("Please choose a type");
				System.out.println("Plase type in the number.");
				System.out.println("1 = Checking");
				System.out.println("2 = Saving");
				type = scan.nextLine();
				if (type.equals("1")) {
					type = "Checking";
					break;
				} else if (type.equals("2")) {
					type = "Saving";
					break;
				} else {
					continue;
				}
			}
			
			check = serv.createAccount(balance, status, type, userid);
			if(check) {
				System.out.println("Account Creation Success");
				new SeeAllAccounts(u);
			}else {
				System.out.println("Account Creation Failed");
				new SeeAllAccounts(u);
			}
			
		}
	}

}
