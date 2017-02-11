package com.lb.jwitter.action.core.htmlreport;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import java.util.Date; 
import java.util.Map; 
import com.lb.jwitter.util.Message; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportService;
 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTHTMLReportAddFormAction{
    private int id; 
    public void setId(int id) {
       this.id = id;
 }

    public int getId() {
       return id;
 }

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport", "them")){ 
        return "noprivilege"; 
    }        msg = new Message(); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi AddForm tbl_QLDT_HTMLReport Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
