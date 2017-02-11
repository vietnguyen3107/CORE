package com.lb.jwitter.action.admin;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider; 
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action; 
import java.util.Map; 
import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblNhomQuyen;
import com.lb.jwitter.service.TblNhomQuyenService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblNhomQuyenDeleteAction{
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

    private String idList; 
    public String getIdList() { return idList; } 
    public void setIdList(String idList) { this.idList = idList; }

    private Collection<TblNhomQuyen> tblNhomQuyens; 
    public Collection<TblNhomQuyen>  getTblNhomQuyens() {
         return tblNhomQuyens; 
      } 

    private TblNhomQuyenService tblNhomQuyenService; 

	private int preDelete(Message msg, String ids ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postDelete(Message msg, String ids ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_NhomQuyen", "xoa")){ 
        return "noprivilege"; 
    }tblNhomQuyenService = (TblNhomQuyenService) context.getBean("tbl_NhomQuyenClient"); 
     msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    tblNhomQuyenService.deleteListtblNhomQuyen(ids); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblNhomQuyens =       tblNhomQuyenService.findAlltblNhomQuyen(pageSize, page); 
      pages = tblNhomQuyenService.counttblNhomQuyenByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&tenNhomQuyen="; 
      dataString += "&defaultPage="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Delete tbl_NhomQuyen Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
