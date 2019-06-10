package backend.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {

	private String name;
	private String startTime, endTime;
	private ArrayList<String> days;
	private int id;

	@JsonCreator
	public Course(@JsonProperty("name") String name, @JsonProperty("startTime") String startTime, 
				  @JsonProperty("endTime") String endTime, @JsonProperty("days") ArrayList<String> days){
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.days = days;
		this.id = -1;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}

	public String getName() {
		return name;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public ArrayList<String> getDays() {
		return new ArrayList<String>(days);
	}
	
	public boolean isOnDay(String day){
		for (String d : days){
			if (d.equalsIgnoreCase(day)) return true;
		}
		return false;
	}
}
