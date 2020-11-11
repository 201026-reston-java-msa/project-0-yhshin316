package com.revature;

import java.util.Scanner;

import com.revature.Model.User;

public class MenuEmployee {
	
	Scanner scan = new Scanner(System.in);

	public MenuEmployee(User u) {
		System.out.println("In Employee Menu");
		System.out.println("0 = Log out");
		System.out.println("1 = See All Users");
		System.out.println("2 = See All Accounts");
		String a = scan.nextLine();
		if (a.equals("0")) {
			new RegOLog();
		}
		else if (a.equals("1")) {
			new SeeAllUsers(u);
		}else if (a.equals("2")){
			new SeeAllAccounts(u);
		}
	}

}
