package tests.interactors;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;
import backend.interactors.ModifyCourseTransaction;

public class ModifyCourseTransactionTest {

	@BeforeClass
	public static void setup(){
		Rereminder.getInstance().createUser(new User("modifyCourse", "test@example.com", "pass"));
		Rereminder.getInstance().findUserByName("modifyCourse").addCourse(new Course("TEST 400", "13:50", "15:05", null));
	}
	
	@Test
	public void Course_Is_Modified(){
		ModifyCourseTransaction transaction = new ModifyCourseTransaction("modifyCourse", 0, new Course("TEST 500", "11:25", "12:40", null));
		transaction.completeTransaction();
		assertEquals("TEST 500", Rereminder.getInstance().findUserByName("modifyCourse").getCourses().get(0).getName());
	}
	
}
