package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Model.Account;
import com.revature.Model.User;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {


	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> Accounts = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bankaccount ORDER BY accountid ASC";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account Account = new Account();

				Account.setId(Integer.parseInt(rs.getString("accountid")));
				Account.setBalance(Double.parseDouble(rs.getString("balance")));
				Account.setStatus(rs.getString("status"));
				Account.setType(rs.getString("accounttype"));
				Account.setUserid1(Integer.parseInt(rs.getString("userid")));
//				
				Accounts.add(Account);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Accounts;
	}

	@Override
	public List<Account> getAllAccountsByUserID(User u) {
		
		List<Account> Accounts = new ArrayList<>();
		int id = u.getId();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bankaccount WHERE userid = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account Account = new Account();
				
				Account.setId(Integer.parseInt(rs.getString("accountid")));
				Account.setBalance(Double.parseDouble(rs.getString("balance")));
				Account.setStatus(rs.getString("status"));
				Account.setType(rs.getString("accounttype"));
				Account.setUserid1(Integer.parseInt(rs.getString("userid")));
			
				Accounts.add(Account);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Accounts;
	}
	
	public Account getAccountByID(int id) {
		Account account = new Account();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * FROM bankaccount WHERE accountid = ? ORDER BY accountid ASC;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				account.setId(Integer.parseInt(rs.getString("accountid")));
				account.setBalance(Double.parseDouble(rs.getString("balance")));
				account.setStatus(rs.getString("status"));
				account.setType(rs.getString("accounttype"));
				account.setUserid1(Integer.parseInt(rs.getString("userid")));
				
				return account;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean changeBalance(Account a) {
		int id = a.getId();
		double balance = a.getBalance();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE bankaccount SET balance = ? WHERE accountid = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setInt(2, id);

			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean updateAccountByID(int id,double balance,String status,String type) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE bankaccount SET balance = ?, status = ?, accounttype = ? WHERE accountid = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, status);
			ps.setString(3, type);
			ps.setInt(4, id);

			if (ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean createAccount(double balance, String status, String accounttype, int userid) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO bankaccount (balance, status, accounttype, userid) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, status);
			ps.setString(3, accounttype);
			ps.setInt(4, userid);

			
			if (ps.executeUpdate() != 0) {
				return true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}

}
