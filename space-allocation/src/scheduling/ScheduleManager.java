package scheduling;
import java.io.FileNotFoundException;
import java.util.Vector;
import ioSystem.*;
import spaceRequests.RequestManager;
import spaceRequests.SpaceRequest;

public class ScheduleManager {
	
	//----Singleton Creation----
	private ScheduleManager() {
		
		SysIO<Schedule> sysIO = new SysIO<Schedule>(new IOSchedule());
		scheduleVec = sysIO.load();
		
		if(scheduleVec == null)
			scheduleVec = new Vector<Schedule>();
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
	
	private Vector<Schedule> scheduleVec;
	
	public static void addSchedule(Schedule schedule)
	{
		getInstance().scheduleVec.addElement(schedule);
		saveSchedule();
	}
	
	public static Vector<Schedule> getScheduleVec()
	{
		return getInstance().scheduleVec;
	}
	
	public static void saveSchedule()
	{
		SysIO<Schedule> scheduleIO = new SysIO<Schedule>(new IOSchedule());
		try {
			scheduleIO.save(getInstance().scheduleVec);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
//	public static void saveSchedule(Vector<Schedule> scheduleVec)
//	{
//		SysIO<Schedule> scheduleIO = new SysIO<Schedule>(new IOSchedule());
//		try {
//			scheduleIO.save(getInstance().scheduleVec);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}		
//	}
	
	public static void loadSchedule()
	{
		SysIO<Schedule> scheduleIO = new SysIO<Schedule>(new IOSchedule());
		
		Vector<Schedule> tempSchedules = scheduleIO.load();
		
		if((tempSchedules.size() > 0)){
			getInstance().scheduleVec = tempSchedules;
		}
	}
	
	public static TimeSlot getTimeSlotWithId(String id){
		
		TimeSlot targetSlot = null;
		
		for(Schedule schedule : getInstance().scheduleVec){
			
			Vector<Vector<TimeSlot>> allSlots = schedule.getTimeSlotVec();
			
			for(Vector<TimeSlot> slots : allSlots){
				
				for(TimeSlot slot : slots){ 
					
					if(slot.getId().equals(id)){
						targetSlot = slot;
						break;
					}
				}
			}
		}
		
		return targetSlot;
	}
	
	public static Location getLocationOfSlot(TimeSlot slot){
		
		Location targetLocation = null;
		
		for(Schedule schedule : getInstance().scheduleVec){
			
			Vector<Location> allLocs = schedule.getLocationVec();
			
			for(Location loc : allLocs){
				
				Vector<TimeSlot> slotsAtLoc = schedule.getHM().get(loc);
				
				for(TimeSlot tempSlot : slotsAtLoc){
					
					if(tempSlot.getId().equals(slot.getId())){
						targetLocation = loc;
						break;
					}
				}
			}
		}
		
		return targetLocation;
	}
}

