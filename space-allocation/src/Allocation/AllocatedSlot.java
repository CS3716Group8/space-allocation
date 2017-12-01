package Allocation;
import scheduling.*;

public class AllocatedSlot 
{
	private String requestorName; 
	private Location location;
	private int startTime, endTime;
	private Semesters semester;
	
	public AllocatedSlot(String requestorName, Location location,
			Semesters semester, int startTime, int endTime)
	{
		this.requestorName = requestorName;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.semester = semester;
	}
	
	public String getRequestorName(){ return requestorName; };
	public Location getLocation(){ return location; };
	public Semesters getSemester(){ return semester; };
	public int getStartTime(){ return startTime; };
	public int getEndTime(){ return endTime; };

	public String toString()
	{
		String str = "";
		
		str += semester.name() + " ";
		str += requestorName + " " + location + " " + startTime + " " + endTime + "\n";
		return str;
	}
}
