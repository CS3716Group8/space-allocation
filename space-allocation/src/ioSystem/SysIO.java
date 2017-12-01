/*
 *	Uses an IOMethod to save/load data across the program
 *	@author Alex Gillis
*/
package ioSystem;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;

public class SysIO<T> {

	private IOMethod<T> ioMethod;
	
	public SysIO(IOMethod<T> method){
		ioMethod = method;
	}
	
	public void save(List<T> data) throws FileNotFoundException{
		ioMethod.save(data);
	}
	
	public Vector<T> load(){
		Vector<T> data = ioMethod.load();
		return data;
	}
}
