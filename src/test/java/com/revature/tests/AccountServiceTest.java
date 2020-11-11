package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.DAO.AccountDAOImpl;
import com.revature.Model.Account;
import com.revature.Model.User;
import com.revature.Service.AccountService;

public class AccountServiceTest {
	
	@Mock
	private AccountDAOImpl daoMock;
	
	@InjectMocks
	private AccountService service;
	
	@Before
	public void setUp() throws Exception {
		
		/*
		 * These instances would be created at the start of every test method in this class
		 */
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void testWithdraw_returnTrue() {
	Account a = new Account();
	double b = 0;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.changeBalance(a)).thenReturn(true);
		
		assertEquals(service.Withdraw(a, b), true);
	
	}

	@Test
	public void testWithdraw_returnFalse() {
	Account a = new Account();
	double b = 1;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.changeBalance(a)).thenReturn(false);
		
		assertEquals(service.Withdraw(a, b), false);
	
	}
	
	@Test
	public void testDeposit_returnTrue() {
	Account a = new Account();
	double b = 100;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.changeBalance(a)).thenReturn(true);
		
		assertEquals(service.Deposit(a, b), true);
	
	}

	@Test
	public void testDeposit_returnFalse() {
	Account a = new Account();
	double b = -100;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.changeBalance(a)).thenReturn(false);
		
		assertEquals(service.Deposit(a, b), false);
	
	}
	
	@Test
	public void testgetAllAccounts_returnList() {
	List<Account> a = new ArrayList<>();
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.getAllAccounts()).thenReturn(a);
		
		assertEquals(service.getAllAccounts(), a);
	
	}
	
	@Test
	public void testgetAccountsByID_returnAccount() {
	Account a = new Account();
	int id = 1;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.getAccountByID(id)).thenReturn(a);
		
		assertEquals(service.getAccountByID(id), a);
	
	}
	
	@Test
	public void testCreateAccount_returnTrue() {
	double balance = 100;
	String status = "";
	String accounttype = "";
	int userid = 0;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.createAccount(balance, status, accounttype, userid)).thenReturn(true);
		
		assertEquals(service.createAccount(balance, status, accounttype, userid), true);
	
	}
	
	@Test
	public void testupdateAccount_returnTrue() {
	double balance = 100;
	String status = "";
	String type = "";
	int id = 0;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.updateAccountByID(id, balance, status, type)).thenReturn(true);
		
		assertEquals(service.updateAccountByID(id, balance, status, type), true);
	
	}
	
	@Test
	public void testgetAllAccountsByUserid_returnList() {
	List<Account> a = new ArrayList<>();
	User u = new User();
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.getAllAccountsByUserID(u)).thenReturn(a);
		
		assertEquals(service.getAllAccountsByUserID(u), a);
	
	}
	
	
	

	
}
