package interpret.utility;

import javax.swing.JOptionPane;

public class ExceptionProcessor {
	public static void processException(final Throwable e){
		//System.out.println("In ExceptionProcessor.processException");
		//e.printStackTrace();
		final String causeBy = e.getCause() != null ? "\nCaused by: " + e.getCause() : "";
		JOptionPane.showMessageDialog(null, e.toString() + causeBy);
	}
}
