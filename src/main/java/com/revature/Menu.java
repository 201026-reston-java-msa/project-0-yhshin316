package com.revature;

import com.revature.Model.User;

public class Menu {

	public Menu(User u) {
		if(u.getType().equals("Admin")) {
			System.out.println("In Admin menu option");
			new MenuAdmin(u);
		}else if(u.getType().equals("Employee")) {
			System.out.println("In employee menu option");
			new MenuEmployee(u);
		}else if(u.getType().equals("Customer")) {
			System.out.println("In customer menu option");
			new MenuCustomer(u);			
		}
		else {
			System.out.println(u.getType());
			new Login();
		}
	}
	

}
