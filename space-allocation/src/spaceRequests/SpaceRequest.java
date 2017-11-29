package spaceRequests;

import java.util.UUID;

import scheduling.*;

public class SpaceRequest {

	private String id;
	private int reqStartTime;
	private int reqEndTime;
	private TimeSlot slot;
	private String requester; //The requesters Name. Not sure if User class will be implemented
	
	public SpaceRequest(TimeSlot ts, String r, int rST, int rET){
		slot = ts;
		requester = r;
		reqStartTime = rST;
		reqEndTime = rET;
		id = UUID.randomUUID().toString();
	}
	public SpaceRequest(TimeSlot ts, String r, int rST, int rET, String i){
		slot = ts;
		requester = r;
		reqStartTime = rST;
		reqEndTime = rET;
		id = i;
	}
	
	public int getStartTime(){ return reqStartTime; }
	public int getEndTime(){ return reqEndTime; }
	public String getId(){ return id;}
	public TimeSlot getSlot() { return slot; }
	public String getRequester() {return requester; }
	public Location getLocationOfSlot() { return slot.getLocation(); }
	public Semesters getSemesterOfSlot(){
		Semesters sem = null;
		
		for(Schedule sch : ScheduleManager.getSchedule()){
			
			for(TimeSlot tempSlot : sch.getTimeSlots()){
				
				if(slot.getId().equals(tempSlot.getId())){
					
					sem = sch.getSemester();
				}
			}
		}
		
		return sem;
	}
	
	public String toString(){
		return requester + "\n" + slot.toString() + "\n" +id + "\n" + reqStartTime + "\n" + reqEndTime + "\n";
	}
}
