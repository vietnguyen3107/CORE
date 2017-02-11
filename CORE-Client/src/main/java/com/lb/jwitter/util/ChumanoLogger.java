package com.lb.jwitter.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ChumanoLogger {
	private static String logFile = "LogFolder\\chumano.txt";
	static private FileHandler fileTxt;
//	static private MyFormatter formatterTxt;
	final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	static public void init(String filename) {
		try {
			// Get the global logger to configure it
			logger.setLevel(Level.INFO);
			fileTxt = new FileHandler("logs\\" +filename +".log",true);

			// Create txt Formatter
//			formatterTxt = new MyFormatter();
//			fileTxt.setFormatter(formatterTxt);
			logger.addHandler(fileTxt);
			
		} catch (Exception e) {
			
		}
	}
	
	static public void log(String text){
		logger.log(Level.INFO,text);
	}
	
	
	//------------------------------------------------------------
	static public void init1(String classname) {
		try {
			Logger log = Logger.getLogger(classname);
			
			log.setLevel(Level.INFO);
			fileTxt = new FileHandler("logs\\" +classname +".log",true);

			// Create txt Formatter
//			formatterTxt = new MyFormatter();
//			fileTxt.setFormatter(formatterTxt);
			log.addHandler(fileTxt);
			
		} catch (Exception e) {
			
		}
	}
	
	static public void log(String classname ,String text){
		Logger log = Logger.getLogger(classname);
		log.log(Level.INFO,text);
	}
	
	static public void stop(){
		log("0======================================");
		fileTxt.close();
	}
}

 