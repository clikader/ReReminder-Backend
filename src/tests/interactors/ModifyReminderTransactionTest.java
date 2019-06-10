package tests.interactors;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.ModifyReminderTransaction;

public class ModifyReminderTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("modifyReminder", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("modifyReminder").addReminder(new Reminder("Test", "TEST 500", "2016-11-10", "23:59"));
	}
	
	@Test
	public void Reminder_Is_Modified(){
		ModifyReminderTransaction transaction = new ModifyReminderTransaction("modifyReminder", 0, new Reminder("Test", "TEST 500", "2016-11-13", "23:59"));
		transaction.completeTransaction();
		assertEquals("2016-11-13", Rereminder.getInstance().findUserByName("modifyReminder").getActiveReminders().get(0).getDate());
	}

}
