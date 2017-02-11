package com.lb.jwitter.action.core.htmlreport;


import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContext;
import java.util.Map; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import java.util.Date; 
import java.util.GregorianCalendar; 
import javax.xml.datatype.DatatypeFactory; 
import javax.xml.datatype.XMLGregorianCalendar; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQLDTHTMLReportParam;
import com.lb.jwitter.service.TblQLDTHTMLReportParamService;
import com.lb.jwitter.service.TblQLDTHTMLReport;
import com.lb.jwitter.service.TblQLDTHTMLReportService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTHTMLReporttblQLDTHTMLReportParamUpdateAction{
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

    private Message msg; 
    public Message getMsg() { return msg; }

    private int id; 
    public int getId() {
       return id;
 }

    public void setId(int id) {
       this.id = id;
 }

    private int reportId; 
    public void setReportId(int reportId) {
       this.reportId = reportId;
 }

    public int getReportId() {
       return reportId;
 }

    private TblQLDTHTMLReportService tblQLDTHTMLReportService; 

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
 }

    public String getTen() {
       return ten;
 }

    private String label; 
    public void setLabel(String label) {
       this.label = label;
 }

    public String getLabel() {
       return label;
 }

    private String type; 
    public void setType(String type) {
       this.type = type;
 }

    public String getType() {
       return type;
 }

    private String paramSql; 
    public void setParamSql(String paramSql) {
       this.paramSql = paramSql;
 }

    public String getParamSql() {
       return paramSql;
 }

    private String paramVariable; 
    public void setParamVariable(String paramVariable) {
       this.paramVariable = paramVariable;
 }

    public String getParamVariable() {
       return paramVariable;
 }

    private TblQLDTHTMLReportParam tblQLDTHTMLReportParam; 
    public void setTblQLDTHTMLReportParam (TblQLDTHTMLReportParam tblQLDTHTMLReportParam) {
        this.tblQLDTHTMLReportParam = tblQLDTHTMLReportParam;
 }

    private TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService; 

    private List<TblQLDTHTMLReportParam> tblQLDTHTMLReportParams; 
    public List<TblQLDTHTMLReportParam>  getTblQLDTHTMLReportParams() {
        return tblQLDTHTMLReportParams; 
      } 

	private int preUpdate(Message msg, TblQLDTHTMLReportParam obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblQLDTHTMLReportParam obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport_Param", "sua")){ 
        return "noprivilege"; 
    }
        tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 
        tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient"); 

        msg = new Message(); 
        tblQLDTHTMLReportParam = tblQLDTHTMLReportParamService.getTblQLDTHTMLReportParam(new Long(id)); 
        preUpdate(msg,tblQLDTHTMLReportParam); 
        TblQLDTHTMLReport uTblQLDTHTMLReport = new TblQLDTHTMLReport(); 
        uTblQLDTHTMLReport.setId(new Long(reportId));  
        tblQLDTHTMLReportParam.setReportId(reportId <=0 ? null : uTblQLDTHTMLReport );  
        tblQLDTHTMLReportParam.setTen(ten); 
        tblQLDTHTMLReportParam.setLabel(label); 
        tblQLDTHTMLReportParam.setType(type); 
        tblQLDTHTMLReportParam.setParamSql(paramSql); 
        tblQLDTHTMLReportParam.setParamVariable(paramVariable); 
       if (msg.isPreMessage_b()) 
       { 
           tblQLDTHTMLReportParamService.updateTblQLDTHTMLReportParam(tblQLDTHTMLReportParam); 
           postUpdate(msg, tblQLDTHTMLReportParam); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 

       if(pageSizeTblQLDTHTMLReportParam == 0){ 
           pageSizeTblQLDTHTMLReportParam = 20; 
       } 
        if(pageTblQLDTHTMLReportParam == 0){ 
           pageTblQLDTHTMLReportParam =1; 
       } 
        List < ConditionReport > cons = new ArrayList<ConditionReport>(); 
       ConditionReport con = new ConditionReport(); 
        con.setCol("reportId.id"); 
        con.setValue1(new Long(reportId)); 
        con.setOperator("eq"); 
        cons.add(con); 
      tblQLDTHTMLReportParams =       tblQLDTHTMLReportParamService.findTblQLDTHTMLReportParamByCondition(cons,pageSizeTblQLDTHTMLReportParam, pageTblQLDTHTMLReportParam); 
      pagesTblQLDTHTMLReportParam = tblQLDTHTMLReportParamService.countTblQLDTHTMLReportParamByCondition(cons)/pageSizeTblQLDTHTMLReportParam + 1; 
      dataStringTblQLDTHTMLReportParam = ""; 
      dataStringTblQLDTHTMLReportParam += "&id="; 
      dataStringTblQLDTHTMLReportParam += "&reportId="; 
      dataStringTblQLDTHTMLReportParam += "&ten="; 
      dataStringTblQLDTHTMLReportParam += "&label="; 
      dataStringTblQLDTHTMLReportParam += "&type="; 
      dataStringTblQLDTHTMLReportParam += "&paramSql="; 
      dataStringTblQLDTHTMLReportParam += "&paramVariable="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Update tbl_QLDT_HTMLReport_Param Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
