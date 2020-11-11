package com.revature;

import java.util.Scanner;

import com.revature.Model.User;
import com.revature.Service.UserService;

public class testing {
	
	
	public static void main(String[] args) {
		User u;
		Scanner scan = new Scanner(System.in);
		String username;
		UserService serv = new UserService();
		System.out.println("Hello username please");
		username = scan.nextLine();
		u = serv.getUserByUsername(username);
		if(u.getUsername()!=null) {
			System.out.println("Username already exists");
		}else {
			System.out.println("No such username in database");
		}
	}
	
}
