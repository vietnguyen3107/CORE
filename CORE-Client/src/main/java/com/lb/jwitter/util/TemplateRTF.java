package com.lb.jwitter.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.tutego.jrtf.Rtf;
import com.tutego.jrtf.RtfTemplate;

public class TemplateRTF {
	public static String writeToTemplateRTF(String templateFile, String filename, HashMap<String, String> map) {
		try {
			RtfTemplate rtfTemplate = Rtf.template( new FileInputStream(templateFile) );
		     
			 if(rtfTemplate != null){
				 
				for (Entry<String, String> entry : map.entrySet()) {
					
					rtfTemplate.inject(  entry.getKey() , entry.getValue() );
//						System.out.println("Key : " + entry.getKey() + " Value : "
//							+ entry.getValue());
				}
			     

			    rtfTemplate.out( new FileOutputStream("./file/"+filename +".doc") );
			    filename = "file/"+filename +".doc";
			    System.out.println(filename);
			}
			return filename;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		//
	     
		
	}
}
