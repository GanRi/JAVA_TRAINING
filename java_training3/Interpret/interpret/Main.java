package interpret;

import interpret.InterpretFrame;
import interpret.fieldtable.FieldTable;
import interpret.methodtable.MethodTable;
import interpret.objecttable.ObjectTable;
import interpret.parametertable.ParameterTable;
import interpret.utility.FinalExceptionHandler;
import interpret.utility.UtilityClass;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class Main {
	
	public static void main(final String[] args) throws SecurityException, NoSuchMethodException{
		System.out.println("main");
		Thread.currentThread().setUncaughtExceptionHandler(new FinalExceptionHandler());
		new InterpretFrame();
	}
}
