package backend.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Reminder {

	private String content, course;
	private String date, time;
	private int id;
	private boolean complete;
	
	@JsonCreator
	public Reminder(@JsonProperty("content") String content, @JsonProperty("Course") String course, 
				 	@JsonProperty("date") String date, @JsonProperty("time") String time){
		this.content = content;
		this.course = course;
		this.date = date;
		this.time = time;
		this.id = -1;
		this.complete = false;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public String getCourse() {
		return course;
	}

	public String getDate() {
		return date;
	}
	
	public void setComplete(){
		this.complete = true;
	}

	public boolean isComplete(){
		return this.complete;
	}
	
	public int getId(){
		return this.id;
	}

	public String getTime() {
		return time;
	}
	
	
}
