package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.Model.User;
import com.revature.Service.UserService;

public class SeeAllUsers {
	
	Scanner scan = new Scanner(System.in);
	
	UserService serv = new UserService();

	public SeeAllUsers(User u) {
		// TODO Auto-generated constructor stub
		System.out.println("Here are all the users");
		List<User> A = serv.getAllUsers();
		
		for(User a : A) {
			System.out.println(a);
		}
		if(u.getType().equals("Admin")) {
			
			System.out.println("1 = Edit");
			System.out.println("Any = Back to menu");
			
			String b = scan.nextLine();
			
			if(b.equals("1")) {
				System.out.println("Please type in the username of the one you wish to edit.");
				String username = scan.nextLine();
				new EditProfile(u,username);
				
			}else {
				new Menu(u);
			}
		}else {
			new Menu(u);
		}
		
		
	}
	
}
