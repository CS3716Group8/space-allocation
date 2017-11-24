package ioSystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
		
		if(dataStrs != null){
			for(int i = 0; i < dataStrs.size(); i+=6){

					String requester = dataStrs.get(i);
					TimeSlot reqSlot = createSlot(dataStrs.get(i + 1));
					String reqId = dataStrs.get(i + 2);
					int reqStart = Integer.parseInt(dataStrs.get(i + 3));
					int reqEnd = Integer.parseInt(dataStrs.get(i + 4));
					SpaceRequest newRequest = new SpaceRequest(reqSlot, requester, reqStart, reqEnd, reqId);
					data.add(newRequest);
			}
		}
		return data;
	}
	
	private TimeSlot createSlot(String slotData){
		TimeSlot newSlot = null;
		String[] slotStr = slotData.split(" ");
		
		String id = slotStr[0];
		int startTime = Integer.parseInt(slotStr[1]);
		int endTime = Integer.parseInt(slotStr[2]);
		WeekDays day = WeekDays.valueOf(slotStr[3]);
		Location loc = Location.valueOf(slotStr[4]);
		
		newSlot = new TimeSlot(startTime, endTime, day, loc, id);
		return newSlot;
	}
	
//	private Schedule createSchedule(List<String> scheduleStrs){
//		Schedule sch = null;
//		
//		IOSchedule schIO = new IOSchedule();
//		sch = schIO.loadScheduleFromStrings(scheduleStrs);
//		
//		return sch;
//	}
}
