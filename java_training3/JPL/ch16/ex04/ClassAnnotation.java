package ch16.ex04;

import java.lang.annotation.Annotation;

public class ClassAnnotation {
	public static void main(String[] args) {
	    try {
	      Class<?> cls = Class.forName(args[0]);
	      System.out.println(cls);
	      printAnnotations(cls.getAnnotations());
	    } catch (ClassNotFoundException e) {
	      System.out.println("unknown class: " + args[0]);
	    }
	  }

	  private static void printAnnotations(Annotation[] annotation) {
	    for (Annotation a : annotation) {
	      String str = a.toString();
	      System.out.print(" ");
	      System.out.println(str.replaceAll("java.lang.", ""));
	    }
	  }
}