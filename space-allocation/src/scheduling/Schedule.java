package scheduling;
import java.util.Vector;

public class Schedule {
	
	private Vector<TimeSlot> timeSlots;
	private Semesters semester;
	
	public Schedule(Vector<TimeSlot> slots, Semesters se)
	{
		semester = se;
		timeSlots = slots;
	}
	
	public Semesters getSemester() { return semester; }
	public Vector<TimeSlot> getTimeSlots()
	{
		return timeSlots;
	}
	
	//could potentially be useful for our UI
	//output the entire schedule
	public String toString()
	{
		String str = "";
		
		str = semester.name() + " ";
		
		for(TimeSlot ts : timeSlots){
			str += ts.toString();
		}
		return str;
	}
}
