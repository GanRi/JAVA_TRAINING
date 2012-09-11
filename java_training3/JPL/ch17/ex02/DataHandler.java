package ch17.ex02;

import java.lang.ref.*;
import java.io.File;

class DataHandler {
	private WeakReference<File> lastFile; 
	private WeakReference<byte[]> lastData; 
	
	
	byte[] readFile(File file) {
		byte[] data;
		
		if(lastFile == null || lastFile.get() == null){
			lastFile = new WeakReference<File>(file);
			data = readBytesFromFile(file);
			lastData = new WeakReference<byte[]>(data);
			return data;
		}
		
		if (file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null)
				return data;
		}
		
		data = readBytesFromFile(file);
		lastData = new WeakReference<byte[]>(data);
		return data;

	}
	
	
	byte[] readBytesFromFile(File file){
		return null;
		
	}
}