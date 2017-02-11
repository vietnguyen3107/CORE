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
public class TblDonViFormAction{
    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    private int num; 
    public int getNum() { return num; }

    private int page; 
    public int getPage() { return page; }

    public void setPage(int page) { this.page = page; }

    private int pages; 
    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private String dataString; 
    public String getDataString() { return dataString; }

    private Message msg; 
    public Message getMsg() { return msg; }

    private List<TblDonVi> tblDonVis; 
    public List<TblDonVi>  getTblDonVis() {
         return tblDonVis; 
      } 

    private TblDonViService tblDonViService; 


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
    today = new Date(); 
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DonVi", "xem")){ 
        return "noprivilege"; 
    }tblDonViService = (TblDonViService) context.getBean("tbl_DonViClient"); 
 tblDonViService = (TblDonViService) context.getBean("tbl_DonViClient"); 
        if(pageSize == 0){ 
            pageSize = 20; 
        } 
        if(page == 0){ 
            page =1; 
        } 
         List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
        { 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ten");
        con.setValue1("asc");
        con.setOperator("order");
        cons.add(con);	
    } 
      tblDonVis = tblDonViService.findTblDonViByCondition(cons,0,0);
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Form tbl_DonVi Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
