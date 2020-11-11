package com.revature.DAO;

import java.util.List;

import com.revature.Model.Account;
import com.revature.Model.User;

public interface AccountDAO {

	public List<Account> getAllAccounts();
	public boolean changeBalance(Account a);
	public Account getAccountByID(int id);
	public boolean updateAccountByID(int id,double balance,String status,String type);
	public List<Account> getAllAccountsByUserID(User u);
	
	
}
