package tests.interactors;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.entities.User;
import backend.interactors.CreateUserTransaction;

public class CreateUserTransactionTest {

	@Test
	public void User_Returned_Has_Correct_Info(){
		CreateUserTransaction transaction = new CreateUserTransaction("test", "test@example.com", "pass");
		User user = transaction.completeTransaction();
		assertEquals("test", user.getUsername());
	}
}
