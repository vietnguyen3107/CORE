package com.lb.jwitter.action.core.htmlreport;


import java.util.ArrayList; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import java.util.Map; 
import java.util.Date; 
//import org.springframework.test.context.ContextConfiguration; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.ApplicationContextProvider; 
import java.util.List; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQLDTHTMLReportParam;
import com.lb.jwitter.service.TblQLDTHTMLReportParamService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTHTMLReporttblQLDTHTMLReportParamSearchAction{
    private int pageSize; 
    public int getPageSize() {
        return pageSize;
 }

    public void setPageSize(int pageSizeTblQLDTHTMLReportParam) {        this.pageSize = pageSizeTblQLDTHTMLReportParam; }

    private int page; 
    public int getPage() { return page; }

    public void setPage(int pageTblQLDTHTMLReportParam) { this.page = page; }

    private int pagesTblQLDTHTMLReportParam; 
    public int getPagesTblQLDTHTMLReportParam() { return pagesTblQLDTHTMLReportParam; }

    public void setPagesTblQLDTHTMLReportParam(int pagesTblQLDTHTMLReportParam) { this.pagesTblQLDTHTMLReportParam = pagesTblQLDTHTMLReportParam; }

    private String dataStringTblQLDTHTMLReportParam; 
    public String getDataStringTblQLDTHTMLReportParam() { return dataStringTblQLDTHTMLReportParam; }

    private Message msg; 
    public Message getMsg() { return msg; }

    private int id; 
    public int getId() {
       return id ;
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

    private List<TblQLDTHTMLReportParam> tblQLDTHTMLReportParams; 
    public List<TblQLDTHTMLReportParam>  getTblQLDTHTMLReportParams() {
        return tblQLDTHTMLReportParams; 
      } 

    private TblQLDTHTMLReportParamService tblQLDTHTMLReportParamService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_HTMLReport_Param", "xem")){ 
        return "noprivilege"; 
    }        tblQLDTHTMLReportParamService = (TblQLDTHTMLReportParamService) context.getBean("tbl_QLDT_HTMLReport_ParamClient"); 
        msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(id != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("id");
        con.setValue1(id);
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(reportId != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("reportId.id");
        con.setValue1(new Long(reportId));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(ten != null && !ten.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ten");
        con.setValue1(ten);
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(label != null && !label.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("label");
        con.setValue1(label);
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(type != null && !type.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("type");
        con.setValue1(type);
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(paramSql != null && !paramSql.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("paramSql");
        con.setValue1(paramSql);
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(paramVariable != null && !paramVariable.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("paramVariable");
        con.setValue1(paramVariable);
        con.setOperator("eq");
        cons.add(con);	
    } 
        preSearch(msg, cons); 
       if (msg.isPreMessage_b()) 
       { 
           if(pageSize== 0){ 
               pageSize= 20; 
           } 
            if(page == 0){ 
               page  = 1; 
           } 
           tblQLDTHTMLReportParams = tblQLDTHTMLReportParamService.findTblQLDTHTMLReportParamByCondition(cons,pageSize,page); 
           pagesTblQLDTHTMLReportParam = tblQLDTHTMLReportParamService.countTblQLDTHTMLReportParamByCondition(cons)/pageSize + 1; 
           postSearch(msg, cons); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
      dataStringTblQLDTHTMLReportParam = ""; 
      dataStringTblQLDTHTMLReportParam += "&id=" + id; 
      dataStringTblQLDTHTMLReportParam += "&reportId=" + reportId; 
      dataStringTblQLDTHTMLReportParam += "&ten=" + ten; 
      dataStringTblQLDTHTMLReportParam += "&label=" + label; 
      dataStringTblQLDTHTMLReportParam += "&type=" + type; 
      dataStringTblQLDTHTMLReportParam += "&paramSql=" + paramSql; 
      dataStringTblQLDTHTMLReportParam += "&paramVariable=" + paramVariable; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_QLDT_HTMLReport_Param Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
