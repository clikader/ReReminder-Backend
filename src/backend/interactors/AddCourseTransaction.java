package backend.interactors;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;

public class AddCourseTransaction {

	private Course course;
	private User user;
	
	public AddCourseTransaction(String username, Course course){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.course = course;
	}
	
	public int completeTransaction(){
		return user.addCourse(course);
	}
}
