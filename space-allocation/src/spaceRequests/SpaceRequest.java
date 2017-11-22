package spaceRequests;

import scheduling.*;

public class SpaceRequest {

	private Schedule schedule;
	private TimeSlot slot;
	private String requester; //The requesters Name. Not sure if User class will be implemented
	
	public SpaceRequest(Schedule s, TimeSlot ts, String r){
		schedule = s;
		slot = ts;
		requester = r;
	}
	
	public Schedule getSchedule(){ return schedule;}
	public TimeSlot getSlot() { return slot; }
	public String getRequester() {return requester; }
	
	public String toString(){
		return requester + "\n" + slot.toString() + "\n" + schedule.toString();
	}
}
