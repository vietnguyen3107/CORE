package com.lb.jwitter.action.core.htmlreport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import java.util.Map; 
import java.util.Date; 
import com.lb.jwitter.util.Message; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import com.lb.jwitter.service.ConditionReport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportService;
import com.lb.jwitter.service.TblQLDTHTMLReportParam;
import com.lb.jwitter.service.TblQLDTHTMLReportParamService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTHTMLReportEditFormAction{
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

    private int id; 
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private TblQLDTHTMLReport tblQLDTHTMLReport; 
    public TblQLDTHTMLReport getTblQLDTHTMLReport() { 
        return tblQLDTHTMLReport; 
    } 
    private List<TblQLDTHTMLReport> tblQLDTHTMLReports; 
    public List<TblQLDTHTMLReport>  getTblQLDTHTMLReports() {
         return tblQLDTHTMLReports; 
      } 

    private TblQLDTHTMLReportService tblQLDTHTMLReportService; 

    private List<TblQLDTHTMLReportParam> tblQLDTHTMLReportParams; 
    public List<TblQLDTHTMLReportParam>  getTblQLDTHTMLReportParams(){ 
              return tblQLDTHTMLReportParams; 
     } 

    private TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService; 

    private int pageSizeTblQLDTHTMLReportParam; 
    public int getPageSizeTblQLDTHTMLReportParam() {
        return pageSizeTblQLDTHTMLReportParam;
 }

    public void setPageSizeTblQLDTHTMLReportParam(int pageSizeTblQLDTHTMLReportParam) {        this.pageSizeTblQLDTHTMLReportParam = pageSizeTblQLDTHTMLReportParam; }

    private int pageTblQLDTHTMLReportParam; 
    public int getPageTblQLDTHTMLReportParam() { return pageTblQLDTHTMLReportParam; }

    public void setPageTblQLDTHTMLReportParam(int pageTblQLDTHTMLReportParam) { this.pageTblQLDTHTMLReportParam = pageTblQLDTHTMLReportParam; }

    private int pagesTblQLDTHTMLReportParam; 
    public int getPagesTblQLDTHTMLReportParam() { return pagesTblQLDTHTMLReportParam; }

    public void setPagesTblQLDTHTMLReportParam(int pagesTblQLDTHTMLReportParam) { this.pagesTblQLDTHTMLReportParam = pagesTblQLDTHTMLReportParam; }

    private String dataStringTblQLDTHTMLReportParam; 
    public String getDataStringTblQLDTHTMLReportParam() { return dataStringTblQLDTHTMLReportParam; }

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport", "sua")){ 
        return "noprivilege"; 
    }
        msg = new Message(); 
        tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient"); 
        tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 

        tblQLDTHTMLReport = tblQLDTHTMLReportService.getTblQLDTHTMLReport(new Long(id)); 
   if (pageSize == 0) 
   { 
       pageSize = 20; 
   } 
   if (page == 0) 
   { 
       page = 1; 
   } 
   List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
cons.clear(); 
   if (id != 0) 
   { 
       ConditionReport con = new ConditionReport(); 
       con.setCol("reportId.id"); 
       con.setValue1(new Long(id)); 
       con.setOperator("eq"); 
       cons.add(con); 
   } 
   tblQLDTHTMLReportParams = tblQLDTHTMLReportParamService.findTblQLDTHTMLReportParamByCondition(cons, pageSize, page); 
    pageTblQLDTHTMLReportParam = page; 
    pageSizeTblQLDTHTMLReportParam = pageSize; 
 
    pagesTblQLDTHTMLReportParam =tblQLDTHTMLReportParamService.countTblQLDTHTMLReportParamByCondition(cons)/pageSizeTblQLDTHTMLReportParam + 1; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_QLDT_HTMLReport Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
