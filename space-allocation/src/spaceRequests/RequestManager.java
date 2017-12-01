/*
 *	Handles the creation and retrieving of SpaceRequest Data
 *	@author Alex Gillis
*/

package spaceRequests;

import java.io.FileNotFoundException;
import java.util.*;

import ioSystem.*;
import scheduling.*;

public class RequestManager {

	//----Singleton Creation----
	private RequestManager() {
		
		SysIO<SpaceRequest> sysIO = new SysIO<SpaceRequest>(new IOSpaceRequest());
		requests = sysIO.load();
		
		if(requests == null)
			requests = new Vector<SpaceRequest>();
	}
	private volatile static RequestManager uniqueInstance;
	public static RequestManager getInstance(){
		if(uniqueInstance == null){
			synchronized (RequestManager.class){
				if(uniqueInstance == null){
					uniqueInstance = new RequestManager();
				}
			}
		}
		return uniqueInstance;
	}
	//----END----
	
	private Vector<SpaceRequest> requests;
	
	public static Vector<SpaceRequest> getRequests() { return getInstance().requests; }
	
	public static void createRequest(TimeSlot slot, String requester, int startTime, int endTime){
		
		SpaceRequest newRequest = new SpaceRequest(slot, requester, startTime, endTime);
		getInstance().requests.add(newRequest);
		saveRequests();
	}
	
	public static List<Semesters> getAllSemesters(){
		List<Semesters> allSem = new ArrayList<Semesters>();
		
		
		
		for(SpaceRequest request : getInstance().requests){
			
			Semesters sem = request.getSemesterOfSlot();
			
			if(!allSem.contains(sem)){
				allSem.add(sem);
			}
		}
		
		return allSem;
	}
	
	public static List<SpaceRequest> getRequestsInSemester(Semesters sem){
		
		List<SpaceRequest> reqs = new ArrayList<SpaceRequest>();
		
		for(SpaceRequest request : getInstance().requests){
			
			Semesters currSem = request.getSemesterOfSlot();
			
			if(currSem.equals(sem)){
				reqs.add(request);
			}
		}

		return reqs;
	}
	
	private static void saveRequests(){

		SysIO<SpaceRequest> sysIO = new SysIO<SpaceRequest>(new IOSpaceRequest());
		try {
			sysIO.save(getInstance().requests);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
