package backend.boundaries;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.entities.Course;
import backend.entities.Notification;
import backend.entities.Reminder;
import backend.entities.User;
import backend.interactors.AddCourseTransaction;
import backend.interactors.AddReminderTransaction;
import backend.interactors.CompleteReminderTransaction;
import backend.interactors.CreateUserTransaction;
import backend.interactors.DropCourseTransaction;
import backend.interactors.GetCourseDetailsTransaction;
import backend.interactors.GetCoursesTransaction;
import backend.interactors.GetNotificationsTransaction;
import backend.interactors.GetReminderDetailsTransaction;
import backend.interactors.GetRemindersTransaction;
import backend.interactors.ModifyCourseTransaction;
import backend.interactors.ModifyReminderTransaction;
import backend.interactors.UserLoginTransaction;

@RestController
public class UserController {
	
	/* USERS */
	@RequestMapping(value = "/users", method = RequestMethod.PUT, produces = "application/json")
	public String createUser(@RequestBody CreateUserTransaction transaction){
		User newUser = transaction.completeTransaction();
		return "/users/"+newUser.getUsername();
	}
	
	@RequestMapping(value = "/users/login", method = RequestMethod.GET, produces = "application/json")
	public String userLogin(@RequestBody UserLoginTransaction transaction){
		return null;
	}
	
	/* Courses */
	@RequestMapping(value = "/users/{username}/courses", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<String> getCoursesForUser(@PathVariable("username") String username){
		GetCoursesTransaction transaction = new GetCoursesTransaction(username);
		return transaction.completeTransaction();
	}
	
	@RequestMapping(value = "/users/{username}/courses", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addCourseForUser(@PathVariable("username") String username,
												   @RequestBody Course course){
		AddCourseTransaction transaction = new AddCourseTransaction(username, course);
		int courseId = transaction.completeTransaction();
		return "/users/"+username+"/courses/"+courseId;
	}
	
	@RequestMapping(value = "/users/{username}/courses/{courseid}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Course getCourseDetails(@PathVariable("username") String username,
										  @PathVariable("courseid") int course){
		GetCourseDetailsTransaction transaction = new GetCourseDetailsTransaction(username, course);
		return transaction.completeTransaction();
	}
	
	@RequestMapping(value = "/users/{username}/courses/{courseid}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> modifyCourseForUser(@PathVariable("username") String username,
													  @PathVariable("courseid") int course,
													  @RequestBody Course modifiedCourse){
		ModifyCourseTransaction transaction = new ModifyCourseTransaction(username, course, modifiedCourse);
		transaction.completeTransaction();
		return new ResponseEntity<String>("Modified Course", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{username}/courses/{courseid}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> dropCourseForUser(@PathVariable("username") String username,
													@PathVariable("courseid") int courseId){
		DropCourseTransaction transaction = new DropCourseTransaction(username, courseId);
		transaction.completeTransaction();
		return new ResponseEntity<String>("Dropped Course", HttpStatus.OK);
	}
	
	/* Reminders */
	@RequestMapping(value = "/users/{username}/reminders", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<String> getActiveRemindersForUser(@PathVariable("username") String username){
		GetRemindersTransaction transaction = new GetRemindersTransaction(username);
		return transaction.completeTransaction();
	}
	
	@RequestMapping(value = "/users/{username}/reminders", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String addReminderForUser(@PathVariable("username") String username,
									 @RequestBody Reminder reminder){
		AddReminderTransaction transaction = new AddReminderTransaction(username, reminder);
		int reminderid = transaction.completeTransaction();
		return "/users/"+username+"/reminders/"+reminderid;
	}
	
	@RequestMapping(value = "/users/{username}/reminders/{reminderid}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Reminder getReminderDetailsForUser(@PathVariable("username") String username,
											  @PathVariable("reminderid") int reminderId){
		GetReminderDetailsTransaction transaction = new GetReminderDetailsTransaction(username, reminderId);
		return transaction.completeTransaction();
	}
	
	@RequestMapping(value = "/users/{username}/reminders/{reminderid}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> modifyReminderForUser(@PathVariable("username") String username,
														@PathVariable("reminderid") int reminderId,
														@RequestBody Reminder modifiedReminder){
		ModifyReminderTransaction transaction = new ModifyReminderTransaction(username, reminderId, modifiedReminder);
		transaction.completeTransaction();
		return new ResponseEntity<String>("Modified Reminder", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{username}/reminders/{reminderid}", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> markReminderCompleteForUser(@PathVariable("username") String username,
			 												  @PathVariable("reminderid") int reminderId){
		CompleteReminderTransaction transaction = new CompleteReminderTransaction(username, reminderId);
		transaction.completeTransaction();
		return new ResponseEntity<String>("Marked Reminder Complete", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{username}/notifications", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Notification> getNotificationsForUser(@PathVariable("username") String username,
														   @RequestBody String date){
		GetNotificationsTransaction transaction = new GetNotificationsTransaction(username, date);
		return transaction.completeTransaction();
	}
}
