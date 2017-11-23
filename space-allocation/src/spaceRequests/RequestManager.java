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
	
	public static void createRequest(TimeSlot slot, String requester){
		
		SpaceRequest newRequest = new SpaceRequest(slot, requester);
		getInstance().requests.add(newRequest);
		saveRequests();
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
