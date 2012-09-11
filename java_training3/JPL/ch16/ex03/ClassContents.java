package ch16.ex03;

import java.lang.reflect.*;
import java.util.HashSet;
import java.util.Set;
public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			Set<Member> set = new HashSet<Member>();
			
			for(Field field : c.getFields()){
				set.add(field);
			}
			for(Field field : c.getDeclaredFields()){
				set.add(field);
			}	
			printMembers(set.toArray());
			
			
			printMembers(c.getConstructors());
			
			
			set.clear();
			for(Method method : c.getMethods()){
				set.add(method);
			}
			for(Method method : c.getDeclaredMethods()){
				set.add(method);
			}		
			printMembers(set.toArray());
			
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	
	private static void printMembers(Member[] mems) {
		for (Member m : mems) {
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
			
		}
	}
	
	
	private static void printMembers(Object[] mems) {
		for (Object m : mems) {
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
			
		}
	}	
		 
	private static String strip(String src, String dest){
		return src.replaceAll(dest, "");
	}
}
