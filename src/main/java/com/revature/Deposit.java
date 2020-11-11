package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.Model.Account;
import com.revature.Model.User;
import com.revature.Service.AccountService;

public class Deposit {

	private static Logger log = Logger.getLogger(Deposit.class);
	AccountService serv = new AccountService();
	Scanner scan = new Scanner(System.in);
	Account a;
	int accountid;
	double deposit;
	boolean check;

	public Deposit(User u, String id) {
		accountid = Integer.parseInt(id);
		a = serv.getAccountByID(accountid);
		if(a==null) {
			new SeeAllAccounts(u);
		}
		System.out.println("How much do you wish to Deposit?");
		deposit = Double.parseDouble(scan.nextLine());
		check = serv.Deposit(a, deposit);
		if (check) {
			log.info("Deposited: " + deposit);
		}
		new SeeAllAccounts(u);
	}

	public Deposit(User u, String id, int id2) {
		accountid = Integer.parseInt(id);
		a = serv.getAccountByID(accountid);
		if(a==null) {
			new SeeAllAccounts(u);
		}
		System.out.println("How much do you wish to Deposit?");
		deposit = Double.parseDouble(scan.nextLine());
		check = serv.DepositCustomer(a, deposit, id2);
		if (check) {
			log.info("Deposited: " + deposit);
		}
		new SeeAllAccounts(u);
	}

}
