package tests.interactors;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.CompleteReminderTransaction;

public class CompleteReminderTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("completeReminder", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("completeReminder").addReminder(new Reminder("Test", "TEST 400", "2016-11-10", "23:59"));
	}
	
	@Test
	public void Reminder_Is_Marked_Complete(){
		CompleteReminderTransaction transaction = new CompleteReminderTransaction("completeReminder", 0);
		transaction.completeTransaction();
		assertEquals(true, Rereminder.getInstance().findUserByName("completeReminder").findReminderByID(0).isComplete());
	}

}
