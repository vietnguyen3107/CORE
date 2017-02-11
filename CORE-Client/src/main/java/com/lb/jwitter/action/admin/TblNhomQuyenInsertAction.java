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
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblNhomQuyen;
import com.lb.jwitter.service.TblNhomQuyenService;
import com.lb.jwitter.service.TblQuyenNhomQuyen;

import com.lb.jwitter.service.TblQuyenNhomQuyenService;

import com.lb.jwitter.service.TblQuyenService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblNhomQuyenInsertAction{
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

    private String tenNhomQuyen; 
    public void setTenNhomQuyen(String tenNhomQuyen) {
       this.tenNhomQuyen = tenNhomQuyen;
 }

    public String getTenNhomQuyen() {
       return tenNhomQuyen;
 }

    private String defaultPage; 
    public void setDefaultPage(String defaultPage) {
       this.defaultPage = defaultPage;
 }

    public String getDefaultPage() {
       return defaultPage;
 }

    private TblNhomQuyen tblNhomQuyen; 
    public TblNhomQuyen  getTblNhomQuyen() {
        return tblNhomQuyen;
 }

    private Collection<TblNhomQuyen> tblNhomQuyens; 
    public Collection<TblNhomQuyen>  getTblNhomQuyens() {
         return tblNhomQuyens; 
      } 

    private TblNhomQuyenService tblNhomQuyenService; 

    private String tblQuyenNhomQuyenStr; 
    public void setTblQuyenNhomQuyenStr(String tblQuyenNhomQuyenStr) 
{
       this.tblQuyenNhomQuyenStr = tblQuyenNhomQuyenStr;
 }

    public String getTblQuyenNhomQuyenStr() 
 {
       return tblQuyenNhomQuyenStr;
 }

    private TblQuyenNhomQuyenService tblQuyenNhomQuyenService; 

    private TblQuyenService tblQuyenService; 

	private int preInsert(Message msg, TblNhomQuyen obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblNhomQuyen obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_NhomQuyen", "them")){ 
        return "noprivilege"; 
    }        tblNhomQuyenService = (TblNhomQuyenService) context.getBean("tbl_NhomQuyenClient"); 
        tblQuyenNhomQuyenService = (TblQuyenNhomQuyenService) context.getBean("tbl_Quyen_NhomQuyenClient"); 

        tblQuyenService = (TblQuyenService) context.getBean("tbl_QuyenClient"); 

        msg = new Message(); 
        tblNhomQuyen = new TblNhomQuyen(); 
        tblNhomQuyen.setTenNhomQuyen(tenNhomQuyen); 
        tblNhomQuyen.setDefaultPage(defaultPage); 
        preInsert(msg,tblNhomQuyen); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblNhomQuyenService.createtblNhomQuyen(tblNhomQuyen); 
           postInsert(msg, tblNhomQuyen); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblNhomQuyen.setId(id); 
JSONArray jsonTblQuyenNhomQuyen = (JSONArray)JSONSerializer.toJSON(tblQuyenNhomQuyenStr); 
for (int i = 0; i < jsonTblQuyenNhomQuyen.size(); i++) 
 { 
      JSONObject jsObj = jsonTblQuyenNhomQuyen.getJSONObject(i); 
        TblQuyenNhomQuyen obj0 = new TblQuyenNhomQuyen(); 
        obj0.setMaQuyen(tblQuyenService.gettblQuyen(new Long(jsObj.getInt("maQuyen")))); 
       obj0.setMaNhomQuyen(tblNhomQuyen); 
       tblQuyenNhomQuyenService.createtblQuyenNhomQuyen(obj0); 
   } 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_NhomQuyen Action"); 
         e.printStackTrace(); 
         return Action.ERROR; 
 } 
 } 
 } 
 
