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
public class TblDonViSearchAction{
    private int pageSize; 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
     }

    public int getPageSize() {
       return pageSize;
 }

    private int page; 
    public void setPage(int page) { this.page = page;   }

    public int getPage() {
       return page;
   }

    private int num; 
    public int getNum() {
       return num;
   }

    private int pages; 
    public void setPages(int pages) { this.pages = pages;   }

    public int getPages() {
       return pages;
     }

    private String dataString; 
    public void setDataString(String dataString) { this.dataString = dataString;    }

    public String getDataString() {
       return dataString;
    }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

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

    private String truongDonVi; 
    public void setTruongDonVi(String truongDonVi) {
       this.truongDonVi = truongDonVi;
   }

    public String getTruongDonVi() {
       return truongDonVi;
   }

    private List<TblDonVi> tblDonVis; 
    public List<TblDonVi>  getTblDonVis() {
        return tblDonVis; 
      } 

    private TblDonViService tblDonViService; 

	private int preSearch(Message msg, List<ConditionReport> cons ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postSearch(Message msg, List<ConditionReport> cons ){ 
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
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DonVi", "xem")){ 
        return "noprivilege"; 
    }tblDonViService = (TblDonViService) context.getBean("tbl_DonViClient"); 
         msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(ma != null && !ma.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ma");
        con.setValue1("%" + ma + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(ten != null && !ten.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ten");
        con.setValue1("%" + ten + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(donViChaId != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("donViChaId.id");
        con.setValue1(new Long(donViChaId));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(truongDonVi != null && !truongDonVi.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("truongDonVi");
        con.setValue1("%" + truongDonVi + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
        preSearch(msg, cons); 
       if (msg.isPreMessage_b()) 
       { 
           if(pageSize == 0){ 
               pageSize = 20; 
           } 
            if(page == 0){ 
               page =1; 
           } 
           tblDonVis = tblDonViService.findTblDonViByCondition(cons,pageSize,page); 
       num = tblDonViService.countTblDonViByCondition(cons); 
       pages = num/pageSize + 1; 
           postSearch(msg, cons); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
      dataString = ""; 
      dataString += "&ma=" + ma; 
      dataString += "&ten=" + ten; 
      dataString += "&donViChaId=" + donViChaId; 
      dataString += "&truongDonVi=" + truongDonVi; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_DonVi Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
