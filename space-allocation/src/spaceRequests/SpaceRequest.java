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
	
	public String getId(){ return id;}
	public TimeSlot getSlot() { return slot; }
	public String getRequester() {return requester; }
	
	public String toString(){
		return requester + "\n" + slot.toString() + "\n" +id + "\n" + reqStartTime + "\n" + reqEndTime + "\n";
	}
}
