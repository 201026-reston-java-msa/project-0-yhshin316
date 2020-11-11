package com.revature.DAO;

import java.util.List;

import com.revature.Model.User;

public interface UserDAO {
	
	public List<User> getAllUsers();
	public User getUserById(User u);
	public User getUserByUsername(String username);
	public User checkLogin(String inputusername, String inputpassword);

}
