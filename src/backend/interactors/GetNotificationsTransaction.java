package backend.interactors;

import java.time.LocalDate;
import java.util.ArrayList;

import backend.entities.Course;
import backend.entities.Notification;
import backend.entities.Reminder;
import backend.entities.Rereminder;
import backend.entities.User;

public class GetNotificationsTransaction {

	private User user;
	private String date;
	private String day;
	
	public GetNotificationsTransaction(String username, String date){
		user = Rereminder.getInstance().findUserByName(username);
		this.date = date;
		day = parseDate(date).getDayOfWeek().name();
	}
	
	private LocalDate parseDate(String date){
		String[] dateString = date.split("-");
		return LocalDate.of(Integer.parseInt(removeQuotes(dateString[0])), 
							Integer.parseInt(removeQuotes(dateString[1])), 
							Integer.parseInt(removeQuotes(dateString[2])));
	}
	
	public ArrayList<Notification> completeTransaction(){
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		
		notifications.addAll(courseNotifications());
		notifications.addAll(reminderNotifications());
		
		return notifications;
	}
	
	private ArrayList<Notification> courseNotifications(){
		ArrayList<Notification> courses = new ArrayList<Notification>();
		for (Course course : user.getCourses()){
			if (course.isOnDay(day)) 
				courses.add(new Notification(course.getName()+" just ended", "Any new reminders?", course.getEndTime()));
		}
		return courses;
	}
	
	private ArrayList<Notification> reminderNotifications(){
		ArrayList<Notification> reminders = new ArrayList<Notification>();
		for (Reminder reminder : user.getActiveReminders()){
			if (dueSoon(reminder)) reminders.add(new Notification(reminder.getContent()+" for "+reminder.getCourse(), "Due soon", reminder.getTime()));
		}
		return reminders;
	}
	
	private boolean dueSoon(Reminder reminder){
		String[] currentDate = date.split("-");
		String[] dueDate = reminder.getDate().split("-");
		
		if (Integer.parseInt(removeQuotes(currentDate[0])) == Integer.parseInt(removeQuotes(dueDate[0])) && 
			Integer.parseInt(removeQuotes(currentDate[1])) == Integer.parseInt(removeQuotes(dueDate[1])) &&
			Math.abs(Integer.parseInt(removeQuotes(currentDate[2])) - Integer.parseInt(removeQuotes(dueDate[2]))) < 2)
			return true;
		else return false;
	}
	
	private String removeQuotes(String str){
		return str.replace("\"", "");
	}
}
