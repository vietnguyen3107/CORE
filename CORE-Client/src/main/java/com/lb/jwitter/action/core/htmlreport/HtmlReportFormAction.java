package com.lb.jwitter.action.core.htmlreport;


 import java.util.ArrayList;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 import com.opensymphony.xwork2.Action; 
 import java.util.Map; 
import java.util.Date; 
 import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.service.ConditionReport; 
 import com.lb.jwitter.util.Message; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportParam;
import com.lb.jwitter.service.TblQLDTHTMLReportParamService;
import com.lb.jwitter.service.TblQLDTHTMLReportService;
  /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class HtmlReportFormAction{
  
    private TblQLDTHTMLReportService tblQLDTHTMLReportService; 

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
	 
	 private int reportId;
	 public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	List<TblQLDTHTMLReportParam> params;
	public List<TblQLDTHTMLReportParam> getParams() {
		return params;
	}
	public void setParams(List<TblQLDTHTMLReportParam> params) {
		this.params = params;
	}
	TblQLDTHTMLReport report;
	
	
	public TblQLDTHTMLReport getReport() {
		return report;
	}
	public void setReport(TblQLDTHTMLReport report) {
		this.report = report;
	}
public String execute() throws Exception 
{ 
	 try{ 	
		    Map session = ActionContext.getContext().getSession();
		    taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
		    if( taiKhoanDangNhap == null) return "noprivilege";
		  
		    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
		    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
		
	
		    tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient");
		    TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 
		    
		    report = tblQLDTHTMLReportService.getTblQLDTHTMLReport(new Long(reportId));
		    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), report.getMa(), "xem")){ 
		        return "noprivilege"; 
		    }
		    List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
	        { 
		        ConditionReport con = new ConditionReport(); 
		        con.setCol("reportId.id");
		        con.setValue1(report.getId());
		        con.setOperator("eq");
		        cons.add(con);	
	        } 
	        
	        params = tblQLDTHTMLReportParamService.findTblQLDTHTMLReportParamByCondition(cons, 0, 0);
	        
	        
		      
	        return Action.SUCCESS; 
	      } 
	      catch(Exception e){ 
	      System.out.println("Loi Form tbl_QLDT_HTMLReport Action"); 
	     e.printStackTrace();  
	    return Action.ERROR; 
	 } 
 } 
 } 
 
