package com.lb.jwitter.action.util;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction {
	public String execute() throws Exception
	{
	   	try{
	
	       Map session = ActionContext.getContext().getSession();
	   	   
	   	   session.clear();
	   	   
	        return Action.SUCCESS;
	
	     }
	        catch(Exception e){
	            System.out.println("Loi Logout Action");
	            e.printStackTrace();
	            return Action.ERROR;
	      }
	       
	}

}
