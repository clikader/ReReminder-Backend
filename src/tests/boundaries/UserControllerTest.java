package tests.boundaries;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import backend.boundaries.UserController;
import backend.entities.Course;
import backend.entities.Notification;
import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.CreateUserTransaction;

public class UserControllerTest {

	private static ArrayList<String> names = new ArrayList<String>();
	
	@BeforeClass
	public static void setup(){
		names.add("ControllerGetCourses");
		names.add("ControllerAddCourse");
		names.add("ControllerGetCourseDetails");
		names.add("ControllerModifyCourse");
		names.add("ControllerDropCourse");
		names.add("ControllerGetReminders");
		names.add("ControllerAddReminder");
		names.add("ControllerGetReminderDetails");
		names.add("ControllerModifyReminder");
		names.add("ControllerCompleteReminder");
		names.add("ControllerGetNotifications");
		
		for (String name : names){
			addFakeData(name);
		}
	}
	
	private static void addFakeData(String name){
		Rereminder.getInstance().createUser(new User(name, "test@example.com", "pass"));
		
		ArrayList<String> days = new ArrayList<String>();
		days.add("Monday");
		days.add("Wednesday");
		
		Rereminder.getInstance().findUserByName(name).addCourse(new Course("TEST 400", "13:50", "15:05", days));
		Rereminder.getInstance().findUserByName(name).addCourse(new Course("TEST 500", "13:50", "15:05", days));
		
		Rereminder.getInstance().findUserByName(name).addReminder(new Reminder("TEST", "TEST 400", "2016-11-14", "23:59"));
		Rereminder.getInstance().findUserByName(name).addReminder(new Reminder("TEST", "TEST 400", "2016-11-21", "23:59"));
		Rereminder.getInstance().findUserByName(name).addReminder(new Reminder("TEST", "TEST 400", "2016-11-29", "23:59"));
	}
	
	@Test
	public void CreateUser_Returns_Correct_String(){
		UserController controller = new UserController();
		String path = controller.createUser(new CreateUserTransaction("ControllerCreateUser", "test@example.com", "pass"));
		assertEquals("/users/ControllerCreateUser", path);
	}
	
	@Test
	public void GetCourses_Returns_Correct_Number_Of_Courses(){
		UserController controller = new UserController();
		ArrayList<String> courses = controller.getCoursesForUser("ControllerGetCourses");
		assertEquals(2, courses.size());
	}
	
	@Test
	public void AddCourse_Returns_Correct_Path(){
		UserController controller = new UserController();
		String path = controller.addCourseForUser("ControllerAddCourse", new Course("TEST 300", "13:50", "15:05", null));
		assertEquals("/users/ControllerAddCourse/courses/2", path);
	}
	
	@Test
	public void GetCourseDetails_Returns_Correct_Course(){
		UserController controller = new UserController();
		Course course = controller.getCourseDetails("ControllerGetCourseDetails", 0);
		assertEquals("TEST 400", course.getName());
	}
	
	@Test
	public void ModifyCourse_Returns_Correct_Message(){
		UserController controller = new UserController();
		ResponseEntity<String> response = controller.modifyCourseForUser("ControllerModifyCourse",
				0, new Course("TEST 300", "13:50", "15:05", null));
		assertEquals("Modified Course", response.getBody());
	}
	
	@Test
	public void DropCourse_Returns_Correct_Message(){
		UserController controller = new UserController();
		ResponseEntity<String> response = controller.dropCourseForUser("ControllerDropCourse", 0);
		assertEquals("Dropped Course", response.getBody());
	}
	
	@Test
	public void GetReminders_Array_Is_Correct_Size(){
		UserController controller = new UserController();
		ArrayList<String> reminders = controller.getActiveRemindersForUser("ControllerGetReminders");
		assertEquals(3, reminders.size());
	}
	
	@Test
	public void AddReminder_Returns_Correct_Path(){
		UserController controller = new UserController();
		String path = controller.addReminderForUser("ControllerAddReminder", 
				new Reminder("TEST", "TEST 400", "2016-11-14", "23:59"));
		assertEquals("/users/ControllerAddReminder/reminders/3", path);
	}
	
	@Test
	public void GetReminderDetails_Returns_Correct_Reminder(){
		UserController controller = new UserController();
		Reminder reminder = controller.getReminderDetailsForUser("ControllerGetReminderDetails", 0);
		assertEquals("2016-11-14", reminder.getDate());
	}
	
	@Test
	public void ModifyReminder_Returns_Correct_Message(){
		UserController controller = new UserController();
		ResponseEntity<String> response = controller.modifyReminderForUser("ControllerModifyReminder", 0, 
				new Reminder("TEST", "TEST 400", "2016-11-21", "23:59"));
		assertEquals("Modified Reminder", response.getBody());
	}
	
	@Test
	public void MarkReminderComplete_Returns_Correct_Message(){
		UserController controller = new UserController();
		ResponseEntity<String> response = controller.markReminderCompleteForUser("ControllerCompleteReminder", 0);
		assertEquals("Marked Reminder Complete", response.getBody());
	}
	
	@Test
	public void GetNotifications_Array_Is_Correct_Size(){
		UserController controller = new UserController();
		ArrayList<Notification> notifications = controller.getNotificationsForUser("ControllerGetNotifications", "2016-11-14");
		assertEquals(3, notifications.size());
	}
}
