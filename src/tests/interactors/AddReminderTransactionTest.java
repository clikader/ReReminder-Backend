package tests.interactors;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.AddReminderTransaction;

public class AddReminderTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("addReminder", "test@example.com", "pass"));
	}
	
	@Test
	public void Reminder_ID_Is_Correctly_Returned(){
		AddReminderTransaction transaction = new AddReminderTransaction("addReminder", new Reminder("Test", "TEST 400", "2016-11-10", "23:59"));
		assertEquals(0, transaction.completeTransaction());
	}

}
