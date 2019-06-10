package backend.interactors;

import backend.entities.User;
import backend.entities.Reminder;
import backend.entities.Rereminder;

public class ModifyReminderTransaction {
	private User user;
	private int id;
	private Reminder modifiedReminder;
	
	public ModifyReminderTransaction(String username, int id, Reminder modifiedReminder){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.id = id;
		this.modifiedReminder = modifiedReminder;
	}
	
	public void completeTransaction(){
		user.modifyReminder(id, modifiedReminder);
	}
}
