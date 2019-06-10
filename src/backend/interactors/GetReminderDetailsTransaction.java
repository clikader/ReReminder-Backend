package backend.interactors;

import backend.entities.User;
import backend.entities.Reminder;
import backend.entities.Rereminder;

public class GetReminderDetailsTransaction {
	private User user;
	private int id;
	
	public GetReminderDetailsTransaction(String username, int id){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.id = id;
	}
	
	public Reminder completeTransaction(){
		return user.findReminderByID(id);
	}
}
