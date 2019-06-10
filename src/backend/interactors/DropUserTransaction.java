package backend.interactors;

import backend.entities.User;

public class DropUserTransaction {
	private User user;
	
	public DropUserTransaction(User createUser){
		this.user = createUser;
	}
	
	public User getUser(){
		return user;
	}
	
	public void completeTransaction(){
		//STUB
	}
}
