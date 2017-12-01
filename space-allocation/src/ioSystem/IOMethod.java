/*
 *	Abstract class for saving methods
 *	@author Alex Gillis
*/
package ioSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class IOMethod<T> {

	public abstract Vector<T> load();
	public abstract void save(List<T> data) throws FileNotFoundException;
	
	protected List<String> getStringsFromFile(String FILENAME){
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILENAME));
			List<String> lines = new ArrayList<String>();
			String line = br.readLine();
			while(line != null){
				lines.add(line);
				line = br.readLine();
			}
			br.close();
			return lines;
		} catch (IOException e) {
			return null;
		}
	}
}
