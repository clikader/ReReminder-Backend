package tests.interactors;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.AddCourseTransaction;

public class AddCourseTransactionTest {

	private static ArrayList<String> days;
	
	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("addCourse", "test@example.com", "pass"));
		days = new ArrayList<String>();
		days.add("Monday");
		days.add("Wednesday");
	}
	
	@Test
	public void Correct_ID_Is_Returned(){
		AddCourseTransaction transaction = new AddCourseTransaction("addCourse", new Course("TEST 400", "13:50", "15:05", days));
		int id = transaction.completeTransaction();
		assertEquals(0, id);
	}

}
