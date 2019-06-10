package tests.interactors;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.GetCourseDetailsTransaction;

public class GetCourseDetailsTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("courseDetails", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("courseDetails").addCourse(new Course("TEST 400", "13:50", "15:05", null));
	}
	
	@Test
	public void Correct_Course_Is_Returned(){
		GetCourseDetailsTransaction transaction = new GetCourseDetailsTransaction("courseDetails", 0);
		Course course = transaction.completeTransaction();
		assertEquals("TEST 400", course.getName());
	}

}
