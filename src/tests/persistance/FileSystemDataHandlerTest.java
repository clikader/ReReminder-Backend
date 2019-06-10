package tests.persistance;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.entities.User;
import backend.exceptions.ParseJsonUserInfoException;
import backend.persistance.FileSystemDataHandler;

public class FileSystemDataHandlerTest {

	FileSystemDataHandler fsdh = new FileSystemDataHandler();
	
	@BeforeClass
	public static void copyMockData() throws IOException{
		FileUtils.copyFile(new File("MockData/tony.JSON"), new File("users/tony.JSON"));
		FileUtils.copyFile(new File("MockData/li.JSON"), new File("users/li.JSON"));
	}
	
	@Test
	public void SaveUser_Creates_User_File(){
		User user = new User("bob", "test@test.com", "password");
		fsdh.saveUser(user);
		assertEquals(true, Files.exists(FileSystems.getDefault().getPath("users/bob.JSON")));
	}
	
	@Test
	public void LoadUser_Loads_Correct_Data(){
		User user = fsdh.loadUser("tony");
		assertEquals("tony", user.getUsername());
		assertEquals("tony@test.com", user.getEmail());
		assertEquals("password", user.getPassword());
		assertEquals("tony", user.getUsername());
	}
	
	@Test (expected=ParseJsonUserInfoException.class)
	public void LoadUser_Fails_With_Bad_JSON(){
		User user = fsdh.loadUser("li");
	}
	
	@Test (expected=ParseJsonUserInfoException.class)
	public void LoadUser_Fails_When_File_Does_Not_Exist(){
		User user = fsdh.loadUser("joe");
	}
	
	@AfterClass
	public static void cleanUserDirectory() throws IOException{
		FileUtils.cleanDirectory(new File("users"));
	}
}
