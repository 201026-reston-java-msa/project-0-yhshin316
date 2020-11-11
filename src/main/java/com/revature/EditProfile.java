package com.revature;

import java.util.Scanner;

import com.revature.Model.User;
import com.revature.Service.UserService;

public class EditProfile {
	
	UserService serv = new UserService();
	Scanner scan = new Scanner(System.in);
	User use;
	int id;
	String username;
	String password;
	String fname;
	String lname;
	String email;
	String type;
	boolean check;
	
	public EditProfile(User u, String inputusername) {
		// TODO Auto-generated constructor stub
		use = serv.getUserByUsername(inputusername);
		if(use==null) {
			new SeeAllUsers(u);
		}
		id = use.getId();
		System.out.println("You are in user edit");
		System.out.println("Type 0 if you do not want to change.");
		System.out.println("Current username is "+use.getUsername());
		username = scan.nextLine();
		if(username.equals("0")) {
			username = use.getUsername();
		}
		System.out.println("Current password is "+use.getPassword());
		password = scan.nextLine();
		if(password.equals("0")) {
			password = use.getPassword();
		}
		System.out.println("Current first name is "+use.getFname());
		fname = scan.nextLine();
		if(fname.equals("0")) {
			fname = use.getFname();
		}
		System.out.println("Current last name is "+use.getLname());
		lname = scan.nextLine();
		if(lname.equals("0")) {
			lname = use.getLname();
		}
		System.out.println("Current email is "+use.getEmail());
		email = scan.nextLine();
		if(email.equals("0")) {
			email = use.getEmail();
		}
		while(true) {
			if(u.getType().equals("Admin")) {
				System.out.println("Current user type is "+use.getType());
				System.out.println("Type 1 for Admin");
				System.out.println("Type 2 for Employee");
				System.out.println("Type 3 for Customer");
				type = scan.nextLine();
				if(type.equals("0")) {
					type = use.getType();
					break;
				}else if(type.equals("1")) {
					type = "Admin";
					break;
				}else if(type.equals("2")) {
					type = "Employee";
					break;
				}else if(type.equals("3")) {
					type = "Customer";
					break;
				}else {
					continue;
				}
			}else {
				type = u.getType();
				break;
			}
		}
		check = serv.updateUser(id, username, password, fname, lname, email, type);
		
		if(check) {
			System.out.println("Update successful");
			if(u.getType().equals("Admin")||u.getType().equals("Employee")) {
				new SeeAllUsers(u);
			}else {
				
				new Profile(u);
			}
			
		}else {
			System.out.println("Update failed");
			if(u.getType().equals("Admin")||u.getType().equals("Employee")) {
				new SeeAllUsers(u);
			}else {
				new Profile(u);
			}
		}
		
	}

}
