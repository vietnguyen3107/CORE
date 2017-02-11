package com.lb.jwitter.action.core.htmlreport;


import java.util.ArrayList; 
import java.util.List; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
import java.util.Map; 
import java.util.Date; 
 import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTHTMLReportSearchAction{
    private int pageSize; 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
     }

    public int getPageSize() {
       return pageSize;
 }

    private int page; 
    public void setPage(int page) { this.page = page;   }

    public int getPage() {
       return page;
   }

    private int num; 
    public int getNum() {
       return num;
   }

    private int pages; 
    public void setPages(int pages) { this.pages = pages;   }

    public int getPages() {
       return pages;
     }

    private String dataString; 
    public void setDataString(String dataString) { this.dataString = dataString;    }

    public String getDataString() {
       return dataString;
    }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
   }

    public String getTen() {
       return ten;
   }

    private String type; 
    public void setType(String type) {
       this.type = type;
   }

    public String getType() {
       return type;
   }

    private List<TblQLDTHTMLReport> tblQLDTHTMLReports; 
    public List<TblQLDTHTMLReport>  getTblQLDTHTMLReports() {
        return tblQLDTHTMLReports; 
      } 

    private TblQLDTHTMLReportService tblQLDTHTMLReportService; 

	private int preSearch(Message msg, List<ConditionReport> cons ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postSearch(Message msg, List<ConditionReport> cons ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport", "xem")){ 
        return "noprivilege"; 
    } 
        tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient"); 
        msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(ten != null && !ten.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ten");
        con.setValue1("%" + ten + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(type != null && !type.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("type");
        con.setValue1("%" + type + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
        preSearch(msg, cons); 
       if (msg.isPreMessage_b()) 
       { 
           if(pageSize == 0){ 
               pageSize = 20; 
           } 
            if(page == 0){ 
               page =1; 
           } 
           tblQLDTHTMLReports = tblQLDTHTMLReportService.findTblQLDTHTMLReportByCondition(cons,pageSize,page); 
       num = tblQLDTHTMLReportService.countTblQLDTHTMLReportByCondition(cons); 
       pages = num/pageSize + 1; 
           postSearch(msg, cons); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
      dataString = ""; 
      dataString += "&ten=" + ten; 
      dataString += "&type=" + type; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_QLDT_HTMLReport Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
