package com.revature;

import java.util.Scanner;

import com.revature.Model.User;
import com.revature.Service.UserService;

public class Profile {
	Scanner scan = new Scanner(System.in);
	UserService serv = new UserService();
	
	public Profile(User u) {
		User use = serv.getUserByUsername(u.getUsername());
		System.out.println("Id: " + use.getId());
		System.out.println("Username: " + use.getUsername());
		System.out.println("Password: " + use.getPassword());
		System.out.println("First Name: " + use.getFname());
		System.out.println("Last Name: " + use.getLname());
		System.out.println("Email: " + use.getEmail());
		System.out.println("Type: " + use.getType());
		System.out.println("Id and Type cannot be changed by customer");
		System.out.println("Is there anything wrong with the profile? y/n");
		String a = scan.nextLine();
		if(a.equals("y")) {
			new EditProfile(use, use.getUsername());
		}else {
			new Menu(use);
		}
	}

}
