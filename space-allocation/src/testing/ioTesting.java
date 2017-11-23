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
		
		Location loc1 = new Location("Location1", "1001");
		TimeSlot s1 = new TimeSlot("60", false);
//		TimeSlot s2 = new TimeSlot("60", false);
		Location loc2 = new Location("Location2", "2001");
		TimeSlot s3 = new TimeSlot("60", false);
//		TimeSlot s4 = new TimeSlot("60", false);
//		Location loc3 = new Location("Location3", "3001");
//		TimeSlot s5 = new TimeSlot("60", false);
//		TimeSlot s6 = new TimeSlot("60", false);
//		Location loc4 = new Location("Location4", "4001");
//		TimeSlot s7 = new TimeSlot("60", false);
//		TimeSlot s8 = new TimeSlot("60", false);
		
		Vector<Location> locations = new Vector<Location>();
		Vector<TimeSlot> loc1Slots = new Vector<TimeSlot>();
		Vector<TimeSlot> loc2Slots = new Vector<TimeSlot>();
//		Vector<TimeSlot> loc3Slots = new Vector<TimeSlot>();
//		Vector<TimeSlot> loc4Slots = new Vector<TimeSlot>();
		
		Vector<Vector<TimeSlot>> allSlots = new Vector<Vector<TimeSlot>>();
		
		loc1Slots.add(s1);
//		loc1Slots.add(s2);
		loc2Slots.add(s3);
//		loc2Slots.add(s4);
//		loc3Slots.add(s5);
//		loc3Slots.add(s6);
//		loc4Slots.add(s7);
//		loc4Slots.add(s8);
		
		locations.add(loc1);
		locations.add(loc2);
//		locations.add(loc3);
//		locations.add(loc4);
		
		allSlots.add(loc1Slots);
		allSlots.add(loc2Slots);
//		allSlots.add(loc3Slots);
//		allSlots.add(loc4Slots);
//		
		
		Schedule schedule = new Schedule(locations, allSlots);
		ScheduleManager.addSchedule(schedule);
		
		//----LOADING A SCHEDULE----
		Vector<Schedule> scheduleVec = ScheduleManager.getScheduleVec();
		//----END----
				
		//----SAVING A SCHEDULE----
		SysIO<Schedule> io = new SysIO<Schedule>(new IOSchedule());
		try {
			io.save(ScheduleManager.getScheduleVec());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//----END----
		

		//NOTE: RequestManager is a Singleton, meaning you never/can't create a RequestManager object.
		//----CREATING AND SAVING A REQUEST (REQUESTS ARE SAVE UPON CREATION)----
		RequestManager.createRequest(s1, "John");
		RequestManager.createRequest(s3, "Henry");
		//----END----
		
		//----LOADING/RETREIVING ALL REQUESTS----
		Vector<SpaceRequest> requests = RequestManager.getRequests();
		//----END----
		
		//----RETREIVING A SPECIFIC TIMESLOT FROM A REQUEST----
		TimeSlot retrievedSlot = requests.get(0).getSlot();
		//----END----
		
		//----GETTING THE LOCATION OF A TIMESLOT----
		Location foundLocation = ScheduleManager.getLocationOfSlot(retrievedSlot);
		//----END----
		
		
		int i = 0;
	}
}
