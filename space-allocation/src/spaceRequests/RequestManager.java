package spaceRequests;

import java.util.*;

public class RequestManager {

	//----Singleton Creation----
	private RequestManager() {
		requests = new LinkedList<SpaceRequest>();
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
	
	private List<SpaceRequest> requests = new LinkedList<SpaceRequest>();
	
	public static void test(){
		System.out.println("Hey");
	}
	

}
