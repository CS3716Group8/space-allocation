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
		Vector<Schedule> data = new Vector<Schedule>();;

		List<String> dataStrs = super.getStringsFromFile(FILENAME);
		Schedule newSchedule = loadScheduleFromStrings(dataStrs);
		
		if(newSchedule != null){
			data.add(newSchedule);
		}
		
		return data;
	}
	
	public Schedule loadScheduleFromStrings(List<String> dataStrs){
		
		Schedule loadedSchedule = null;
		if(dataStrs != null){
			
			Vector<Vector<TimeSlot>> allSlots = new Vector<Vector<TimeSlot>>();
			Vector<Location> locations = new Vector<Location>();
			for(String line : dataStrs){
				if(!line.equals("")){
					
					String[] splitLine = line.split(" ");
				
					Location location = createLocation(splitLine[0], splitLine[1]);
					Vector<TimeSlot> timeSlots = createTimeSlots(splitLine);
					locations.add(location);
					allSlots.add(timeSlots);
				}
			}
			
			loadedSchedule = new Schedule(locations, allSlots);
		}
		else{
			System.out.println("ERROR: Could not create Schedule.");
		}
		
		return loadedSchedule;
	}
	
	private Vector<TimeSlot> createTimeSlots(String[] lineArray){
		Vector<TimeSlot> slots = new Vector<TimeSlot>();
		
		for(int i = 2; i < lineArray.length; i++){
			
			if(i % 2 == 0){
				TimeSlot newSlot = new TimeSlot(lineArray[i], Boolean.parseBoolean(lineArray[i+1]));
				slots.add(newSlot);
			}
		}
		return slots;
	}
	private Location createLocation(String name, String roomNum){
		Location loc = new Location(name, roomNum);
		return loc;
	}
}
