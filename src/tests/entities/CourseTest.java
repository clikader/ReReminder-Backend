package tests.entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;

public class CourseTest {

	private static ArrayList<String> days;
	
	@BeforeClass
	public static void setup(){
		days = new ArrayList<String>();
		days.add("Monday");
		days.add("Wednesday");
	}
	
	@Test
	public void Course_Has_Correct_Name_When_Created() {
		Course course = new Course("CS 487", "18:25", "21:05", days);
		assertEquals("CS 487", course.getName());
	}
	
	@Test
	public void Course_Has_Correct_StartTime(){
		Course course = new Course("CS 487", "18:25", "21:05", days);
		assertEquals("18:25", course.getStartTime());
	}
	
	@Test
	public void Course_Has_Correct_EndTime(){
		Course course = new Course("CS 487", "18:25", "21:05", days);
		assertEquals("21:05", course.getEndTime());
	}
	
	@Test
	public void Course_Days_Are_Correct(){
		Course course = new Course("CS 487", "18:25", "21:05", days);
		assertEquals("Monday", course.getDays().get(0));
		assertEquals("Wednesday", course.getDays().get(1));
	}
	
	@Test
	public void Course_ID_Is_Correct_When_Created(){
		Course course = new Course("CS 487", "18:25", "21:05", days);
		assertEquals(-1, course.getId());
	}
	
	@Test
	public void Course_ID_Can_Be_Set(){
		Course course = new Course("CS 487", "18:25", "21:05", days);
		course.setId(0);
		assertEquals(0, course.getId());
	}
	
	@Test
	public void Course_IsOnDay_Returns_True_If_Course_Is_On_Day(){
		Course course = new Course("CS 487", "18:25", "21:05", days);
		assertEquals(true, course.isOnDay("Monday"));
	}
	
	@Test
	public void Course_IsOnDay_Returns_False_If_Course_Is_Not_On_Day(){
		Course course = new Course("CS 487", "18:25", "21:05", days);
		assertEquals(false, course.isOnDay("Tuesday"));
	}

}
