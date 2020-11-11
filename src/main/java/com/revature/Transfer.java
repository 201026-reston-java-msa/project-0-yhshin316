package com.revature;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.Model.Account;
import com.revature.Model.User;
import com.revature.Service.AccountService;

public class Transfer {
	
	private static Logger log = Logger.getLogger(Transfer.class);
	
	AccountService serv = new AccountService();
	Scanner scan = new Scanner(System.in);
	Account a;
	Account a2;
	int accountid;
	int accountid2;
	double withdraw;
	double deposit;
	boolean check;
	
	public Transfer(User u, String id, String id2) {
		accountid = Integer.parseInt(id);
		a = serv.getAccountByID(accountid);
		
		accountid2 = Integer.parseInt(id2);
		a2 = serv.getAccountByID(accountid2);
		
		if(a==null||a2==null) {
			System.out.println("There is a problem with id input");
			new SeeAllAccounts(u);
		}
		
		System.out.println("How much do you wish to Transfer?");
		withdraw = Double.parseDouble(scan.nextLine());
		deposit = withdraw;
		check = serv.Withdraw(a, withdraw);
		if (check) {
			serv.Deposit(a2, deposit);
			log.info("Transfered: " + withdraw + " from accountID: " + id + " to accountID: " + id2 );
		}
		new SeeAllAccounts(u);
	}
	
	public Transfer(User u, String id, String id2, int id3) {
		accountid = Integer.parseInt(id);
		a = serv.getAccountByID(accountid);
		
		accountid2 = Integer.parseInt(id2);
		a2 = serv.getAccountByID(accountid2);
		
		if(a2.getId()==0) {
			System.out.println("The account does not exist.");
			new SeeAllAccounts(u);
		}
		
		System.out.println("How much do you wish to Transfer?");
		withdraw = Double.parseDouble(scan.nextLine());
		deposit = withdraw;
		if(serv.WithdrawCustomer(a, withdraw, id3)) {
			
			serv.Deposit(a2, deposit);			
		}
		new SeeAllAccounts(u);
	}

}
