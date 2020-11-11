package com.revature;

import java.util.Scanner;

import com.revature.Model.Account;
import com.revature.Model.User;
import com.revature.Service.AccountService;

public class EditAccount {

	Scanner scan = new Scanner(System.in);
	AccountService serv = new AccountService();
	Account a;
	int accountid;
	double balance;
	String type;
	String status;
	boolean check;

	public EditAccount(User u, String id) {

		if (u.getType().equals("Admin")) {

			accountid = Integer.parseInt(id);
			a = serv.getAccountByID(accountid);
			if(a==null) {
				new SeeAllAccounts(u);
			}
			System.out.println("Here is account edit");

			System.out.println("Type 0 if you do not want to change.");
			System.out.println("Current balance is " + a.getBalance());
			balance = Double.parseDouble(scan.nextLine());
			if (balance==0) {
				balance = a.getBalance();
			}
			while (true) {
				System.out.println("Current type is " + a.getType());
				System.out.println("Plase type in the number.");
				System.out.println("1 = Checking");
				System.out.println("2 = Saving");
				type = scan.nextLine();
				if (type.equals("0")) {
					type = a.getType();
					break;
				} else if (type.equals("1")) {
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
				System.out.println("Current status is " + a.getStatus());
				System.out.println("Plase type in the number.");
				System.out.println("1 = Open");
				System.out.println("2 = Closed");
				status = scan.nextLine();
				if (status.equals("0")) {
					status = a.getStatus();
					break;
				} else if (status.equals("1")) {
					status = "Open";
					break;
				} else if (status.equals("2")) {
					status = "Closed";
					break;
				} else {
					continue;
				}

			}

			check = serv.updateAccountByID(accountid, balance, status, type);

			if (check) {
				System.out.println("Update Successful");
				new SeeAllAccounts(u);
			} else {
				System.out.println("Update Failed");
				new SeeAllAccounts(u);
			}

		} else {
			
			accountid = Integer.parseInt(id);
			a = serv.getAccountByID(accountid);
			if(a==null) {
				new SeeAllAccounts(u);
			}
			System.out.println("Here is account edit Open/Close");
			
			balance = a.getBalance();
			type = a.getType();
			
			while (true) {
				System.out.println("Current status is " + a.getStatus());
				System.out.println("Plase type in the number.");
				System.out.println("1 = Open");
				System.out.println("2 = Closed");
				status = scan.nextLine();
				if (status.equals("0")) {
					status = a.getStatus();
					break;
				} else if (status.equals("1")) {
					status = "Open";
					break;
				} else if (status.equals("2")) {
					status = "Closed";
					break;
				} else {
					continue;
				}

			}
			
			check = serv.updateAccountByID(accountid, balance, status, type);

			if (check) {
				System.out.println("Open/Close Successful");
				new SeeAllAccounts(u);
			} else {
				System.out.println("Open/Close Failed");
				new SeeAllAccounts(u);
			}
			
		}

	}
}
