package tests.interactors;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.DropCourseTransaction;

public class DropCourseTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("dropCourse", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("dropCourse").addCourse(new Course("TEST 400", "13:50", "15:05", null));
	}
	
	@Test
	public void Course_Is_Dropped(){
		DropCourseTransaction transaction = new DropCourseTransaction("dropCourse", 0);
		transaction.completeTransaction();
		assertEquals(0, Rereminder.getInstance().findUserByName("dropCourse").getCourses().size());
	}

}
