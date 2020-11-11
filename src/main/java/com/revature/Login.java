package com.revature;

import java.util.Scanner;

import com.revature.Model.User;
import com.revature.Service.UserService;

public class Login {
	
	String username;
	String password;
	UserService serv = new UserService();
	Scanner scan = new Scanner(System.in);
	User u;
	
	public Login() {
		try {
			System.out.println("Please type in your username or type 0 to exit");
			username = scan.nextLine();
			if(!username.equals("0")) {
				System.out.println("Please type in your password");
				password = scan.nextLine();
				u = serv.checkLogin(username, password);
				new Menu(u);				
				
			}else {
				new RegOLog();
			}
			
		}catch(Exception e) {
			new Login();
		}
		
	}

}
