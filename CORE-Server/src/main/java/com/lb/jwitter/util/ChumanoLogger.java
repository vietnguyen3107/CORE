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
	static private MyFormatter formatterTxt;
	final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	static public void init(String filename) {
		try {
			// Get the global logger to configure it
			logger.setLevel(Level.INFO);
			fileTxt = new FileHandler("logs\\" +filename +".log",true);

			// Create txt Formatter
			formatterTxt = new MyFormatter();
			fileTxt.setFormatter(formatterTxt);
			logger.addHandler(fileTxt);
			
		} catch (Exception e) {
			
		}
	}
	
	static public void log(String text){
		logger.log(Level.INFO,text);
	}
	
	static public void stop(){
		log("0======================================");
		fileTxt.close();
	}
}

 class MyFormatter extends Formatter {
	@Override
	public String format(LogRecord record) {
		StringBuffer buf = new StringBuffer();
		String msg =record.getMessage();
		String kyhieu = ""+msg.charAt(0);
		if(kyhieu.equals("0")){
			SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy [HH:mm]");
			Date resultdate = new Date(record.getMillis());

			buf.append("----------");
			buf.append(date_format.format(resultdate));
			buf.append("----------");
			buf.append("\n");
			
			msg = msg.substring(1);
		}
		buf.append(msg); 
		buf.append("\n");
		return buf.toString();
	}
	
	// This method is called just after the handler using this
	  // formatter is created
	  public String getHead(Handler h) {
	    return "";
	  }

	  // This method is called just after the handler using this
	  // formatter is closed
	  public String getTail(Handler h) {
	    return "";
	  }

}