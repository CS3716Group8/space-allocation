package ioSystem;

import java.io.FileNotFoundException;
import java.util.List;

public class SysIO<T> {

	private IOMethod<T> ioMethod;
	
	public SysIO(IOMethod<T> method){
		ioMethod = method;
	}
	
	public void save(List<T> data) throws FileNotFoundException{
		ioMethod.save(data);
	}
	
	public List<T> load(){
		List<T> data = ioMethod.load();
		return data;
	}
}
