package tests.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;
import backend.entities.Reminder;
import backend.entities.User;

public class UserTest {
	
	private static ArrayList<String> days;
	
	@BeforeClass
	public static void setup(){
		days = new ArrayList<String>();
		days.add("Monday");
		days.add("Wednesday");
	}

	@Test
	public void User_Has_Correct_Username() {
		User user = new User("test", "test@example.com", "pass");
		assertEquals("test", user.getUsername());
	}
	
	@Test
	public void User_Has_Correct_Email(){
		User user = new User("test", "test@example.com", "pass");
		assertEquals("test@example.com", user.getEmail());
	}
	
	@Test
	public void User_Has_Correct_Password(){
		User user = new User("test", "test@example.com", "pass");
		assertEquals("pass", user.getPassword());
	}

	// User Course Methods
	@Test
	public void Add_Course_Correctly_Adds_Course(){
		User user = new User("test", "test@example.com", "pass");
		user.addCourse(new Course("CS 487", "18:25", "21:05", days));
		Course c = user.findCourseByID(0);
		assertEquals("CS 487", c.getName());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void DropCourse_Removes_Course(){
		User user = new User("test", "test@example.com", "pass");
		user.addCourse(new Course("CS 487", "18:25", "21:05", days));
		user.dropCourse(0);
		Course c = user.findCourseByID(0);
	}
	
	@Test
	public void DropCourse_Sets_Correct_IDs(){
		User user = new User("test", "test@example.com", "pass");
		user.addCourse(new Course("CS 487", "18:25", "21:05", days));
		user.addCourse(new Course("CS 445", "15:05", "16:30", days));
		user.dropCourse(0);
		assertEquals("CS 445", user.findCourseByID(0).getName());
	}

	@Test
	public void ModifyCourse_Changes_Course_Info(){
		User user = new User("test", "test@example.com", "pass");
		user.addCourse(new Course("CS 487", "18:25", "21:05", days));
		user.modifyCourse(0, new Course("CS 445", "15:05", "16:30", days));
		assertEquals("CS 445", user.findCourseByID(0).getName());
	}
	
	// User Reminder Methods
	@Test
	public void AddReminder_Adds_Reminder(){
		User user = new User("test", "test@example.com", "pass");
		user.addReminder(new Reminder("Test", "CS 487", "2016-11-10", "23:59"));
		assertEquals("Test", user.findReminderByID(0).getContent());
	}
	
	@Test
	public void ModifyReminder_Changes_Reminder(){
		User user = new User("test", "test@example.com", "pass");
		user.addReminder(new Reminder("Test", "CS 487", "2016-11-10", "23:59"));
		user.modifyReminder(0, new Reminder("Test 2", "CS 487", "2016-11-17", "23:59"));
		assertEquals("Test 2", user.findReminderByID(0).getContent());
	}
	
	@Test
	public void MarkReminderComplete_Marks_Reminder(){
		User user = new User("test", "test@example.com", "pass");
		user.addReminder(new Reminder("Test", "CS 487", "2016-11-10", "23:59"));
		user.markReminderComplete(0);
		assertEquals(0, user.getActiveReminders().size());
	}
	
	@Test
	public void GetActiveReminders_Returns_Active_Reminders(){
		User user = new User("test", "test@example.com", "pass");
		user.addReminder(new Reminder("Test", "CS 487", "2016-11-10", "23:59"));
		user.addReminder(new Reminder("Test 2", "CS 487", "2016-11-17", "23:59"));
		assertEquals(2, user.getActiveReminders().size());
	}
}
