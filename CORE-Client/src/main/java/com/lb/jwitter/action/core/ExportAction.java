package com.lb.jwitter.action.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.opensymphony.xwork2.Action;
import com.tutego.jrtf.Rtf;
import com.tutego.jrtf.RtfTemplate;

public class ExportAction {

	  private static final int defaultRowHeight=600;
	  private static final int defaultColWidth=7;
	  
	  private String filename;
	  private String saveStr;
	  private int columnWidth;
	  private int rowHeight;

//		public static void main(String[] args) throws Exception {
//			try {
//
//				  String filename = "./file/testExcel.xls";
//					int  rowHeight = 1200;
//					int   columnWidth = 14;
//				  
//				  System.out.println(filename);
//			      WorkbookSettings ws = new WorkbookSettings();
//			      ws.setLocale(new Locale("en", "EN"));
//			      WritableWorkbook workbook = 
//			        Workbook.createWorkbook(new File(filename), ws);
//			      WritableSheet s = workbook.createSheet("Sheet1", 0);
//
//			      s.getSettings().setDefaultColumnWidth(columnWidth);
//			      s.getSettings().setDefaultRowHeight(rowHeight);
//
//			      
//			      String saveStr1 = "[{'cells' : [{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' 2 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' 3 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' 4 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' 5 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' 6 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' 7 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : 'CN ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 1 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : 'KTLT 																															GV : NguyenTrungTruc ', 'colspan' : 1, 'rowspan' : 2, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : 'LTHDT ', 'colspan' : 1, 'rowspan' : 3, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 2 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 3 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : 'LTHDT ', 'colspan' : 1, 'rowspan' : 3, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 4 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 5 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 6 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 7 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 8 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 9 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 10 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 11 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 12 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 13 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 14 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 15 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 16 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},{'cells' : [{'cell' : ' 17 ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },{'cell' : ' ', 'colspan' : 1, 'rowspan' : 1, },]},]";
//			      
//			      WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
//				  WritableCellFormat cf = new WritableCellFormat(wf);
//				  cf.setWrap(true);
//				  cf.setAlignment(Alignment.CENTRE);
//				  cf.setVerticalAlignment(VerticalAlignment.CENTRE);
//				  
//				  JSONArray jsonArr = (JSONArray) JSONSerializer.toJSON( saveStr1 );
//					for(int r = 0; r < jsonArr.size() ; r++){
//						JSONObject row = jsonArr.getJSONObject(r);
//						
//						JSONArray cells = row.getJSONArray("cells");
//						for(int col = 0 ; col < cells.size() ; col++){
//							JSONObject cell = cells.getJSONObject(col);
//							String value = cell.getString("cell");
//							int colspan = cell.getInt("colspan");
//							int rowspan = cell.getInt("rowspan");
//
//							if(value != null && !value.equalsIgnoreCase("")){
//								Label l = new Label(col,r,value,cf); 
//								s.addCell(l);
//							}
//							
//							if(colspan > 1) {
//								s.mergeCells(col, r, col+colspan-1, r);
//							}
//							if(rowspan > 1) {
//								s.mergeCells(col, r, col, r+rowspan-1);
//							}
//						}
//					}
//			      workbook.write();
//			      workbook.close();    
//				  
//
//		      } 
//		      	  catch(Exception e){ 
//		          System.out.println("Loi Export Excel Action"); 
//		          e.printStackTrace(); 
//		      } 
//		}

	  
	  public String exportExcel()throws Exception {
		  try {
			  if(filename == null || filename.equalsIgnoreCase(""))
				  filename = "./file/ketQuaXetTuyen.xls";
			  else filename = "./file/" + filename;
			  
			  if(rowHeight == 0)
				  rowHeight = defaultRowHeight;
			  if(columnWidth == 0)
				   columnWidth = defaultColWidth;
			  
			  System.out.println(filename);
		      WorkbookSettings ws = new WorkbookSettings();
		      ws.setLocale(new Locale("en", "EN"));
		      WritableWorkbook workbook = 
		        Workbook.createWorkbook(new File(filename), ws);
		      WritableSheet s = workbook.createSheet("Sheet1", 0);

		      s.getSettings().setDefaultColumnWidth(columnWidth);
		      s.getSettings().setDefaultRowHeight(rowHeight);
		      writeExcelFile(s);
		      workbook.write();
		      workbook.close();    
			  
			  return Action.SUCCESS; 
	      } 
	      	  catch(Exception e){ 
	          System.out.println("Loi Export Excel Action"); 
	          e.printStackTrace(); 
	          return Action.ERROR; 
	      } 
		  
	  }
	  private void writeExcelFile(WritableSheet s) throws WriteException {
		  WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		  WritableCellFormat cf = new WritableCellFormat(wf);
		  cf.setWrap(true);
		  cf.setAlignment(Alignment.CENTRE);
		  cf.setVerticalAlignment(VerticalAlignment.CENTRE);
		  
		  JSONArray jsonArr = (JSONArray) JSONSerializer.toJSON( saveStr );
			for(int r = 0; r < jsonArr.size() ; r++){
				JSONObject row = jsonArr.getJSONObject(r);
				
				JSONArray cells = row.getJSONArray("cells");
				for(int col = 0 ; col < cells.size() ; col++){
					JSONObject cell = cells.getJSONObject(col);
					String value = cell.getString("cell");
					int colspan = cell.getInt("colspan");
					int rowspan = cell.getInt("rowspan");

					if(value != null && !value.equalsIgnoreCase("")){
						Label l = new Label(col,r,value,cf); 
						s.addCell(l);
					
					
					if(colspan > 1 || rowspan > 1) {
						s.mergeCells(col, r, col+colspan-1, r+rowspan-1);
					}
					}
					/*if(rowspan > 1) {
						s.mergeCells(col, r, col, r+rowspan-1);
					}*/
					
				}
			}
		  
	  }
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSaveStr() {
		return saveStr;
	}
	public void setSaveStr(String saveStr) {
		this.saveStr = saveStr;
	}
	public int getColumnWidth() {
		return columnWidth;
	}
	public void setColumnWidth(int columnWidth) {
		this.columnWidth = columnWidth;
	}
	public int getRowHeight() {
		return rowHeight;
	}
	public void setRowHeight(int rowHeight) {
		this.rowHeight = rowHeight;
	}
	  
}
