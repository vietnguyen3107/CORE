package com.lb.jwitter.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import com.opensymphony.xwork2.Action;
public class JsonAction {

	//data format jsonArray : [{key1:val1,key2:val2,...},{},...]
	private String data;
    public String execute()
    {
    	try{ 
/*	    	JSONObject json = (JSONObject) JSONSerializer.toJSON( data );
	    	
	    	int size = json.getInt( "size" );
	    	System.out.println( "size: " + size );
	    	for(int i = 1; i <= size; i ++){
	    		 JSONObject obj = json.getJSONObject(""+i);
	    	     int ngoaingu = obj.getInt( "ngoaingu" );
	    	     String ngaycap = obj.getString("ngaycap");  	 
	    	     
	    	     System.out.println( "ngoaingu: " + ngoaingu );
	    	     System.out.println( "ngaycap: " + ngaycap );
	    	}
*/    	
	    	JSONArray jsons = (JSONArray) JSONSerializer.toJSON( data );
	    	for(int i = 0; i < jsons.size() ; i++){
	    		JSONObject obj = jsons.getJSONObject(i);
	    	    int ngoaingu = obj.getInt( "ngoaingu" );
	    	    String ngaycap = obj.getString("ngaycap");  
	    	     
	    	    System.out.println( "ngoaingu: " + ngoaingu );
	    	    System.out.println( "ngaycap: " + ngaycap );
	    	}
	
	    	return Action.SUCCESS;
    	} catch(Exception e){
	            System.out.println("Loi Form 7 Detail 1 Update Action");
	            e.printStackTrace();
	            return Action.ERROR;
	      }
    }
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
