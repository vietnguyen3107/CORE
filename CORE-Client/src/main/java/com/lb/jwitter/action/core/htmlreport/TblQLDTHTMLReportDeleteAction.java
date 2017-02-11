package com.lb.jwitter.action.core.htmlreport;

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
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTHTMLReportDeleteAction{
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

    private List<TblQLDTHTMLReport> tblQLDTHTMLReports; 
    public List<TblQLDTHTMLReport>  getTblQLDTHTMLReports() {
         return tblQLDTHTMLReports; 
      } 

    private TblQLDTHTMLReportService tblQLDTHTMLReportService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport", "xoa")){ 
        return "noprivilege"; 
    } 
tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient"); 
     msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    tblQLDTHTMLReportService.deleteListTblQLDTHTMLReport(ids); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblQLDTHTMLReports =       tblQLDTHTMLReportService.findAllTblQLDTHTMLReport(pageSize, page); 
      pages = tblQLDTHTMLReportService.countTblQLDTHTMLReportByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ma="; 
      dataString += "&ten="; 
      dataString += "&css="; 
      dataString += "&javascript="; 
      dataString += "&header="; 
      dataString += "&body="; 
      dataString += "&footer="; 
      dataString += "&bodySql="; 
      dataString += "&headerSql="; 
      dataString += "&description="; 
      dataString += "&type="; 
      dataString += "&fileTemplate="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Delete tbl_QLDT_HTMLReport Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
