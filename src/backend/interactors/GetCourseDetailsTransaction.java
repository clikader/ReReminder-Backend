package backend.interactors;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;

public class GetCourseDetailsTransaction {

	private User user;
	private int id;
	
	public GetCourseDetailsTransaction(String username, int id){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.id = id;
	}
	
	public Course completeTransaction(){
		return user.findCourseByID(id);
	}
}
