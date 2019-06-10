package backend.interactors;

import java.util.ArrayList;

import backend.entities.User;
import backend.entities.Reminder;
import backend.entities.Rereminder;

public class GetRemindersTransaction {
	private User user;
	
	public GetRemindersTransaction(String username){
		this.user = Rereminder.getInstance().findUserByName(username);
	}
	
	public ArrayList<String> completeTransaction(){
		ArrayList<String> reminders = new ArrayList<String>();
		for(Reminder reminder : user.getActiveReminders())
			reminders.add(reminder.getContent());
		return reminders;
	}
}
