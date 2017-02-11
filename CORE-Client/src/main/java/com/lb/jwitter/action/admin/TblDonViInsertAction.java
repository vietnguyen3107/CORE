package com.lb.jwitter.action.admin;

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
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblDonVi;
import com.lb.jwitter.service.TblDonViService;

import com.lb.jwitter.service.TblDonVi;
import com.lb.jwitter.service.TblDonViService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblDonViInsertAction{
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

  private TblTaiKhoan taiKhoanDangNhap; 
 public TblTaiKhoan getTaiKhoanDangNhap() { 
     return taiKhoanDangNhap; 
 } 
 public void setTaiKhoanDangNhap(TblTaiKhoan taiKhoanDangNhap) { 
     this.taiKhoanDangNhap = taiKhoanDangNhap; 
 } 
    private Long id; 
    public void setId(Long id) {
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

    private int donViChaId; 
    public void setDonViChaId(int donViChaId) {
       this.donViChaId = donViChaId;
 }

    public int getDonViChaId() {
       return donViChaId;
 }

    private String email; 
    public void setEmail(String email) {
       this.email = email;
 }

    public String getEmail() {
       return email;
 }

    private String sdt; 
    public void setSdt(String sdt) {
       this.sdt = sdt;
 }

    public String getSdt() {
       return sdt;
 }

    private String diaChi; 
    public void setDiaChi(String diaChi) {
       this.diaChi = diaChi;
 }

    public String getDiaChi() {
       return diaChi;
 }

    private String truongDonVi; 
    public void setTruongDonVi(String truongDonVi) {
       this.truongDonVi = truongDonVi;
 }

    public String getTruongDonVi() {
       return truongDonVi;
 }

    private TblDonVi tblDonVi; 
    public TblDonVi  getTblDonVi() {
        return tblDonVi;
 }

    private TblDonViService tblDonViService; 

    private TblQuyenChiTietService tblQuyenChiTietService; 

	 @Autowired // Injected by Spring 
     ApplicationContextProvider contextProvider; 
	private int preInsert(Message msg, TblDonVi obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblDonVi obj ){ 
        msg.setPostMessage_b(true); 
        msg.setPostMessage_s("success"); 
        return 1; 
    } 
 public String execute() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DonVi", "them")){ 
        return "noprivilege"; 
    }
     
 tblDonViService = (TblDonViService) context.getBean("tbl_DonViClient"); 
         msg = new Message(); 
        tblDonVi = new TblDonVi(); 
        preInsert(msg,tblDonVi); 
        tblDonVi.setMa(ma); 
        tblDonVi.setTen(ten); 
        tblDonVi.setDonViChaId(tblDonViService.getTblDonVi(new Long(donViChaId))); 
        tblDonVi.setEmail(email); 
        tblDonVi.setSdt(sdt); 
        tblDonVi.setDiaChi(diaChi); 
        tblDonVi.setTruongDonVi(truongDonVi); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblDonViService.createTblDonVi(tblDonVi); 
           postInsert(msg, tblDonVi); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblDonVi.setId(id); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ma="; 
      dataString += "&ten="; 
      dataString += "&donViChaId="; 
      dataString += "&email="; 
      dataString += "&sdt="; 
      dataString += "&diaChi="; 
      dataString += "&truongDonVi="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_DonVi Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
