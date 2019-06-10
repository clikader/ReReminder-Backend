package backend.persistance;

import backend.entities.User;

public interface DataHandler {

	public void saveUser(User user);
	public User loadUser(String username);
	
}
