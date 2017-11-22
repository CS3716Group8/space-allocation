package scheduling;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class Schedule {
	private Vector<Location> locationVec;
	private Vector<Vector<TimeSlot>> timeSlotVec;
	private HashMap<Location, Vector<TimeSlot>> hm;
	
	public Schedule(Vector<Location> locationVec, Vector<Vector<TimeSlot>> timeSlotVec)
	{
		this.locationVec = locationVec;
		this.timeSlotVec = timeSlotVec;
		Iterator<Location> locationVecIt = locationVec.iterator();
		Iterator<Vector<TimeSlot>> timeSlotVecIt = timeSlotVec.iterator();
		hm = new HashMap<Location, Vector<TimeSlot>>();
		
		while (locationVecIt.hasNext() && timeSlotVecIt.hasNext())
		{
			hm.put(locationVecIt.next(), timeSlotVecIt.next());
		}
	}
	
	public Vector<Location> getLocationVec()
	{
		return locationVec;
	}
	
	public Vector<Vector<TimeSlot>> getTimeSlotVec()
	{
		return timeSlotVec;
	}
	
	public HashMap<Location, Vector<TimeSlot>> getHM()
	{
		return hm;
	}
	
	//could potentially be useful for our UI
	//output the entire schedule
	public String toString()
	{
		String newStr = "";
		for (HashMap.Entry<Location, Vector<TimeSlot>> e : hm.entrySet())
		{
			Location loc = e.getKey();
			newStr += loc.toString();
			
			Vector<TimeSlot> slots = e.getValue();
			for(TimeSlot s : slots){
				newStr += s.toString();
			}
			newStr += "\n";
		}
		
		return newStr;
	}
}
