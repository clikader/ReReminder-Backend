package tests.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import backend.entities.Rereminder;
import backend.entities.User;

public class RereminderTest {

	@Test
	public void CreateUser_Adds_User(){
		Rereminder r = Rereminder.getInstance();
		r.createUser(new User("test", "test@example.com", "password"));
		assertEquals("test", r.findUserByName("test").getUsername());
	}
	
	@Test
	public void ModifyUser_Modifies_User(){
		Rereminder r = Rereminder.getInstance();
		r.createUser(new User("test2", "test2@example.com", "password"));
		r.modifyUser(new User("test2", "test2@example.com", "password2"));
		assertEquals("password2", r.findUserByName("test2").getPassword());
	}

	@Test (expected = RuntimeException.class)
	public void FindUserByName_Fails_If_User_Does_Not_Exist(){
		Rereminder r = Rereminder.getInstance();
		r.findUserByName("Test3");
	}
}
