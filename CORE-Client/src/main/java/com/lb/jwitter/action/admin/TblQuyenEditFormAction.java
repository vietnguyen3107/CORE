package com.lb.jwitter.action.admin;


import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lb.jwitter.service.ConditionReport; 
 import java.util.Map; 
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQuyen;
import com.lb.jwitter.service.TblQuyenService;
import com.lb.jwitter.service.TblQuyenChiTiet;
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
public class TblQuyenEditFormAction{
    private int id; 
    public void setId(int id) {
       this.id = id;
 }

    public int getId() {
       return id;
 }

    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    private int page; 
    public int getPage() { return page; }

    private int pages; 
    public int getPages() { return pages; }

    private TblQuyen tblQuyen; 
    public TblQuyen getTblQuyen() { 
        return tblQuyen; 
    } 
    private List<TblQuyen> tblQuyens; 
    public List<TblQuyen>  getTblQuyens() {
         return tblQuyens; 
      } 

    private TblQuyenService tblQuyenService; 

    private List<TblQuyenChiTiet> tblQuyenChiTiets; 
    public List<TblQuyenChiTiet>  getTblQuyenChiTiets(){ 
              return tblQuyenChiTiets; 
     } 



    private List<TblDBTable> tblDBTables; 
    public List<TblDBTable>  getTblDBTables(){ 
              return tblDBTables; 
     } 

    private TblDBTableService tblDBTableService; 

    private List<TblQuyenMenu> tblQuyenMenus; 
    public List<TblQuyenMenu>  getTblQuyenMenus(){ 
              return tblQuyenMenus; 
     } 

    private TblQuyenMenuService tblQuyenMenuService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Quyen", "sua")){ 
        return "noprivilege"; 
    }        tblQuyenService = (TblQuyenService) context.getBean("tbl_QuyenClient"); 
        tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 

        tblDBTableService = (TblDBTableService) context.getBean("tbl_DBTableClient"); 

        tblQuyenMenuService = (TblQuyenMenuService) context.getBean("tbl_Quyen_MenuClient"); 

        tblMenuService = (TblMenuService) context.getBean("tbl_MenuClient"); 

        tblQuyen = tblQuyenService.gettblQuyen(new Long(id)); 
   List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
   if (id != 0) 
   { 
       ConditionReport con = new ConditionReport(); 
       con.setCol("quyenId.id"); 
       con.setValue1(new Long(id)); 
       con.setOperator("eq"); 
       cons.add(con); 
   } 
   tblQuyenChiTiets = tblQuyenChiTietService.findtblQuyenChiTietByCondition(cons, pageSize, page); 
      tblDBTables =       tblDBTableService.findAlltblDBTable(0, 0); 
      tblMenus =       tblMenuService.findAlltblMenu(0, 0); 
   if (id != 0) 
   { 
       ConditionReport con = new ConditionReport(); 
       con.setCol("quyenId.id"); 
       con.setValue1(new Long(id)); 
       con.setOperator("eq"); 
       cons.add(con); 
   } 
   tblQuyenMenus = tblQuyenMenuService.findtblQuyenMenuByCondition(cons, pageSize, page); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_Quyen Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
