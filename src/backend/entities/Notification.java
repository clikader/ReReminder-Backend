package backend.entities;

public class Notification {

	private String title, subtitle;
	private String time;
	
	public Notification(String title, String subtitle, String time){
		this.title = title;
		this.subtitle = subtitle;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getTime() {
		return time;
	}
	
	
}
