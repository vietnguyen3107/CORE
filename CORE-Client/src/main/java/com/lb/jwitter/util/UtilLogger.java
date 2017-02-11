package com.lb.jwitter.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class UtilLogger {
	private FileHandler fileTxt;
	private MyFormatter formatterTxt;
	Logger logger;
	
	String classname;
	
	public UtilLogger(String classname){
		this.classname = classname;
		
		try {
			this.logger = Logger.getLogger(this.classname);
			
			this.logger.setLevel(Level.INFO);
			this.fileTxt = new FileHandler("logs\\" +classname +".log",true);

			// Create txt Formatter
			this.formatterTxt = new MyFormatter();
			this.fileTxt.setFormatter(this.formatterTxt);
			this.logger.addHandler(this.fileTxt);
			
		} catch (Exception e) {
			
		}

	}
	
	public void log(String text){
		this.logger.log(Level.INFO,text);
	}
	
	
	//------------------------------------------------------------
	public void stop(){
		this.log("0======================================");
		this.fileTxt.close();
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