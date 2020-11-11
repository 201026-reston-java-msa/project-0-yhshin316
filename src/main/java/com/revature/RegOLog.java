package com.revature;

import java.util.Scanner;

public class RegOLog {
	
	Scanner scan = new Scanner(System.in);

	public RegOLog() {
		while(true) {
			
			System.out.println("Do you wish to register or sign in?");
			System.out.println("1 = Sign in");
			System.out.println("2 = Register");
			System.out.println("3 = Exit");
			String a = scan.nextLine();
			if(a.equals("1")) {
				new Login();
			}else if(a.equals("2")) {
				new Register();
			}else if(a.equals("3")) {
				System.exit(0);
			}else {
				continue;
			}
			
		}
		
	}
}
