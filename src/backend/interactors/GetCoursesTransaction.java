package backend.interactors;

import java.util.ArrayList;

import backend.entities.Course;
import backend.entities.Rereminder;
import backend.entities.User;

public class GetCoursesTransaction {

	private User user;
	
	public GetCoursesTransaction(String username){
		this.user = Rereminder.getInstance().findUserByName(username);
	}
	
	public ArrayList<String> completeTransaction(){
		ArrayList<String> courses = new ArrayList<String>();
		for (Course course : user.getCourses()){
			courses.add(course.getName());
		}
		return courses;
	}
}
