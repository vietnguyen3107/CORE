package com.lb.jwitter.action.core.htmlreport;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import java.util.Map; 
import java.util.Date; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.Message; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
public class TblQLDTHTMLReporttblQLDTHTMLReportParamEditFormAction{
    private int id; 
    public void setId(int id) {
       this.id = id;
 }

    public int getId() {
       return id;
 }

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private TblQLDTHTMLReportParam tblQLDTHTMLReportParam; 
    public TblQLDTHTMLReportParam getTblQLDTHTMLReportParam() { 
        return tblQLDTHTMLReportParam; 
    } 
    private TblQLDTHTMLReport tblQLDTHTMLReport; 
    public TblQLDTHTMLReport getTblQLDTHTMLReport() { 
        return tblQLDTHTMLReport; 
    } 
    private List<TblQLDTHTMLReportParam> tblQLDTHTMLReportParams; 
    public List<TblQLDTHTMLReportParam>  getTblQLDTHTMLReportParams() {
         return tblQLDTHTMLReportParams; 
      } 

    private TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService; 

    private List<TblQLDTHTMLReport> tblQLDTHTMLReports; 
    public List<TblQLDTHTMLReport>  getTblQLDTHTMLReports(){ 
              return tblQLDTHTMLReports; 
     } 

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
    public String execute() throws Exception 
   { 
    try{ 
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    today = new Date(); 
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport_Param", "xem")){ 
        return "noprivilege"; 
    }        msg = new Message(); 
        tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 
        tblQLDTHTMLReportService = (TblQLDTHTMLReportService) context.getBean("tbl_QLDT_HTMLReportClient"); 

        tblQLDTHTMLReportParam = tblQLDTHTMLReportParamService.getTblQLDTHTMLReportParam(new Long(id)); 
        tblQLDTHTMLReport = tblQLDTHTMLReportParam.getReportId(); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_QLDT_HTMLReport_Param Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
