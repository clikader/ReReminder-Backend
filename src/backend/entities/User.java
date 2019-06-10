package backend.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private String username, email, password;
	private ArrayList<Course> courses;
	private ArrayList<Reminder> reminders;
	
	@JsonCreator
	public User(@JsonProperty("username") String username, @JsonProperty("emailAddress") String email,
				@JsonProperty("password") String password){
		this.username = username;
		this.email = email;
		this.password = password;
		courses = new ArrayList<Course>();
		reminders = new ArrayList<Reminder>();
	}
	
	public int addCourse(Course course){
		course.setId(courses.size());
		courses.add(course);
		return course.getId();
	}
	
	public void dropCourse(int id){
		courses.remove(id);
		for (int i = 0; i < courses.size(); i++){
			courses.get(i).setId(i);
		}
	}
	
	public void modifyCourse(int id, Course course){
		course.setId(id);
		courses.set(id, course);
	}
	
	public ArrayList<Course> getCourses(){
		ArrayList<Course> courselist = new ArrayList<Course>();
		for(Course course : courses)
			courselist.add(course);
		return courselist;
	}
	
	public Course findCourseByID(int id){
		return courses.get(id);
	}
	
	public int addReminder(Reminder reminder){
		reminder.setId(reminders.size());
		reminders.add(reminder);
		return reminder.getId();
	}
	
	public void modifyReminder(int id, Reminder reminder){
		reminder.setId(id);
		reminders.set(id, reminder);
	}
	
	public Reminder findReminderByID(int id){
		return reminders.get(id);
	}
	
	public void markReminderComplete(int id){
		reminders.get(id).setComplete();
		reminders.remove(id);
		for (int i = 0; i < reminders.size(); i++){
			reminders.get(i).setId(i);
		}
	}
	
	public ArrayList<Reminder> getActiveReminders(){
		ArrayList<Reminder> active = new ArrayList<Reminder>();
		for (Reminder reminder : reminders){
			if (!reminder.isComplete()){
				active.add(reminder);
			}
		}
		return active;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
}
