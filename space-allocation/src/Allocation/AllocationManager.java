package Allocation;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import ioSystem.*;
import scheduling.*;

public class AllocationManager 
{	
	//----Singleton Creation----
	private AllocationManager() 
	{		
		SysIO<AllocatedSlot> sysIO = new SysIO<AllocatedSlot>(new IOAllocatedSlot());
		allocatedSlots = sysIO.load();
		
		if(allocatedSlots == null)
			allocatedSlots = new Vector<AllocatedSlot>();
	}
	
	private volatile static AllocationManager uniqueInstance;
	public static AllocationManager getInstance()
	{
		if(uniqueInstance == null){
			synchronized (AllocationManager.class){
				if(uniqueInstance == null){
					uniqueInstance = new AllocationManager();
				}
			}
		}
		return uniqueInstance;
	}
	//----END----
	
	private Vector<AllocatedSlot> allocatedSlots;
	
	public static void createAllocatedSlot(String requestorName, Location location,
			Semesters semester, int startTime, int endTime)
	{
		
		AllocatedSlot newSlot = new AllocatedSlot(requestorName, location, semester, startTime, endTime);
		getInstance().addAllocatedSlot(newSlot);
	}
	
	public static Vector<AllocatedSlot> getAllocatedSlots()
	{
		return getInstance().allocatedSlots;
	}
	
	private void addAllocatedSlot(AllocatedSlot allocatedSlot)
	{
		getInstance().allocatedSlots.addElement(allocatedSlot);
		saveAllocatedSlots();
	}
	
	private void saveAllocatedSlots()
	{
		SysIO<AllocatedSlot> allocatedSlotIO = new SysIO<AllocatedSlot>(new IOAllocatedSlot());
		try {
			allocatedSlotIO.save(getInstance().allocatedSlots);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static List<Semesters> getSemesters()
	{
		List<Semesters> semesters = new ArrayList<Semesters>();		
		for(AllocatedSlot slot : getInstance().allocatedSlots)
		{
			Semesters semester = slot.getSemester();			
			if(!semesters.contains(semester))
			{
				semesters.add(semester);
			}
		}		
		return semesters;
	}
	
	public static List<Location> getLocations()
	{		
		List<Location> locations = new ArrayList<Location>();		
		for(AllocatedSlot slot : getInstance().allocatedSlots)
		{			
			Location loc = slot.getLocation();
			if(!locations.contains(loc))
			{
				locations.add(loc);
			}
		}
		
		return locations;
	}
	
	//get all the locations from a certain semester
	public static List<Location> getLocationsFromSemester(Semesters se)
	{
		List<Location> locations = new ArrayList<Location>();
		for(AllocatedSlot slot : getInstance().allocatedSlots)
		{
			Location loc = slot.getLocation();
			if(slot.getSemester().equals(se) && !locations.contains(loc))
			{
				locations.add(loc);
			}			
		}
		return locations;
	}
	
	//get all the requestor names from a certain location and a certain semester
	public static List<String> getNamesFromLocationAndSemester(Semesters se, Location loc)
	{
		List<String> names = new ArrayList<String>();
		for(AllocatedSlot slot : getInstance().allocatedSlots)
		{
			String name = slot.getRequestorName();
			if(slot.getSemester().equals(se) && slot.getLocation().equals(loc) 
					&& !names.contains(name) )
			{
				names.add(name);
			}
		}		
		return names; 
	}
	
	//get all the Times from a certain Location and a certain semester
	public static String[][] getTimesFromLocationAndSemester(Semesters se, Location loc)
	{
		
		List<String> startTimes = new ArrayList<String>();
		List<String> endTimes = new ArrayList<String>();
		
		for(AllocatedSlot slot : getInstance().allocatedSlots){
			
			if(slot.getSemester().equals(se) && slot.getLocation().equals(loc))
			{
				startTimes.add(Integer.toString(slot.getStartTime()));
				endTimes.add(Integer.toString(slot.getEndTime()));
			}			
		}
		
		String[][] times = new String[startTimes.size()][2];
		
		for(int i = 0; i < startTimes.size(); i++){
			
			times[i][0] = startTimes.get(i);
			times[i][1] = endTimes.get(i);
		}		
		return times;
	}	
}
