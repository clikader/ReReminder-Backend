package backend.interactors;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;

public class ModifyCourseTransaction {

	private User user;
	private int id;
	private Course modifiedCourse;
	
	public ModifyCourseTransaction(String username, int id, Course modifiedCourse){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.id = id;
		this.modifiedCourse = modifiedCourse;
	}
	
	public void completeTransaction(){
		user.modifyCourse(id, modifiedCourse);
	}
}
