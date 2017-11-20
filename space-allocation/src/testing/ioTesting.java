package testing;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import ioSystem.*;
import scheduling.Schedule;
import spaceRequests.RequestManager;
public class ioTesting {

	public static void main(String[] args) {
		
		SysIO<Schedule> io = new SysIO<Schedule>(new IOSchedule());
		List<Schedule> data = new ArrayList<Schedule>();
		
		try {
			io.save(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestManager.test();

	}

}
