package backend.interactors;

import backend.entities.Rereminder;
import backend.entities.User;

public class DropCourseTransaction {

	private int course;
	private User user;
	
	public DropCourseTransaction(String username, int course){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.course = course;
	}
	
	public void completeTransaction(){
		user.dropCourse(course);
	}

}
