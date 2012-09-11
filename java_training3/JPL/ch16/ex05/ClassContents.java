package ch16.ex05;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
//			if (m.getDeclaringClass() == Object.class)
//				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
			
		}
	}
	
	
	private static void printMembers(Object[] mems) {
		for (Object m : mems) {
//			if (m.getDeclaringClass() == Object.class)
//				continue;
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));
			
			if(m instanceof Field){
				for(Annotation ann : ((Field)m).getAnnotations()){
					System.out.println("    " + ann);
				}
			}else if(m instanceof Constructor){
				for(Annotation ann : ((Constructor)m).getAnnotations()){
					System.out.println("    " + ann);
				}
			}else if(m instanceof Method){
				for(Annotation ann : ((Method)m).getAnnotations()){
					System.out.println("    " + ann);
				}
			}
			
		}
	}	
	
	
	 
	private static String strip(String src, String dest){
		return src.replaceAll(dest, "");
	}
}


@Retention(RetentionPolicy.RUNTIME)
@interface Preliminary{}

@Retention(RetentionPolicy.RUNTIME)
@interface Copyright{
	String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Name{
	String first();
	String last();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Author{
	Name value();
}


class Test{
	@Copyright("2010 by Ricoh")
	int field1;
	
	@Preliminary
	double testfun(){
		return 0;
	}
	
	@Author(@Name(first = "blue", last = "wind"))
	private void help(){
		
	}
	
	public void nothing(){
		
	}
}
