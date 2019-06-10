package backend.persistance;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.entities.User;
import backend.exceptions.ParseJsonUserInfoException;
import backend.exceptions.SaveUserException;

public class FileSystemDataHandler implements DataHandler {

	@Override
	public void saveUser(User user) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("users/"+user.getUsername()+".JSON"), user);
		} catch (IOException e) {
			throw new SaveUserException();
		}
	}

	@Override
	public User loadUser(String username) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File("users/"+username+".JSON"), User.class);
		} catch (IOException e) {
			throw new ParseJsonUserInfoException();
		}
	}

}
