package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.Model.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	

	
	private static Logger log = Logger.getLogger(UserDAOImpl.class);
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Static block has failed me");
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bankuser ORDER BY userid ASC";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User use = new User();
				
				use.setId(Integer.parseInt(rs.getString("userid")));
				use.setUsername(rs.getString("username"));
				use.setPassword(rs.getString("userpassword"));
				use.setFname(rs.getString("firstname"));
				use.setLname(rs.getString("lastname"));
				use.setEmail(rs.getString("email"));
				use.setType(rs.getString("usertype"));
				
				
				users.add(use);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Failed to get All Users");
		}
		log.info("Succeeded to get All Users");
		return users;
	}

	@Override
	public User getUserById(User u) {
		User use = new User();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			
			String sql = "SELECT * FROM bankuser WHERE userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Integer.toString(u.getId()));
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				use.setId(Integer.parseInt(rs.getString("userid")));
				use.setUsername(rs.getString("username"));
				use.setPassword(rs.getString("userpassword"));
				use.setFname(rs.getString("firstname"));
				use.setLname(rs.getString("lastname"));
				use.setEmail(rs.getString("email"));
				use.setType(rs.getString("usertype"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Failed to get User by ID");
		}	
		
		log.info("Succeeded to get User By ID");
		return use;
	}

	@Override
	public User getUserByUsername(String inputusername) {
		User use = new User();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bankuser WHERE username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inputusername);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				use.setId(Integer.parseInt(rs.getString("userid")));
				use.setUsername(rs.getString("username"));
				use.setPassword(rs.getString("userpassword"));
				use.setFname(rs.getString("firstname"));
				use.setLname(rs.getString("lastname"));
				use.setEmail(rs.getString("email"));
				use.setType(rs.getString("usertype"));
			}
		} catch (SQLException e) {
			log.warn("Failed to get User by username");
			e.printStackTrace();
		}	
		log.info("Succeeded to get User By username");
		return use;

	}


	@Override
	public User checkLogin(String inputusername, String inputpassword) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM bankuser WHERE username=? AND userpassword=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, inputusername);
			ps.setString(2, inputpassword);
			
			ResultSet rs = ps.executeQuery();
			User u = new User();
			if (rs.next()) {
				
				u.setId(Integer.parseInt(rs.getString("userid")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("userpassword"));
				u.setFname(rs.getString("firstname"));
				u.setFname(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setType(rs.getString("usertype"));
				
			}
			log.info(u.getUsername() + " has logged in");
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
		
	}
	
	public boolean register(String putusername, String putpassword, String firstName, String lastName, String email, String type) 
	{
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO bankuser (username,userpassword,firstname,lastname,email,usertype) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, putusername);
			ps.setString(2, putpassword);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setString(6, type);
			
			if (ps.executeUpdate() != 0) {
				log.info(putusername + "has registered");
				return true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
	
	public boolean updateUserByID(int userid, String putusername, String putpassword, String firstName, String lastName, String email, String type) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE bankuser SET username = ?, userpassword = ?, firstname= ?,lastname = ?,email= ?,usertype = ? WHERE userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, putusername);
			ps.setString(2, putpassword);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setString(6, type);
			ps.setInt(7, userid);
			
			if (ps.executeUpdate() != 0) {
				log.info(putusername+"'s" + " profile has been updated");
				return true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}


}
