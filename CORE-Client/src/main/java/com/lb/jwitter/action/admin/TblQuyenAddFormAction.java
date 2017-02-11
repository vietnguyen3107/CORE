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
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQuyenChiTiet;
import com.lb.jwitter.service.TblQuyenChiTietService;

import com.lb.jwitter.service.TblDBTable;
import com.lb.jwitter.service.TblDBTableService;

import com.lb.jwitter.service.TblQuyenMenu;
import com.lb.jwitter.service.TblQuyenMenuService;

import com.lb.jwitter.service.TblMenu;
import com.lb.jwitter.service.TblMenuService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQuyenAddFormAction{
    private int id; 
    public void setId(int id) {
       this.id = id;
 }

    public int getId() {
       return id;
 }

    private List<TblDBTable> tblDBTables; 
    public List<TblDBTable>  getTblDBTables(){ 
              return tblDBTables; 
     } 

    private TblDBTableService tblDBTableService; 

    private List<TblMenu> tblMenus; 
    public List<TblMenu>  getTblMenus(){ 
              return tblMenus; 
     } 

    private TblMenuService tblMenuService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Quyen", "them")){ 
        return "noprivilege"; 
    }        tblDBTableService = (TblDBTableService) context.getBean("tbl_DBTableClient"); 

        tblMenuService = (TblMenuService) context.getBean("tbl_MenuClient"); 

      tblDBTables =       tblDBTableService.findAlltblDBTable(0, 0); 
      tblMenus =       tblMenuService.findAlltblMenu(0, 0); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi AddForm tbl_Quyen Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
