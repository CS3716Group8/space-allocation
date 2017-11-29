package ioSystem;
import java.io.*;
import java.util.*;
import Allocation.AllocatedSlot;
import scheduling.*;


public class IOAllocatedSlot extends IOMethod<AllocatedSlot> 
{
	private static final String FILENAME = "src/data/allocatedslots";

	public void save(List<AllocatedSlot> data) throws FileNotFoundException
	{		
		PrintWriter pw = new PrintWriter(new FileOutputStream(FILENAME));
		
		for(AllocatedSlot allocatedSlot : data)
		{
			pw.println(allocatedSlot.toString());
		}
		pw.close();
	}
	
	public Vector<AllocatedSlot> load()
	{		
		List<String> dataStrs = super.getStringsFromFile(FILENAME);
		Vector<AllocatedSlot> allocatedSlots = loadAllocatedSlotFromStrings(dataStrs);
		
		if(allocatedSlots == null)
		{
			allocatedSlots = new Vector<AllocatedSlot>();
		}		
		return allocatedSlots;
	}
	
	public Vector<AllocatedSlot> loadAllocatedSlotFromStrings(List<String> dataStrs)
	{
		Vector<AllocatedSlot> loadedAllocatedSLots = null;
		
		if(dataStrs != null)
		{			
			loadedAllocatedSLots = new Vector<AllocatedSlot>();			
			for(String line : dataStrs){
				if(!line.equals("")){					
					String[] splitLine = line.split(" ");
					loadedAllocatedSLots = createAllAllocatedSlots(splitLine);					
				}
			}
		}
		else
		{
			System.out.println("IOSchedule.java: 63 : No Data in Schedule File.");
		}
		
		return loadedAllocatedSLots;		
	}
	
	private Vector<AllocatedSlot> createAllAllocatedSlots(String[] lineArray){
		
		Vector<AllocatedSlot> allocatedSlots = new Vector<AllocatedSlot>();
		
		Semesters se = null;
		String requestorName= "";
		Location location = null;
		int startTime, endTime = -1;
					
		for(int i = 0; i < lineArray.length; i+=5)
		{
			se = Semesters.valueOf(lineArray[i]);
			requestorName = lineArray[i+1];
			location= Location.valueOf(lineArray[i+2]);
			startTime = Integer.parseInt(lineArray[i+3]);
			endTime = Integer.parseInt(lineArray[i+4]);
			
			AllocatedSlot allocatedSlot = new AllocatedSlot(requestorName, location, se, startTime, endTime);
			allocatedSlots.add(allocatedSlot);
		}
		return allocatedSlots;
	}
}
