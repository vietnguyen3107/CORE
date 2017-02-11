package com.lb.jwitter.action.admin;


import java.util.List;
import java.util.Map; 
import com.opensymphony.xwork2.ActionContext; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lb.jwitter.util.ApplicationContextProvider; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQuyenNhomQuyen;
import com.lb.jwitter.service.TblQuyenNhomQuyenService;

import com.lb.jwitter.service.TblQuyen;
import com.lb.jwitter.service.TblQuyenService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblNhomQuyenAddFormAction{
    private int id; 
    public void setId(int id) {
       this.id = id;
 }

    public int getId() {
       return id;
 }

    private List<TblQuyen> tblQuyens; 
    public List<TblQuyen>  getTblQuyens(){ 
              return tblQuyens; 
     } 

    private TblQuyenService tblQuyenService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_NhomQuyen", "them")){ 
        return "noprivilege"; 
    }        tblQuyenService = (TblQuyenService) context.getBean("tbl_QuyenClient"); 

      tblQuyens =       tblQuyenService.findAlltblQuyen(0, 0); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi AddForm tbl_NhomQuyen Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
