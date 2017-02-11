package com.lb.jwitter.action.core.htmlreport;


import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import java.util.Map; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import java.util.Date; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import java.util.GregorianCalendar; 
import javax.xml.datatype.DatatypeFactory; 
import javax.xml.datatype.XMLGregorianCalendar; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
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
public class TblQLDTHTMLReportInsertAction{
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

    private Message msg; 
    public Message getMsg() { return msg; }

    private Long id; 
    public void setId(Long id) {
       this.id = id;
 }

    private String ma; 
    public void setMa(String ma) {
       this.ma = ma;
 }

    public String getMa() {
       return ma;
 }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
 }

    public String getTen() {
       return ten;
 }

    private String css; 
    public void setCss(String css) {
       this.css = css;
 }

    public String getCss() {
       return css;
 }

    private String javascript; 
    public void setJavascript(String javascript) {
       this.javascript = javascript;
 }

    public String getJavascript() {
       return javascript;
 }

    private String header; 
    public void setHeader(String header) {
       this.header = header;
 }

    public String getHeader() {
       return header;
 }

    private String body; 
    public void setBody(String body) {
       this.body = body;
 }

    public String getBody() {
       return body;
 }

    private String footer; 
    public void setFooter(String footer) {
       this.footer = footer;
 }

    public String getFooter() {
       return footer;
 }

    private String bodySql; 
    public void setBodySql(String bodySql) {
       this.bodySql = bodySql;
 }

    public String getBodySql() {
       return bodySql;
 }

    private String headerSql; 
    public void setHeaderSql(String headerSql) {
       this.headerSql = headerSql;
 }

    public String getHeaderSql() {
       return headerSql;
 }

    private String description; 
    public void setDescription(String description) {
       this.description = description;
 }

    public String getDescription() {
       return description;
 }

    private String type; 
    public void setType(String type) {
       this.type = type;
 }

    public String getType() {
       return type;
 }

    private String fileTemplate; 
    public void setFileTemplate(String fileTemplate) {
       this.fileTemplate = fileTemplate;
 }

    public String getFileTemplate() {
       return fileTemplate;
 }

    private TblQLDTHTMLReport tblQLDTHTMLReport; 
    public TblQLDTHTMLReport  getTblQLDTHTMLReport() {
        return tblQLDTHTMLReport;
 }

    private List<TblQLDTHTMLReport> tblQLDTHTMLReports; 
    public List<TblQLDTHTMLReport>  getTblQLDTHTMLReports() {
         return tblQLDTHTMLReports; 
      } 

    private TblQLDTHTMLReportService tblQLDTHTMLReportService; 

    private List<TblQLDTHTMLReportParam> tblQLDTHTMLReportParams; 
    public List<TblQLDTHTMLReportParam>  getTblQLDTHTMLReportParams() {
         return tblQLDTHTMLReportParams; 
      } 

    private TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService; 

	private int preInsert(Message msg, TblQLDTHTMLReport obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblQLDTHTMLReport obj ){ 
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
        tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient"); 
        tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 

        msg = new Message(); 
        tblQLDTHTMLReport = new TblQLDTHTMLReport(); 
        preInsert(msg,tblQLDTHTMLReport); 
        tblQLDTHTMLReport.setMa(ma); 
        tblQLDTHTMLReport.setTen(ten); 
        tblQLDTHTMLReport.setCss(css); 
        tblQLDTHTMLReport.setJavascript(javascript); 
        tblQLDTHTMLReport.setHeader(header); 
        tblQLDTHTMLReport.setBody(body); 
        tblQLDTHTMLReport.setFooter(footer); 
        tblQLDTHTMLReport.setBodySql(bodySql); 
        tblQLDTHTMLReport.setHeaderSql(headerSql); 
        tblQLDTHTMLReport.setDescription(description); 
        tblQLDTHTMLReport.setType(type); 
        tblQLDTHTMLReport.setFileTemplate(fileTemplate); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblQLDTHTMLReportService.createTblQLDTHTMLReport(tblQLDTHTMLReport); 
           postInsert(msg, tblQLDTHTMLReport); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblQLDTHTMLReport.setId(id); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_QLDT_HTMLReport Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
