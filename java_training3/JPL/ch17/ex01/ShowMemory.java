package ch17.ex01;

import java.util.LinkedList;

public class ShowMemory {
	public static void main(String[] args){
		Runtime rt = Runtime.getRuntime();
		System.out.println("Free memory before allocation :" + rt.freeMemory());
		LinkedList<?>[] linkedListArray = new LinkedList<?>[100000]; 
		for(int i = 0; i < 100000; i++){
			linkedListArray[i] = new LinkedList();
		}
		
		System.out.println("Free memory after  allocation :" + rt.freeMemory());
		
		for(int i = 0; i < 100000; i++){
			linkedListArray[i] = null;
		}
		
		rt.runFinalization();
		rt.gc();
		System.out.println("Free memory after  allocation :" + rt.freeMemory());
		
	}

}
