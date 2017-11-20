package ioSystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
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
	
	public List<SpaceRequest> load(){
		List<SpaceRequest> data = null;
		
		return data;
	}
}
