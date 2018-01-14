package example.linus;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class LoggingLevelsDemonstration {

	//declaring a static root logger
	private final static Logger rootLogger = Logger.getRootLogger();
	
	public static void main(String arg[]) {
		LoggerTester loggerTester = new LoggerTester();
		
		System.out.println("\n*****************************");
		//RootLogger with ALL levels
		loggerTester.testLogger(rootLogger);
		
		System.out.println("\n*****************************");
		//Custom logger (using XML file) with INFO level
		Logger logger1 = Logger.getLogger("TestLogger1");
		loggerTester.testLogger(logger1);
		
		System.out.println("\n*****************************");
		//Custom logger (java/object based) with WARN level configuration
		Logger logger2 = Logger.getLogger("TestLogger2");
		logger2.setLevel(Level.WARN);
		PatternLayout pLayout= new PatternLayout();                           //Creating a PatterLayout object to organize logging statements in the appenders   
		pLayout.setConversionPattern("%-4r [%t] %-5p %c %x - %m%n");
		Appender appender = new ConsoleAppender();                            //Creating a console appender
		appender.setLayout(pLayout);
		((ConsoleAppender)appender).activateOptions();                        //Creating a file appender
		RollingFileAppender fAppender = new RollingFileAppender();
		fAppender.setFile("output2.log");
		fAppender.setLayout(pLayout);
		fAppender.activateOptions();
		logger2.addAppender(appender);                                        //adding console appender to logger object
		logger2.addAppender(fAppender);                                       //adding file appender to logger object
		logger2.setAdditivity(false);                                         //To ensure no other logger gets bundled with custom loggers / To avoid duplicate logging
		loggerTester.testLogger(logger2);
	}    //main()
	
}    //class
