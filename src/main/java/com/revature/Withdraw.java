package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.Model.Account;
import com.revature.Model.User;
import com.revature.Service.AccountService;

public class Withdraw {
	
	private static Logger log = Logger.getLogger(Withdraw.class);
	AccountService serv = new AccountService();
	Scanner scan = new Scanner(System.in);
	Account a;
	int accountid;
	double withdraw;
	boolean check;
	
	public Withdraw(User u, String id) {
		accountid = Integer.parseInt(id);
		a = serv.getAccountByID(accountid);
		if(a==null) {
			new SeeAllAccounts(u);
		}
		System.out.println("How much do you wish to withdraw?");
		withdraw = Double.parseDouble(scan.nextLine());
		check = serv.Withdraw(a, withdraw);
		if(check) {
			log.info("Withdrawn: " + withdraw);
		}
		new SeeAllAccounts(u);
	}
	
	public Withdraw(User u, String id, int id2) {
		accountid = Integer.parseInt(id);
		a = serv.getAccountByID(accountid);
		if(a==null) {
			new SeeAllAccounts(u);
		}
		System.out.println("How much do you wish to withdraw?");
		withdraw = Double.parseDouble(scan.nextLine());
		check = serv.WithdrawCustomer(a, withdraw, id2);
		if(check) {
			log.info("Withdrawn: " + withdraw);
		}
		new SeeAllAccounts(u);
	}
}
