package tests.interactors;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.GetReminderDetailsTransaction;

public class GetReminderDetailsTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("getReminderDetails", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("getReminderDetails").addReminder(new Reminder("Test", "TEST 400", "2016-11-10", "23:59"));
	}
	
	@Test
	public void Returns_Correct_Reminder(){
		GetReminderDetailsTransaction transaction = new GetReminderDetailsTransaction("getReminderDetails", 0);
		Reminder reminder = transaction.completeTransaction();
		assertEquals("Test", reminder.getContent());
	}
}
