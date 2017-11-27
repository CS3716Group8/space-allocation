package testing;

import scheduling.*;
import java.io.FileNotFoundException;
import java.util.*;

import ioSystem.*;
import scheduling.Schedule;
import spaceRequests.RequestManager;
import spaceRequests.SpaceRequest;

public class ioTesting {

	public static void main(String[] args) {
		
		TimeSlot s1 = new TimeSlot(9,12, WeekDays.Monday , Location.Dance);
		TimeSlot s2 = new TimeSlot(14,16, WeekDays.Tuesday, Location.Dance);
		
		Vector<TimeSlot> winterSlots = new Vector<TimeSlot>();
		winterSlots.add(s1);
		winterSlots.add(s2);
		
		//---Creating and Saving a schedule----
		ScheduleManager.createSchedule(winterSlots, Semesters.Winter);
		//---END---
		
		//---Retreiving a schedule----
		Vector<Schedule> schedules = ScheduleManager.getSchedule();
		//---END---
		
		//---Retreiving all the requests---
		Vector<SpaceRequest> requests = RequestManager.getRequests();
		//---END---
		
		//---Creating a request---
		RequestManager.createRequest(s1,"Tod", s1.getStartTime(), s1.getEndTime() - 1);
		//---END---
		
		//---Get All Locations In a Semester---
		List<String> locations = ScheduleManager.getLocationsInSchedule(ScheduleManager.getSchedule().get(0));
		//---END---
		
		//---Get Time Ranges In a Semester---
		String[][] times = ScheduleManager.getStartTimesInSchedule(ScheduleManager.getSchedule().get(0));
		//---END---
		
		int wait = 0;
	}
}
