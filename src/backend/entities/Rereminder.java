package backend.entities;

import java.util.ArrayList;

import backend.exceptions.UserNotFoundException;

public class Rereminder {

	private static ArrayList<User> users;
	private static Rereminder instance;
	
	private Rereminder(){
		users = new ArrayList<User>();
	}
	
	public static Rereminder getInstance(){
		if (instance == null){
			instance = new Rereminder();
		}
		return instance;
	}
	
	public void createUser(User user){
		users.add(user);
	}
	
	public User findUserByName(String name){
		for (User user : users){
			if (user.getUsername().equals(name)){
				return user;
			}
		}
		throw new UserNotFoundException();
	}
	
	public void modifyUser(User user){
		for (int i = 0; i < users.size(); i++){
			if (user.getUsername().equals(users.get(i).getUsername())){
				users.set(i, user);
			}
		}
	}
}
