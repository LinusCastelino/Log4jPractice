package example.linus;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerTester {

	public void testLogger(Logger logger) {
		if(logger.isTraceEnabled()) {
			System.out.println("TRACE level logging is enabled");
			logger.trace("This is a trace statement. Level:"+logger.getLevel());
		}
		if(logger.isDebugEnabled()) {
			System.out.println("DEBUG level logging is enabled");
			logger.debug("This is a debug statement. Level:"+logger.getLevel());
		}
		if(logger.isInfoEnabled()) {
			System.out.println("INFO level logging is enabled");
			logger.info("This is an info statement. Level:"+logger.getLevel());
		}	
		if(logger.isEnabledFor(Level.toLevel(Level.WARN_INT))) {
			System.out.println("WARN level logging is enabled");
			logger.warn("This is a warn statement. Level:"+logger.getLevel());
		}
		if(logger.isEnabledFor(Level.toLevel(Level.ERROR_INT))) {
			System.out.println("ERROR level logging is enabled");
			logger.error("This is an error statement. Level:"+logger.getLevel());
		}
		if(logger.isEnabledFor(Level.FATAL)) {
			System.out.println("FATAL level logging is enabled");
			logger.fatal("This is a fatal statement. Level:"+logger.getLevel());
		}
	}    //testLogger()
	
}
