package ch21.ex02;

import java.lang.ref.*;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import java.io.File;
class DataHandler {
	private File lastFile; // last file read
	//private WeakReference<byte[]>	lastData; // last data (maybe)
	private WeakHashMap<byte[], File>	wmap = new WeakHashMap<byte[], File>(); // last data (maybe)
	
	byte[] readFile(File file) {
		byte[] data = null;
		// check to see if we remember the data
		if (file.equals(lastFile)) {
	    	for (Entry<byte[], File> entry : wmap.entrySet()) {  
	    	    data = entry.getKey(); 
	    	}  
			if (data != null)
				return data;
		}

		// don't remember it, read it in
		data = readBytesFromFile(file);
		lastFile = file;
		//lastData = new WeakReference<byte[]>(data);
		wmap.put(data, lastFile);
		return data;
	}
	
	
	byte[] readBytesFromFile(File file){
		return null;
		
	}
}
