package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.Model.Account;
import com.revature.Model.User;
import com.revature.Service.AccountService;

public class SeeAllAccounts {

	Scanner scan = new Scanner(System.in);
	AccountService serv = new AccountService();

	public SeeAllAccounts(User u) {
		if(u.getType().equals("Admin")||u.getType().equals("Employee")) {
			
			System.out.println("Here are all the accounts");
			List<Account> accounts = serv.getAllAccounts();
			for (Account a : accounts) {
				System.out.println(a);
			}
			
			if (u.getType().equals("Admin")) {
				
				System.out.println("1 = Withdraw");
				System.out.println("2 = Deposit");
				System.out.println("3 = Transfer");
				System.out.println("4 = Edit");
				System.out.println("5 = Create Account");
				
				System.out.println("Any = Back to menu");
				
				String b = scan.nextLine();
				
				if (b.equals("1")) {
					System.out.println("Please type in the accound ID of the one you wish to withdraw from.");
					String id = scan.nextLine();
					new Withdraw(u, id);
				} else if(b.equals("2")) {
					System.out.println("Please type in the accound ID of the one you wish to deposit to.");
					String id = scan.nextLine();
					new Deposit(u, id);
				} else if(b.equals("3")) {
					System.out.println("Please type in the accound ID of the one you wish to transfer from.");
					String id = scan.nextLine();
					System.out.println("Please type in the accound ID of the one you wish to transfer to.");
					String id2 = scan.nextLine();
					Account a = serv.getAccountByID(Integer.parseInt(id2));
					new Transfer(u,id,id2);
				} else if (b.equals("4")) {
					System.out.println("Please type in the accound ID of the one you wish to edit.");
					String id = scan.nextLine();
					new EditAccount(u, id);
				} else if (b.equals("5")) {
					System.out.println("Creating Account");
					new RegisterAccount(u);
				} else {
					new Menu(u);
				}
			} else{
				
				System.out.println("Any = Back to menu");
				System.out.println("1 = Open/Close Account");
				String c = scan.nextLine();
				if(c.equals("1")) {
					System.out.println("Please type in the id of the one you wish to edit");
					String id3 = scan.nextLine();
					new EditAccount(u, id3);
				}else {
					new Menu(u);					
				}
			}
			
		}
		//customer specific account list
		else {
			System.out.println("Here are all the accounts that belongs to the customer");
			List<Account> accounts = serv.getAllAccountsByUserID(u);
			for (Account a : accounts) {
				System.out.println(a);
			}
			System.out.println("1 = Withdraw");
			System.out.println("2 = Deposit");
			System.out.println("3 = Transfer");
			System.out.println("4 = Create Account");
			System.out.println("Any = Back to menu");
			
			String b = scan.nextLine();
			
			if (b.equals("1")) {
				System.out.println("Please type in the accound ID of the one you wish to withdraw from.");
				String id = scan.nextLine();
				int id2 = u.getId();
				new Withdraw(u, id, id2);
			} else if(b.equals("2")) {
				System.out.println("Please type in the accound ID of the one you wish to deposit to.");
				String id = scan.nextLine();
				int id2 = u.getId();
				new Deposit(u, id, id2);
			} else if(b.equals("3")) {
				System.out.println("Please type in the accound ID of the one you wish to transfer from.");
				String id = scan.nextLine();
				System.out.println("Please type in the accound ID of the one you wish to transfer to.");
				String id2 = scan.nextLine();
				int id3 = u.getId();
				new Transfer(u,id,id2,id3);
			} else if (b.equals("4")) {
				System.out.println("Creating Account");
				new RegisterAccount(u);
			} else {
				new Menu(u);
			}
		}
	}

}
