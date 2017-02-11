package com.lb.jwitter.action.core;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;

import com.lb.jwitter.service.ConditionReport;
import com.lb.jwitter.service.TblQLDTConfig;
import com.lb.jwitter.service.TblQLDTConfigService;
import com.lb.jwitter.service.TblTaiKhoan;
import com.lb.jwitter.service.TblTaiKhoanService;
import com.lb.jwitter.util.ApplicationContextProvider;
import com.lb.jwitter.util.Encrypt;
import com.lb.jwitter.util.Message;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction
{
	
	private String username;
	
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private Message msg;
	
	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	TblTaiKhoanService tblTaiKhoanService;
	
	 @Autowired // Injected by Spring when bean is "ready"
	 ApplicationContextProvider contextProvider;

public String execute() throws Exception
{
   	try{
   		Date d1 = new Date();
   		Date d2 = new Date(2016-1900, 0, 1);
   		/*
			
   		if(d1.after(d2)){
   			msg = new Message();
   			msg.setPreMessage_b(false);
   			msg.setPreMessage_s("Bản quyền sử dụng đã hết hạn, vui lòng mua bản quyền mới!");
   			System.out.println("Ban quyen su dung da het han, vui long mua ban quyen moi." + d2.toGMTString());
   			return Action.ERROR;
   		}
       */
       Map session = ActionContext.getContext().getSession();
//       if(session.get("taiKhoan") != null) return Action.SUCCESS;

   	   session.put("taiKhoan", null);

	   	List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
	    if(username!= null && !username.equalsIgnoreCase("")){ 
	        ConditionReport con = new ConditionReport(); 
	        con.setCol("username");
	        con.setValue1(username);
	        con.setOperator("eq");
	        cons.add(con);	
	    } else 
	    	return "noprivilege";
	    if(password!= null && !password.equals("")){ 
	        ConditionReport con = new ConditionReport(); 
	        con.setCol("password");
			con.setValue1(Encrypt.sha(password, "SHA-1"));
	        con.setOperator("eq");
	        cons.add(con);	
	    } else
	    	return "noprivilege";

	    ApplicationContext context = ApplicationContextProvider.getApplicationContext();

		   tblTaiKhoanService = (TblTaiKhoanService) context.getBean("tbl_TaiKhoanClient");
		   TblQLDTConfigService tblQLDTConfigService 
		   	= (TblQLDTConfigService) context.getBean("tbl_QLDT_ConfigClient");
		   
       List<TblTaiKhoan> taiKhoan = tblTaiKhoanService.findtblTaiKhoanByCondition(cons, 1, 1);

       if (taiKhoan == null || taiKhoan.size() == 0 ) return "noprivilege";
       
       session.put("taiKhoan", taiKhoan.get(0));
      
       List<TblQLDTConfig> config = tblQLDTConfigService.findAlltblQLDTConfig(0, 0); 
       session.put("config", config);
       
        return Action.SUCCESS;

     }
        catch(Exception e){
            System.out.println("Loi log in");
            e.printStackTrace();
            return Action.ERROR;
      }
       
}	
}
