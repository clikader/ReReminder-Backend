package tests.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import backend.entities.Notification;

public class NotificationTest {

	@Test
	public void Title_Is_Set_Properly(){
		Notification notification = new Notification("title", "subtitle", "13:00");
		assertEquals("title", notification.getTitle());
	}
	
	@Test
	public void Subtitle_Is_Set_Properly(){
		Notification notification = new Notification("title", "subtitle", "13:00");
		assertEquals("subtitle", notification.getSubtitle());
	}
	
	@Test
	public void Time_Is_Set_Properly(){
		Notification notification = new Notification("title", "subtitle", "13:00");
		assertEquals("13:00", notification.getTime());
	}

}
