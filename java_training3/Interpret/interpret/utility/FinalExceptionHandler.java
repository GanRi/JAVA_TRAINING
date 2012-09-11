package interpret.utility;

import java.lang.Thread.UncaughtExceptionHandler;

public class FinalExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(final Thread thread, final Throwable e) {
		ExceptionProcessor.processException(e);
	}

}
