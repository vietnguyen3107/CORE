package com.lb.jwitter.action.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
////import org.springframework.test.context.ContextConfiguration;
import com.opensymphony.xwork2.Action;


//@ContextConfiguration(locations="classpath:beans.xml")
public class FileDownloadAction
{
	private String fileName;
	private InputStream fileInputStream;
	 
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
 
	public String execute() throws Exception {
		if(fileName == null || fileName.equalsIgnoreCase(""))
			return Action.ERROR;

//		fileName =   fileName;
	    fileInputStream = new FileInputStream(new File(fileName));
	    return Action.SUCCESS;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}	
}
