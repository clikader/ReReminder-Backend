package tests.interactors;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.GetCoursesTransaction;

public class GetCoursesTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("getCourses", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("getCourses").addCourse(new Course("TEST 400", "13:50", "15:05", null));
		Rereminder.getInstance().findUserByName("getCourses").addCourse(new Course("TEST 500", "13:50", "15:05", null));
	}
	
	@Test
	public void Course_Array_Is_Correct_Size(){
		GetCoursesTransaction transaction = new GetCoursesTransaction("getCourses");
		ArrayList<String> courses = transaction.completeTransaction();
		assertEquals(2, courses.size());
	}

}
