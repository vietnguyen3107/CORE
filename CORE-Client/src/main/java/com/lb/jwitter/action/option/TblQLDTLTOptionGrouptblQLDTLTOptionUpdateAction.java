package com.lb.jwitter.action.option;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.List;
import java.util.Date; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.ConditionReport; 
import java.util.Map; 
 import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.Message; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQLDTLTOption;
import com.lb.jwitter.service.TblQLDTLTOptionService;

import com.lb.jwitter.service.TblQLDTLTOptionGroup;
import com.lb.jwitter.service.TblQLDTLTOptionGroupService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTLTOptionGrouptblQLDTLTOptionUpdateAction{
    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    private int sortOrder;
    public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	private int page; 
    public int getPage() { return page; }

    public void setPage(int page) { this.page = page; }

    private int pages; 
    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }

    private String dataString; 
    public String getDataString() { return dataString; }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private int id; 
    public int getId() {
       return id;
 }

    public void setId(int id) {
       this.id = id;
 }

    private String ma; 
    public void setMa(String ma) {
       this.ma = ma;
 }

    public String getMa() {
       return ma;
 }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
 }

    public String getTen() {
       return ten;
 }

    private int optionGroupId; 
    public void setOptionGroupId(int optionGroupId) {
       this.optionGroupId = optionGroupId;
 }

    public int getOptionGroupId() {
       return optionGroupId;
 }

    private TblQLDTLTOptionGroupService tblQLDTLTOptionGroupService; 

    private TblQLDTLTOption tblQLDTLTOption; 
    public void setTblQLDTLTOption (TblQLDTLTOption tblQLDTLTOption) {
        this.tblQLDTLTOption = tblQLDTLTOption;
 }

    private TblQLDTLTOptionService tblQLDTLTOptionService; 

	private int preUpdate(Message msg, TblQLDTLTOption obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblQLDTLTOption obj ){ 
        msg.setPostMessage_b(true); 
        msg.setPostMessage_s("success"); 
        return 1; 
    } 
  private TblTaiKhoan taiKhoanDangNhap; 
 public TblTaiKhoan getTaiKhoanDangNhap() { 
     return taiKhoanDangNhap; 
 } 
 public void setTaiKhoanDangNhap(TblTaiKhoan taiKhoanDangNhap) { 
     this.taiKhoanDangNhap = taiKhoanDangNhap; 
 } 
    private TblQuyenChiTietService tblQuyenChiTietService; 

	 @Autowired // Injected by Spring 
     ApplicationContextProvider contextProvider; 
 public String execute() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDTLT_Option", "sua")){ 
        return "noprivilege"; 
    }tblQLDTLTOptionService = (TblQLDTLTOptionService) context.getBean("tbl_QLDTLT_OptionClient"); 
 tblQLDTLTOptionGroupService = (TblQLDTLTOptionGroupService) context.getBean("tbl_QLDTLT_OptionGroupClient"); 
         msg = new Message(); 
        tblQLDTLTOption = tblQLDTLTOptionService.getTblQLDTLTOption(new Long(id)); 
        preUpdate(msg,tblQLDTLTOption); 
        tblQLDTLTOption.setMa(ma); 
        tblQLDTLTOption.setTen(ten); 
        tblQLDTLTOption.setOptionGroupId(tblQLDTLTOptionGroupService.getTblQLDTLTOptionGroup(new Long(optionGroupId))); 
        tblQLDTLTOption.setSortOrder(sortOrder); 
       if (msg.isPreMessage_b()) 
       { 
           tblQLDTLTOptionService.updateTblQLDTLTOption(tblQLDTLTOption); 
           postUpdate(msg, tblQLDTLTOption); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 

        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Update tbl_QLDTLT_Option Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
