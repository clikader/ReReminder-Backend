package tests.interactors;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.GetRemindersTransaction;

public class GetRemindersTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("getReminders", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("getReminders").addReminder(new Reminder("Test", "TEST 400", "2016-11-10", "23:59"));
		Rereminder.getInstance().findUserByName("getReminders").addReminder(new Reminder("Test", "TEST 400", "2016-11-10", "23:59"));
		Rereminder.getInstance().findUserByName("getReminders").addReminder(new Reminder("Test", "TEST 400", "2016-11-10", "23:59"));
		Rereminder.getInstance().findUserByName("getReminders").markReminderComplete(1);
	}
	
	@Test
	public void Reminders_Array_Is_Correct_Size(){
		GetRemindersTransaction transaction = new GetRemindersTransaction("getReminders");
		ArrayList<String> reminders = transaction.completeTransaction();
		assertEquals(2, reminders.size());
	}

}
