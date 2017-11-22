package ioSystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import scheduling.*;
import spaceRequests.SpaceRequest;

public class IOSpaceRequest extends IOMethod<SpaceRequest> {

	private static final String FILENAME = "src/data/spaceRequests";

	public void save(List<SpaceRequest> data) throws FileNotFoundException{
		
		PrintWriter pw = new PrintWriter(new FileOutputStream(FILENAME));
		
		for(SpaceRequest request : data){
			pw.println(request.toString());
		}
		pw.close();
	}
	
	public Vector<SpaceRequest> load(){
		Vector<SpaceRequest> data = new Vector<SpaceRequest>();
		List<String> dataStrs = super.getStringsFromFile(FILENAME);
		
		List<String> requestStr = new ArrayList<String>();
		if(dataStrs != null){
			for(int i = 0; i < dataStrs.size() - 1; i++){
				
				String line = dataStrs.get(i);
	
				if(!line.equals("")){
					requestStr.add(line);
				}
				else{
					//Full request Completed
					
					String requester = requestStr.get(0);
					TimeSlot reqSlot = createSlot(requestStr.get(1));
					
					requestStr.remove(0);
					requestStr.remove(1);
					
					Schedule schedule = createSchedule(requestStr);
					
					SpaceRequest newRequest = new SpaceRequest(schedule, reqSlot, requester);
					data.add(newRequest);
					requestStr = new ArrayList<String>();
				}
			}
		}
		return data;
	}
	
	private TimeSlot createSlot(String slotData){
		TimeSlot newSlot = null;
		String[] slotStr = slotData.split(" ");
		
		newSlot = new TimeSlot(slotStr[0], Boolean.parseBoolean(slotStr[1]));
		return newSlot;
	}
	
	private Schedule createSchedule(List<String> scheduleStrs){
		Schedule sch = null;
		
		IOSchedule schIO = new IOSchedule();
		sch = schIO.loadScheduleFromStrings(scheduleStrs);
		
		return sch;
	}
}
