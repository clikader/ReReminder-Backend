package backend.interactors;

import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;

public class AddReminderTransaction {
	private User user;
	private Reminder reminder;
	
	public AddReminderTransaction(String username, Reminder reminder){
		this.user = Rereminder.getInstance().findUserByName(username);
		this.reminder = reminder;
	}
	
	public int completeTransaction(){
		return user.addReminder(reminder);
	}
}
