package backend.interactors;

import backend.entities.Rereminder;
import backend.entities.User;

public class CompleteReminderTransaction {

	private User user;
	private int id;
	
	public CompleteReminderTransaction(String username, int id){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.id = id;
	}
	
	public void completeTransaction(){
		user.markReminderComplete(id);
	}
}
