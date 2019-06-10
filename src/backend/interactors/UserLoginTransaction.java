package backend.interactors;

import backend.entities.User;
import backend.exceptions.UserNotFoundException;
import backend.persistance.DataHandler;

public class UserLoginTransaction {

	private String username, password;
	
	public UserLoginTransaction(){
		
	}
	
	public UserLoginTransaction(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public User completeTransaction(DataHandler dataHandler){
		try{
			return dataHandler.loadUser(username);
		} catch (RuntimeException e){
			throw new UserNotFoundException();
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
