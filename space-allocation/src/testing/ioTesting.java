package testing;

import scheduling.*;
import java.io.FileNotFoundException;
import java.util.*;

import ioSystem.*;
import scheduling.Schedule;
import spaceRequests.RequestManager;

public class ioTesting {

	public static void main(String[] args) {
		
		SysIO<Schedule> io = new SysIO<Schedule>(new IOSchedule());
		
		Location loc1 = new Location("Location1", "1001");
		TimeSlot s1 = new TimeSlot("60", false);
		TimeSlot s2 = new TimeSlot("60", false);
		Location loc2 = new Location("Location2", "2001");
		TimeSlot s3 = new TimeSlot("60", false);
		TimeSlot s4 = new TimeSlot("60", false);
		Location loc3 = new Location("Location3", "3001");
		TimeSlot s5 = new TimeSlot("60", false);
		TimeSlot s6 = new TimeSlot("60", false);
		Location loc4 = new Location("Location4", "4001");
		TimeSlot s7 = new TimeSlot("60", false);
		TimeSlot s8 = new TimeSlot("60", false);
		
		Vector<Location> locations = new Vector<Location>();
		Vector<TimeSlot> loc1Slots = new Vector<TimeSlot>();
		Vector<TimeSlot> loc2Slots = new Vector<TimeSlot>();
		Vector<TimeSlot> loc3Slots = new Vector<TimeSlot>();
		Vector<TimeSlot> loc4Slots = new Vector<TimeSlot>();
		
		Vector<Vector<TimeSlot>> allSlots = new Vector<Vector<TimeSlot>>();
		
		loc1Slots.add(s1);
		loc1Slots.add(s2);
		loc2Slots.add(s3);
		loc2Slots.add(s4);
		loc3Slots.add(s5);
		loc3Slots.add(s6);
		loc4Slots.add(s7);
		loc4Slots.add(s8);
		
		locations.add(loc1);
		locations.add(loc2);
		locations.add(loc3);
		locations.add(loc4);
		
		allSlots.add(loc1Slots);
		allSlots.add(loc2Slots);
		allSlots.add(loc3Slots);
		allSlots.add(loc4Slots);
		
		Schedule schedule = new Schedule(locations, allSlots);
		ScheduleManager schManager = new ScheduleManager(schedule);
		
		try {
			io.save(schManager.getScheduleVec());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestManager.test();
	}
}
