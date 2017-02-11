package com.lb.jwitter.action.core.htmlreport;


 import java.util.ArrayList;
 import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
 import com.opensymphony.xwork2.Action; 
 import java.util.Map;

import javax.servlet.http.HttpServletRequest;

 import com.opensymphony.xwork2.ActionContext;
import com.lb.jwitter.service.CommonService;
import com.lb.jwitter.service.ConditionReport;
import com.lb.jwitter.service.Qresult;
import com.lb.jwitter.service.TblQuyenChiTietService;
import com.lb.jwitter.service.TblTaiKhoan;
import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportParam;
import com.lb.jwitter.service.TblQLDTHTMLReportParamService;
import com.lb.jwitter.service.TblQLDTHTMLReportService;
  /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class HtmlReportViewAction{
  
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
	
	private String header;
	private String body;
	private String footer;
public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	private List<Qresult> results;
	private List<Qresult> resultHeaders;
	
	
	
	public List<Qresult> getResults() {
		return results;
	}
	public void setResults(List<Qresult> results) {
		this.results = results;
	}
	public List<Qresult> getResultHeaders() {
		return resultHeaders;
	}
	public void setResultHeaders(List<Qresult> resultHeaders) {
		this.resultHeaders = resultHeaders;
	}
public String execute() throws Exception 
{ 
	 try{ 	
		    Map session = ActionContext.getContext().getSession();
		    taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
		    if( taiKhoanDangNhap == null) return "noprivilege";
		  
		    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
		    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
		
		    CommonService commonService = (CommonService) context
        			.getBean("commonClient");
		    tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient");
		    TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 
		    
		    HttpServletRequest request = ServletActionContext.getRequest();
		    
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
	        
	        String sql = report.getBodySql();

            String headerSql = report.getHeaderSql();
            
	        for (TblQLDTHTMLReportParam param : params) {

                String key = param.getTen();
                String value = request.getParameter(param.getTen());

               
                //body SQL
                if(sql != null && sql.contains("{" + key + "}")){
                    
                    sql = sql.replace("{" + key + "}", "" + value + "");

                }
                //header SQL
                if(headerSql != null && headerSql.contains("{" + key + "}")){

                    headerSql = headerSql.replace("{" + key + "}", "" + value + "");
                }
            }
	        
	        if(report.getType().trim().toUpperCase().equals("TEMPLATE")){
                //header template
                if(report.getHeaderSql() != null && !report.getHeaderSql().equals("")) {
                    try {

                        resultHeaders = commonService.querySQLWithParamsAliasTransformer(headerSql, null, null, 0, 0);

                    }catch (Exception e)
                    {

                    }

                }
                //body template               
                results = commonService.querySQLWithParamsAliasTransformer(sql, null, null, 0, 0);
                
                header = StringUtils.substringBetween(report.getBody(), "[header]", "[/header]");

                body = StringUtils.substringBetween(report.getBody(), "[loop]", "[/loop]");
                footer = StringUtils.substringBetween(report.getBody(), "[footer]", "[/footer]");


                return "reportByTemplate";


            }
		      
	        return Action.SUCCESS; 
	      } 
	      catch(Exception e){ 
	      System.out.println("Loi Form tbl_QLDT_HTMLReport Action"); 
	     e.printStackTrace();  
	    return Action.ERROR; 
	 } 
 } 
 } 
 
