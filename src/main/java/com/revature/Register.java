package com.revature;

import java.util.Scanner;

import com.revature.Model.User;
import com.revature.Service.UserService;

public class Register {
	
	Scanner scan = new Scanner(System.in);
	UserService serv = new UserService();
	User u;
	boolean check;
	
	public Register() {
		// TODO Auto-generated constructor stub
		while(true) {
			System.out.println("Welcome to registeration");
			System.out.println("Please type in the username you wish to use. Or type 0 to leave");
			String username = scan.nextLine();
			u = serv.getUserByUsername(username);
			if(username.equals("0")) {
				new RegOLog();
			}
			else if(u.getUsername()!=null) {
				System.out.println("Username already exists");
				continue;
			}
			else {
				System.out.println("Please type in the password you wish to use.");
				String password = scan.nextLine();
				System.out.println("Please type in the first name.");
				String firstname = scan.nextLine();
				System.out.println("Please type in the last name.");
				String lastname = scan.nextLine();
				System.out.println("Please type in the email.");
				String email = scan.nextLine();
				String type = "Customer";
				check = serv.register(username, password, firstname, lastname, email, type);
				
				if(check) {
					System.out.println("Registeration Successful");
					u = serv.getUserByUsername(username);
					new Menu(u);
				}else {
					System.out.println("Registeration failed");
					continue;
				}
			
			}
		
		}
	}
	

}
