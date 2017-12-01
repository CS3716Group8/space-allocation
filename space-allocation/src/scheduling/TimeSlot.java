/*
 *	Defines the TimeSlot data structure
 *	@author Ling Xu, Alex Gillis
*/

package scheduling;

import java.util.UUID;

public class TimeSlot {
	
	private String id;
	private int startTime;
	private int endTime;
	private WeekDays day;
	private Location location;
	
	public TimeSlot(int sTime, int eTime, WeekDays d, Location loc)
	{
		startTime = sTime;
		endTime = eTime;
		day = d;
		location = loc;
		this.id = UUID.randomUUID().toString();
	}
	
	public TimeSlot(int sTime, int eTime, WeekDays d, Location loc, String i)
	{
		startTime = sTime;
		endTime = eTime;
		day = d;
		location = loc;
		this.id = i;
	}
	
	public String getId() { return id; }
	
	public int getStartTime() { return startTime; }
	public int getEndTime() { return endTime; }
	public WeekDays getDay() { return day; }
	public Location getLocation() { return location; }
	
	public String toString(){
		return id + " " + Integer.toString(startTime) + " " + Integer.toString(endTime) + " " + day.name() + " " + location.name() + " ";
	}
}
