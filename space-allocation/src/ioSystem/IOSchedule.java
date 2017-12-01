/*
 *	Concrete Implementation of IOMethod
 *	Handles saving and loading of Schedule data
 *	@author Alex Gillis
*/
package ioSystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import scheduling.*;
import java.util.*;

public class IOSchedule extends IOMethod<Schedule> {

	private static final String FILENAME = "src/data/schedules";

	public void save(List<Schedule> data) throws FileNotFoundException{
		
		PrintWriter pw = new PrintWriter(new FileOutputStream(FILENAME));
		
		for(Schedule schedule : data){
			pw.println(schedule.toString());
		}
		pw.close();
	}
	
	public Vector<Schedule> load(){
		
		List<String> dataStrs = super.getStringsFromFile(FILENAME);
		Vector<Schedule> schedules = loadScheduleFromStrings(dataStrs);
		
		if(schedules == null){
			schedules = new Vector<Schedule>();
		}
		
		return schedules;
	}
	
	public Vector<Schedule> loadScheduleFromStrings(List<String> dataStrs){
		
		Vector<Schedule> loadedSchedules = null;
		
		if(dataStrs != null){
			
			loadedSchedules = new Vector<Schedule>();
			
			Vector<TimeSlot> allSlots = null;
			for(String line : dataStrs){
				if(!line.equals("")){
					
					String[] splitLine = line.split(" ");
					
					Semesters semester = Semesters.valueOf(splitLine[0]);
					
					allSlots = createTimeSlots(splitLine);
					
					Schedule newSchedule = new Schedule(allSlots, semester);
					loadedSchedules.add(newSchedule);
				}
			}
			
		//	loadedSchedule = new Schedule(locations, allSlots);
		}
		else{
			System.out.println("IOSchedule.java: 63 : No Data in Schedule File.");
		}
		
		return loadedSchedules;
	}
	
	private Vector<TimeSlot> createTimeSlots(String[] lineArray){
		
		Vector<TimeSlot> slots = new Vector<TimeSlot>();
		
		String id = null;
		Location loc = null;
		int startTime = -1;
		int endTime = -1;
		WeekDays day = null;
		
		if(!(lineArray.length < 2)){
			
			for(int i = 1; i < lineArray.length; i+=5){
				
				id = lineArray[i];
				startTime = Integer.parseInt(lineArray[i+1]);
				endTime = Integer.parseInt(lineArray[i+2]);
				day = WeekDays.valueOf(lineArray[i+3]);
				loc = Location.valueOf(lineArray[i+4]);
				
				TimeSlot slot = new TimeSlot(startTime, endTime, day, loc, id);
				slots.add(slot);
			}
		}
		return slots;
	}
//	
//	private Location createLocation(String name, String roomNum){
//		Location loc = new Location(name, roomNum);
//		return loc;
//	}
}
