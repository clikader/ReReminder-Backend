package backend.interactors;

//import java.util.Date;

import org.springframework.cache.annotation.Cacheable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import backend.entities.Rereminder;
import backend.entities.User;

public class CreateUserTransaction {

	private String username;
	private String emailAddress;
	private String password;
	
	@JsonCreator
	public CreateUserTransaction(@JsonProperty("username") String username, @JsonProperty("emailAdress") String emailAddress, 
								 @JsonProperty("password") String password){
		this.username = username;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	@Cacheable("userid")
	public User completeTransaction(){
		User newUser = new User(username, emailAddress, password);
		Rereminder.getInstance().createUser(newUser);
		return newUser;
	}
	
	
}
