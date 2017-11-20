package ioSystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import scheduling.Schedule;

public class IOSchedule extends IOMethod<Schedule> {

	private static final String FILENAME = "src/data/schedules";

	public void save(List<Schedule> data) throws FileNotFoundException{
		
		PrintWriter pw = new PrintWriter(new FileOutputStream(FILENAME));
		
		for(Schedule schedule : data){
			pw.println(schedule.toString());
		}
		pw.close();
	}
	
	public List<Schedule> load(){
		List<Schedule> data = null;
		
		return data;
	}
}
