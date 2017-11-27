package scheduling;
import java.io.FileNotFoundException;
import java.util.*;
import ioSystem.*;

public class ScheduleManager {
	
	//----Singleton Creation----
	private ScheduleManager() {
		
		SysIO<Schedule> sysIO = new SysIO<Schedule>(new IOSchedule());
		schedule = sysIO.load();
		
		if(schedule == null)
			schedule = new Vector<Schedule>();
	}
	private volatile static ScheduleManager uniqueInstance;
	public static ScheduleManager getInstance(){
		if(uniqueInstance == null){
			synchronized (ScheduleManager.class){
				if(uniqueInstance == null){
					uniqueInstance = new ScheduleManager();
				}
			}
		}
		return uniqueInstance;
	}
	//----END----
	
	private Vector<Schedule> schedule;
	
	public static void createSchedule(Vector<TimeSlot> slots, Semesters se){
		
		Schedule newSch = new Schedule(slots, se);
		getInstance().addSchedule(newSch);
	}
	
	public static Vector<Schedule> getSchedule()
	{
		return getInstance().schedule;
	}
	
	public static List<String> getLocationsInSchedule(Schedule schedule){
		
		List<String> locations = new ArrayList<String>();
		
		for(TimeSlot slot : schedule.getTimeSlots()){
			
			String loc = slot.getLocation().toString();
			if(!locations.contains(loc)){
				locations.add(loc);
			}
		}
		
		return locations;
	}
	
	public static String[][] getStartTimesInSchedule(Schedule schedule){
		
		List<String> startTimes = new ArrayList<String>();
		List<String> endTimes = new ArrayList<String>();
		
		for(TimeSlot slot : schedule.getTimeSlots()){
			
			startTimes.add(Integer.toString(slot.getStartTime()));
			endTimes.add(Integer.toString(slot.getEndTime()));
		}
		
		String[][] times = new String[startTimes.size()][2];
		
		for(int i = 0; i < startTimes.size(); i++){
			
			times[i][0] = startTimes.get(i);
			times[i][1] = endTimes.get(i);
		}
		
		return times;
	}
	
	private void saveSchedule()
	{
		SysIO<Schedule> scheduleIO = new SysIO<Schedule>(new IOSchedule());
		try {
			scheduleIO.save(getInstance().schedule);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	private void addSchedule(Schedule schedule)
	{
		getInstance().schedule.addElement(schedule);
		saveSchedule();
	}
}

