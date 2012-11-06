package ch21.ex02;

import java.util.HashMap;
import java.util.Map;  
import java.util.WeakHashMap;  
  
public class WeakHashMapTest {  
    static Map wMap = new WeakHashMap();  

    public static void testWeakHashMap(){  
    	String s1 = new String("1");
    	String s2 = new String("2");
        wMap.put(s1, "ding");  
        wMap.put(s2, "job");  
        
    	for (Object o : wMap.entrySet()) {  
    	    System.out.println(o);  
    	}  
    	System.out.println();
    	
    	s1 = null;
        try {  
        	System.gc();
            Thread.sleep(10000);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        for (Object o : wMap.entrySet()) {  
            System.out.println(o);  
        }   
        
    	System.out.println();
    	
    	String s11 = new String("1");
    	String s22 = new String("2");
    	System.out.println(wMap.get(s11));
    	System.out.println(wMap.get(s22)); 
    }  
    public static void main(String[] args) { 
        testWeakHashMap();  
    }  
} 
