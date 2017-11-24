package scheduling;
import java.io.FileNotFoundException;
import java.util.Vector;
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

