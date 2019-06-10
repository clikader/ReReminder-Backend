package tests.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import backend.entities.Reminder;

public class ReminderTest {

	@Test
	public void Reminder_Has_Correct_Content() {
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		assertEquals("Test HW", r.getContent());
	}

	@Test
	public void Reminder_Has_Correct_Course(){
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		assertEquals("CS 487", r.getCourse());
	}
	
	@Test
	public void Reminder_Has_Correct_DueDate(){
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		assertEquals("2016-11-10", r.getDate());
	}
	
	@Test
	public void Reminder_Has_Correct_Time(){
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		assertEquals("23:59", r.getTime());
	}
	
	@Test
	public void Reminder_ID_Set_To_Correct_Value_When_Created(){
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		assertEquals(-1, r.getId());
	}
	
	@Test
	public void Reminder_ID_Can_Be_Set(){
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		r.setId(0);
		assertEquals(0, r.getId());
	}
	
	@Test
	public void Reminder_Is_Incomplete_When_Created(){
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		assertEquals(false, r.isComplete());
	}
	
	@Test
	public void Reminder_Can_Be_Marked_Complete(){
		Reminder r = new Reminder("Test HW", "CS 487", "2016-11-10", "23:59");
		r.setComplete();
		assertEquals(true, r.isComplete());
	}
}
