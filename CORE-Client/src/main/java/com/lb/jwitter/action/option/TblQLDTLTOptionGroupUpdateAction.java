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
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQLDTLTOptionGroup;
import com.lb.jwitter.service.TblQLDTLTOptionGroupService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTLTOptionGroupUpdateAction{
    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

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

    private String maLoai; 
    public void setMaLoai(String maLoai) {
       this.maLoai = maLoai;
 }

    public String getMaLoai() {
       return maLoai;
 }

    private TblQLDTLTOptionGroup tblQLDTLTOptionGroup; 
    public void setTblQLDTLTOptionGroup (TblQLDTLTOptionGroup tblQLDTLTOptionGroup) {
        this.tblQLDTLTOptionGroup = tblQLDTLTOptionGroup;
 }

    private TblQLDTLTOptionGroupService tblQLDTLTOptionGroupService; 

	private int preUpdate(Message msg, TblQLDTLTOptionGroup obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblQLDTLTOptionGroup obj ){ 
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
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDTLT_OptionGroup", "sua")){ 
        return "noprivilege"; 
    }tblQLDTLTOptionGroupService = (TblQLDTLTOptionGroupService) context.getBean("tbl_QLDTLT_OptionGroupClient"); 
         msg = new Message(); 
        tblQLDTLTOptionGroup = tblQLDTLTOptionGroupService.getTblQLDTLTOptionGroup(new Long(id)); 
        preUpdate(msg,tblQLDTLTOptionGroup); 
        tblQLDTLTOptionGroup.setMa(ma); 
        tblQLDTLTOptionGroup.setTen(ten); 
        tblQLDTLTOptionGroup.setMaLoai(maLoai); 
       if (msg.isPreMessage_b()) 
       { 
           tblQLDTLTOptionGroupService.updateTblQLDTLTOptionGroup(tblQLDTLTOptionGroup); 
           postUpdate(msg, tblQLDTLTOptionGroup); 
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
         System.out.println("Loi Update tbl_QLDTLT_OptionGroup Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
