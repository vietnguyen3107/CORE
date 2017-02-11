package com.lb.jwitter.action.core.htmlreport;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider; 
import java.util.Map; 
import java.util.Date; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
import com.lb.jwitter.service.TblQLDTHTMLReportParam;
import com.lb.jwitter.service.TblQLDTHTMLReportParamService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTHTMLReporttblQLDTHTMLReportParamDeleteAction{
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

    private String idList; 
    public String getIdList() { return idList; } 
    public void setIdList(String idList) { this.idList = idList; }

    private int reportId; 
    public int getReportId() { return reportId; } 
    public void setReportId(int reportId) { this.reportId = reportId; }

    private List<TblQLDTHTMLReportParam> tblQLDTHTMLReportParams; 
    public List<TblQLDTHTMLReportParam>  getTblQLDTHTMLReportParams() {
         return tblQLDTHTMLReportParams; 
      } 

    private TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport_Param", "xoa")){ 
        return "noprivilege"; 
    }tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 
     msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    tblQLDTHTMLReportParamService.deleteListTblQLDTHTMLReportParam(ids); 
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
      System.out.println("Loi Delete tbl_QLDT_HTMLReport_Param Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
