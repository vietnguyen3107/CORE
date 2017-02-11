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
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblCanBo;
import com.lb.jwitter.service.TblCanBoService;

import com.lb.jwitter.service.TblDonVi;
import com.lb.jwitter.service.TblDonViService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblCanBoDeleteAction{
    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    private int page; 
    public int getPage() { return page; }

    public void setPage(int page) { this.page = page; }

    private int pages; 
    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }

    private String dataString; 
    public String getDataString() { return dataString; }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private String idList; 
    public String getIdList() { return idList; } 
    public void setIdList(String idList) { this.idList = idList; }

    private List<TblCanBo> tblCanBos; 
    public List<TblCanBo>  getTblCanBos() {
         return tblCanBos; 
      } 

    private TblCanBoService tblCanBoService; 

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
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_CanBo", "xoa")){ 
        return "noprivilege"; 
    }tblCanBoService = (TblCanBoService) context.getBean("tbl_CanBoClient"); 
     msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    tblCanBoService.deleteListtblCanBo(ids); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblCanBos =       tblCanBoService.findAlltblCanBo(pageSize, page); 
      pages = tblCanBoService.counttblCanBoByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&ghiChu="; 
      dataString += "&maQuanLy="; 
      dataString += "&ngaySinh="; 
      dataString += "&noiSinh="; 
      dataString += "&diaChi="; 
      dataString += "&dienThoai="; 
      dataString += "&trinhDo="; 
      dataString += "&ngheNghiep="; 
      dataString += "&noiLam="; 
      dataString += "&donViId="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Delete tbl_CanBo Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
