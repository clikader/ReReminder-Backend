package backend.interactors;

import backend.entities.Reminder;

public class DropReminderTransaction {
	private String username;
	private Reminder reminder;
	
	public DropReminderTransaction(String username, Reminder reminder){
		this.username = username;
		this.reminder = reminder;
		reminder.setComplete();
	}
	
	public String getUsername(){
		return username;
	}
	
	public Reminder getReminder(){
		return reminder;
	}
	
	public void completeTransaction(){
		//STUB
	}
}
