package Interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ShowMethods {
	private Class className = null;
	private Method[] m = null;
	private Constructor[] ctor = null;

	public void checkClass(String classNameString) {
		try {
			className = Class.forName(classNameString);
			m = className.getMethods();
			ctor = className.getConstructors();
			for (int i = 0; i < m.length; i++)
				System.out.println(m[i].toString());
			for (int i = 0; i < ctor.length; i++)
				System.out.println(ctor[i].toString());

		} catch (ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}

	public void checkMethods(String methodName, String args) {
		try {
			Object obj = className.newInstance();

			for (int i = 0; i < m.length; i++) {
				if (m[i].getName().equals(methodName)) {
					m[i].invoke(obj, methodName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		
		ShowMethods showMethods = new ShowMethods();
		showMethods.checkClass("java.lang.String");
	}

}
