package com.mystore.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Log {
	
	// Initialize Log4j logs
	public static Logger log = LogManager.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName){		  
		 log.info("====================================="+sTestCaseName+" TEST START=========================================");
		 }
	
	public static void endTestCase(String sTestCaseName){
		log.info("====================================="+sTestCaseName+" TEST END=========================================");
		 }
	
	// Need to create below methods, so that they can be called  

	 public static void info(String message) {
		 log.info(message);
		}

	 public static void warn(String message) {
			log.info(message);
		}

	 public static void error(String message) {
			log.info(message);
		}

	 public static void fatal(String message) {
			log.info(message);
		}

	 public static void debug(String message) {
			log.info(message);
		}
	
}