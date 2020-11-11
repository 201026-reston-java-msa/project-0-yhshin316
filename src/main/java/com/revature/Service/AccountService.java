package com.revature.Service;

import java.util.List;

import com.revature.CustomException;
import com.revature.DAO.AccountDAOImpl;
import com.revature.Model.Account;
import com.revature.Model.User;

public class AccountService {
	
	AccountDAOImpl impl = new AccountDAOImpl();
	
	public boolean Withdraw(Account a, double b) {
		boolean check;
		double bal = a.getBalance();
		double change = bal-b;
		
		try {
			overdraw(change);
		}catch(CustomException c) {
			System.out.println("You have overdrawn");
			return false;
		}
		
		if(b<0){
			return false;
		}else{
			a.setBalance(change);
			check = impl.changeBalance(a);
			if(check) {
				System.out.println("Withdraw Success");
				return check;
			}else {
				System.out.println("Withdraw Failed");
				return check;
			}
		}
	}
	
	public void overdraw(double change) throws CustomException {
		if(change<0) {
			throw new CustomException("You have overdrawn");
		}
	}
	
	
	
	public boolean Deposit(Account a, double b) {
		boolean check;
		double bal = a.getBalance();
		double change = bal+b;
		a.setBalance(change);
		check = impl.changeBalance(a);
		if(b<0) {
			return false;
		}else if(check) {
			System.out.println("Deposit Success");
			return check;
		}else {
			System.out.println("Deposit Failed");
			return check;
		}
	}
	
	public boolean WithdrawCustomer(Account a, double b, int userid) {
		boolean check;
		double bal = a.getBalance();
		double change = bal-b;
		if(b<0) {
			return false;
		}else if (change<0) {
			System.out.println("You have overdrawn");
			return false;
		}else {
			if(a.getUserid1()==userid) {
				
				a.setBalance(change);
				check = impl.changeBalance(a);
				if(check) {
					System.out.println("Withdraw Success");
					return check;
				}else {
					System.out.println("Withdraw Failed");
					return check;
				}
			}else {
				System.out.println("Withdraw Failed");
				return false;
			}
		}
	}
	
	public boolean DepositCustomer(Account a, double b, int userid) {
		boolean check;
		double bal = a.getBalance();
		double change = bal+b;
		if(a.getUserid1()==userid) {
			
			a.setBalance(change);
			check = impl.changeBalance(a);
			if (b<0) {
				return false;
			}else if(check) {
				System.out.println("Deposit Success");
				return check;
			}else {
				System.out.println("Deposit Failed");
				return check;
			}
		}else {
			System.out.println("Deposit Failed");
			return false;
		}
	}
	
	public List<Account> getAllAccounts(){
		return impl.getAllAccounts();
	}
	
	public Account getAccountByID(int ID) {
		return impl.getAccountByID(ID);
	}
	
	public boolean updateAccountByID(int id,double balance,String status,String type) {
		return impl.updateAccountByID(id, balance, status, type);
	}
	
	public boolean createAccount(double balance, String status, String accounttype, int userid) {
		return impl.createAccount(balance, status, accounttype, userid);
	}
	
	public List<Account> getAllAccountsByUserID(User u){
		return impl.getAllAccountsByUserID(u);
	}

}
