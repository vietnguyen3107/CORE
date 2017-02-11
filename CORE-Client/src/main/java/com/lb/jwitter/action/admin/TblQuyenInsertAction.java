package com.lb.jwitter.action.admin;


import net.sf.json.JSONArray; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider; 
import net.sf.json.JSONObject; 
import net.sf.json.JSONSerializer; 
import java.util.Map; 
import com.opensymphony.xwork2.ActionContext; 
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.Collection; 
import java.util.Date; 
import java.util.GregorianCalendar; 
import javax.xml.datatype.DatatypeFactory; 
import javax.xml.datatype.XMLGregorianCalendar; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQuyen;
import com.lb.jwitter.service.TblQuyenService;
import com.lb.jwitter.service.TblQuyenChiTiet;

import com.lb.jwitter.service.TblQuyenChiTietService;

import com.lb.jwitter.service.TblDBTableService;

import com.lb.jwitter.service.TblQuyenMenu;

import com.lb.jwitter.service.TblQuyenMenuService;

import com.lb.jwitter.service.TblMenuService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQuyenInsertAction{
    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    private int page; 
    public int getPage() { return page; }

    private int pages; 
    public int getPages() { return pages; }

    private String dataString; 
    public String getDataString() { return dataString; }

    private Message msg; 
    public Message getMsg() { return msg; }

    private Long id; 
    public void setId(Long id) {
       this.id = id;
 }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
 }

    public String getTen() {
       return ten;
 }

    private String ghiChu; 
    public void setGhiChu(String ghiChu) {
       this.ghiChu = ghiChu;
 }

    public String getGhiChu() {
       return ghiChu;
 }

    private TblQuyen tblQuyen; 
    public TblQuyen  getTblQuyen() {
        return tblQuyen;
 }

    private Collection<TblQuyen> tblQuyens; 
    public Collection<TblQuyen>  getTblQuyens() {
         return tblQuyens; 
      } 

    private TblQuyenService tblQuyenService; 

    private String tblQuyenChiTietStr; 
    public void setTblQuyenChiTietStr(String tblQuyenChiTietStr) 
{
       this.tblQuyenChiTietStr = tblQuyenChiTietStr;
 }

    public String getTblQuyenChiTietStr() 
 {
       return tblQuyenChiTietStr;
 }


    private TblDBTableService tblDBTableService; 

    private String tblQuyenMenuStr; 
    public void setTblQuyenMenuStr(String tblQuyenMenuStr) 
{
       this.tblQuyenMenuStr = tblQuyenMenuStr;
 }

    public String getTblQuyenMenuStr() 
 {
       return tblQuyenMenuStr;
 }

    private TblQuyenMenuService tblQuyenMenuService; 

    private TblMenuService tblMenuService; 

	private int preInsert(Message msg, TblQuyen obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblQuyen obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Quyen", "them")){ 
        return "noprivilege"; 
    }        tblQuyenService = (TblQuyenService) context.getBean("tbl_QuyenClient"); 
        tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 

        tblDBTableService = (TblDBTableService) context.getBean("tbl_DBTableClient"); 

        tblQuyenMenuService = (TblQuyenMenuService) context.getBean("tbl_Quyen_MenuClient"); 

        tblMenuService = (TblMenuService) context.getBean("tbl_MenuClient"); 

        msg = new Message(); 
        tblQuyen = new TblQuyen(); 
        tblQuyen.setTen(ten); 
        tblQuyen.setGhiChu(ghiChu); 
        preInsert(msg,tblQuyen); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblQuyenService.createtblQuyen(tblQuyen); 
           postInsert(msg, tblQuyen); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblQuyen.setId(id); 
JSONArray jsonTblQuyenChiTiet = (JSONArray)JSONSerializer.toJSON(tblQuyenChiTietStr); 
for (int i = 0; i < jsonTblQuyenChiTiet.size(); i++) 
 { 
      JSONObject jsObj = jsonTblQuyenChiTiet.getJSONObject(i); 
        TblQuyenChiTiet obj0 = new TblQuyenChiTiet(); 
       obj0.setXem(jsObj.getBoolean("xem") ); 
       obj0.setThem(jsObj.getBoolean("them") ); 
       obj0.setXoa(jsObj.getBoolean("xoa") ); 
       obj0.setSua(jsObj.getBoolean("sua") ); 
       obj0.setQuyenId(tblQuyen); 
        obj0.setBangId(tblDBTableService.gettblDBTable(new Long(jsObj.getInt("bangId")))); 
       tblQuyenChiTietService.createtblQuyenChiTiet(obj0); 
   } 
JSONArray jsonTblQuyenMenu = (JSONArray)JSONSerializer.toJSON(tblQuyenMenuStr); 
for (int i = 0; i < jsonTblQuyenMenu.size(); i++) 
 { 
      JSONObject jsObj = jsonTblQuyenMenu.getJSONObject(i); 
        TblQuyenMenu obj1 = new TblQuyenMenu(); 

        obj1.setMenuId(tblMenuService.gettblMenu(new Long(jsObj.getInt("menuId")))); 
       obj1.setQuyenId(tblQuyen); 
       tblQuyenMenuService.createtblQuyenMenu(obj1); 
   } 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_Quyen Action"); 
         e.printStackTrace(); 
         return Action.ERROR; 
 } 
 } 
 } 
 
