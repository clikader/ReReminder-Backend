package tests.interactors;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;
import backend.entities.Notification;
import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.GetNotificationsTransaction;

public class GetNotificationsTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("getNotifications", "test@example.com", "pass"));
		
		ArrayList<String> days = new ArrayList<String>();
		days.add("Monday");
		days.add("Wednesday");
		
		ArrayList<String> days2 = new ArrayList<String>();
		days2.add("Tuesday");
		
		Rereminder.getInstance().findUserByName("getNotifications").addCourse(new Course("TEST 400", "13:50", "15:05", days));
		Rereminder.getInstance().findUserByName("getNotifications").addCourse(new Course("TEST 500", "13:50", "15:05", days2));
		Rereminder.getInstance().findUserByName("getNotifications").addReminder(new Reminder("Test", "TEST 400", "2016-11-14", "23:59"));
		Rereminder.getInstance().findUserByName("getNotifications").addReminder(new Reminder("Test", "TEST 400", "2016-11-21", "23:59"));
		Rereminder.getInstance().findUserByName("getNotifications").addReminder(new Reminder("Test", "TEST 400", "2017-11-21", "23:59"));
		Rereminder.getInstance().findUserByName("getNotifications").addReminder(new Reminder("Test", "TEST 400", "2016-12-21", "23:59"));
	}
	
	@Test
	public void Notification_Array_Size_Is_Correct(){
		GetNotificationsTransaction transaction = new GetNotificationsTransaction("getNotifications", "2016-11-14");
		ArrayList<Notification> notifications = transaction.completeTransaction();
		assertEquals(2, notifications.size());
	}

}
