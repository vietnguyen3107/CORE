package com.lb.jwitter.action.core.htmlreport;


import java.util.ArrayList; 
import java.util.List; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lb.jwitter.service.CommonService;
import com.lb.jwitter.service.ConditionReport;
import com.lb.jwitter.service.Qresult;
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
public class TblQLDTHTMLReportDuplicateAction{
    private int pageSize; 
    public void setPageSize(int pageSize) {
       this.pageSize = pageSize;
     }

    public int getPageSize() {
       return pageSize;
 }

    private int id;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport", "them")){ 
        return "noprivilege"; 
    } 

    msg = new Message(); 

    CommonService commonService = (CommonService) context.getBean("commonClient"); 
        tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient"); 
        //duplicaet
        String sql =" EXEC sp_HTMLReport_Duplicate " +
				" @htmlReportId = :htmlReportId";
				
				List<String> paramNames = new ArrayList<String>();
				 List<String> paramVals = new ArrayList<String>();
				
				 paramNames.add("htmlReportId"); paramVals.add(id + "");
				 
				 try {
					 List<Qresult> results = commonService.createSQLQueryWithParams(sql,0, paramNames, paramVals, 0, 0);
					 return Action.SUCCESS; 
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return Action.ERROR; 
				}
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
 
