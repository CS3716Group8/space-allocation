package ioSystem;

import java.util.List;

public class SysIO<T> {

	private IOMethod<T> ioMethod;
	
	public SysIO(IOMethod<T> method){
		ioMethod = method;
	}
	
	public void save(List<T> data){
		ioMethod.save(data);
	}
	
	public List<T> load(){
		List<T> data = ioMethod.load();
		return data;
	}
}
