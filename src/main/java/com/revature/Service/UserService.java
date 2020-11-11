package com.revature.Service;

import java.util.List;

import com.revature.DAO.UserDAOImpl;
import com.revature.Model.User;

public class UserService {
	UserDAOImpl impl = new UserDAOImpl();

	public User checkLogin(String inputusername,String inputpassword) {
		return impl.checkLogin(inputusername, inputpassword);
	}
	
	public User getUserByUsername(String username) {
		try {			
			return impl.getUserByUsername(username);
		}catch(Exception e) {
			return null;
		}
	}
	
	public boolean register(String putusername, String putpassword, String firstName, String lastName, String email, String type) {
		return impl.register(putusername,putpassword,firstName,lastName,email,type);
	}
	
	public List<User> getAllUsers(){
		return impl.getAllUsers();
	}
	
	public boolean updateUser(int userid, String putusername, String putpassword, String firstName, String lastName, String email, String type) {
		return impl.updateUserByID(userid, putusername, putpassword, firstName, lastName, email, type);
	}
	
}
