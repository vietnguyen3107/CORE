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
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblNhomQuyen;
import com.lb.jwitter.service.TblNhomQuyenService;
import com.lb.jwitter.service.TblQuyenNhomQuyen;
import com.lb.jwitter.service.TblQuyenNhomQuyenService;

import com.lb.jwitter.service.TblQuyen;
import com.lb.jwitter.service.TblQuyenService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblNhomQuyenEditFormAction{
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

    private TblNhomQuyen tblNhomQuyen; 
    public TblNhomQuyen getTblNhomQuyen() { 
        return tblNhomQuyen; 
    } 
    private List<TblNhomQuyen> tblNhomQuyens; 
    public List<TblNhomQuyen>  getTblNhomQuyens() {
         return tblNhomQuyens; 
      } 

    private TblNhomQuyenService tblNhomQuyenService; 

    private List<TblQuyenNhomQuyen> tblQuyenNhomQuyens; 
    public List<TblQuyenNhomQuyen>  getTblQuyenNhomQuyens(){ 
              return tblQuyenNhomQuyens; 
     } 

    private TblQuyenNhomQuyenService tblQuyenNhomQuyenService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_NhomQuyen", "sua")){ 
        return "noprivilege"; 
    }        tblNhomQuyenService = (TblNhomQuyenService) context.getBean("tbl_NhomQuyenClient"); 
        tblQuyenNhomQuyenService = (TblQuyenNhomQuyenService) context.getBean("tbl_Quyen_NhomQuyenClient"); 

        tblQuyenService = (TblQuyenService) context.getBean("tbl_QuyenClient"); 

        tblNhomQuyen = tblNhomQuyenService.gettblNhomQuyen(new Long(id)); 
   List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
      tblQuyens =       tblQuyenService.findAlltblQuyen(0, 0); 
   if (id != 0) 
   { 
       ConditionReport con = new ConditionReport(); 
       con.setCol("maNhomQuyen.id"); 
       con.setValue1(new Long(id)); 
       con.setOperator("eq"); 
       cons.add(con); 
   } 
   tblQuyenNhomQuyens = tblQuyenNhomQuyenService.findtblQuyenNhomQuyenByCondition(cons, pageSize, page); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_NhomQuyen Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
