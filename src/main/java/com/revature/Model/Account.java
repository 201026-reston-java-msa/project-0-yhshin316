package com.revature.Model;

public class Account {
	
	private int id;
	private String type;
	private String status;
	private double balance;
	private int userid1;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String type, String status, double balance, int userid1) {
		super();
		this.id = id;
		this.type = type;
		this.status = status;
		this.balance = balance;
		this.userid1 = userid1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserid1() {
		return userid1;
	}

	public void setUserid1(int userid1) {
		this.userid1 = userid1;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", status=" + status + ", balance=" + balance + ", userid1="
				+ userid1 + "]";
	}

	
}
