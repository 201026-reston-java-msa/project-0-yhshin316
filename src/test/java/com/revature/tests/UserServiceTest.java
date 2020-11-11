package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.revature.DAO.UserDAOImpl;
import com.revature.Model.User;
import com.revature.Service.UserService;

/*
 * Most of the classes we're testing deletaget the work to other methods in other classes (like the DAO)
 */
public class UserServiceTest {

	// @Mock will create a mock implementation for the EmployeeDaoImpl
	@Mock
	private UserDAOImpl daoMock;
	
	// @InjectMocks will inject the mocks marked with @Mock to this instance when it is created
	@InjectMocks
	private UserService service;
	
	@Before
	public void setUp() throws Exception {
		
		/*
		 * These instances would be created at the start of every test method in this class
		 */
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testRegisteration_returnTrue() {
	String putusername = "a";
	String putpassword = "a";
	String firstName = "a";
	String lastName = "a";
	String email = "a";
	String type = "a";
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.register(putusername, putpassword, firstName, lastName, email, type)).thenReturn(true);
		
		assertEquals(service.register(putusername, putpassword, firstName, lastName, email, type), true);
		
	}
	
	@Test
	public void testUpdateUser_returnTrue() {
	String putusername = "a";
	String putpassword = "a";
	String firstName = "a";
	String lastName = "a";
	String email = "a";
	String type = "a";
	int userid = 1;
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.updateUserByID(userid, putusername, putpassword, firstName, lastName, email, type)).thenReturn(true);
		
		assertEquals(service.updateUser(userid, putusername, putpassword, firstName, lastName, email, type), true);
		
	}
	
	@Test
	public void testcheckLogin_returnUser() {
	String putusername = "a";
	String putpassword = "a";
	User u = new User();
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.checkLogin(putusername, putpassword)).thenReturn(u);
		
		assertEquals(service.checkLogin(putusername, putpassword), u);
		
	}
	
	@Test
	public void testgetUserByUsername_returnUser() {
	String putusername = "a";
	User u = new User();
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.getUserByUsername(putusername)).thenReturn(u);
		
		assertEquals(service.getUserByUsername(putusername), u);
		
	}
	
	@Test
	public void testgetAllUsers_returnListUser() {
	List<User> u = new ArrayList<>();
		
		//User employee = Mockito.mock(User.class);
		
		when(daoMock.getAllUsers()).thenReturn(u);
		
		assertEquals(service.getAllUsers(), u);
		
	}
	
	
	
	
	
	/* The When - Then pattern" 
	 * When is a static method of the Mockito class and it returns 
	 * OnGoingStubbing<T> (T is the return tupe of the method that we're mocking)
	 * 
	 * The following are methods that you can call on this stub:
	 * 
	 * - thenReturn(returnValue)
	 * - thenThrow(exception)
	 * - thenCallRealMethod()
	 * - thenAnswer() - this can be used to set up more complex/smarter stubs and mock behavior of the methods
	 * 
	 */
	
//	@Test(expected = NullPointerException.class) // use attribute and assign to expected Exception to be thrown
//	public void whenExceptionThrown_theExceptionIsSatisfied() {
//		String word = null;
//		
//		// this automatically results in an Exception
//		word.length();
//	}
	
//	@Rule 
//	public ExpectedException e = ExpectedException.none();
	
//	@Test
//	public void testArithmetic() {
//		int i = 1/0;
//	}
}















