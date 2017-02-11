package com.lb.jwitter.util;

import java.io.File;
import java.util.ArrayList;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ExcelToJSon  {

	public static JSONArray execute(String fileName){
		JSONArray jsons = new JSONArray() ;
		 
		List<String> header = new ArrayList<String>();
        //read excel
        File inputWorkbook = new File(fileName);
        Workbook w;
        try {
	          w = Workbook.getWorkbook(inputWorkbook);
	          // Get the first sheet
	          Sheet sheet = w.getSheet(0);
	          // Loop over first 10 column and lines
	          for (int i = 0; i < sheet.getRows(); i++) {
	        	  JSONObject jsonObject = new JSONObject();
	        	  for (int j = 0; j < sheet.getColumns(); j++) {

		              Cell cell = sheet.getCell(j,i);
		              if(i == 0){
	        			  header.add(cell.getContents().toUpperCase() );
	        		  }else{
	        			  jsonObject.put(header.get(j), cell.getContents());
	        			  
	        		  }
	        	  }
	        	  if(i != 0){
//	        		  System.out.println(jsonObject.toString());
		        	  jsons.add(jsonObject);
	        	  }
	        	 
	          }
        } catch (Exception e) {
          e.printStackTrace();
        }
//        System.out.println("Size = " + jsons.size());
//        for(int i = 0; i < jsons.size() ; i++){
//    		JSONObject obj = jsons.getJSONObject(i);
//    		System.out.println(obj.toString());
//
//    	}
        return jsons;
	}
	
}
