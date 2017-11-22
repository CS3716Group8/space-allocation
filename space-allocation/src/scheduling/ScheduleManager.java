package scheduling;
import java.io.FileNotFoundException;
import java.util.Vector;
import ioSystem.*;

public class ScheduleManager {
	private Vector<Schedule> scheduleVec;
	
	public ScheduleManager(Schedule schedule)
	{
		scheduleVec = new Vector<Schedule>();
		scheduleVec.addElement(schedule);
	}
	
	public Vector<Schedule> getScheduleVec()
	{
		return scheduleVec;
	}
	
	public void addToScheduleVec(Schedule schedule)
	{
		scheduleVec.addElement(schedule);
	}	
	
	public void saveScheduleVec(Vector<Schedule> scheduleVec)
	{
		SysIO<Schedule> scheduleIO = new SysIO<Schedule>(new IOSchedule());
		try {
			scheduleIO.save(scheduleVec);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void loadScheduleVec()
	{
		SysIO<Schedule> scheduleIO = new SysIO<Schedule>(new IOSchedule());
		scheduleIO.load();
	}


}

