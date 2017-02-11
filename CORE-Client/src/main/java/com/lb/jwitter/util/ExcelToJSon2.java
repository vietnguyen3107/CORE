package com.lb.jwitter.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ExcelToJSon2 {
	public static JSONArray execute(String fileName) {
		JSONArray jsons = new JSONArray();
		List<String> header = new ArrayList<String>();
		
		try {
			FileInputStream file = new FileInputStream(new File(fileName));

			// Get the workbook instance for XLS file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Get iterator to all the rows in current sheet
			Iterator<Row> rowIterator = sheet.iterator();
			boolean isFirstRow = true;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				JSONObject jsonObject = new JSONObject();
				 
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				int iCol = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					
					if(isFirstRow){
	        			  header.add(cell.getStringCellValue().toUpperCase() );
	        		}else{
	        			 jsonObject.put(header.get(iCol), cell.getStringCellValue());  
	        		}
					
					iCol++;
				}
				
				if(!isFirstRow){
	        		 //System.out.println(jsonObject.toString());
		        	 jsons.add(jsonObject);
	        	}				
				isFirstRow = false;
			}
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Size = " + jsons.size());
		// for(int i = 0; i < jsons.size() ; i++){
		// JSONObject obj = jsons.getJSONObject(i);
		// System.out.println(obj.toString());
		//
		// }
		return jsons;
	}
	
	public static String getExtension(String filename){
		String extension = "";

		int i = filename.lastIndexOf('.');
		if (i > 0) {
		    extension = filename.substring(i+1);
		}
		
		return extension.toUpperCase();
	}
}
