package com.lb.jwitter.action.admin;


import java.util.ArrayList; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import com.lb.jwitter.service.ConditionReport; 
import com.lb.jwitter.util.Message; 
import java.util.Map; 
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblNhomQuyen;
import com.lb.jwitter.service.TblNhomQuyenService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblNhomQuyenSearchAction{
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

    private Message msg; 
    public Message getMsg() { return msg; }

    private String tenNhomQuyen; 
    public void setTenNhomQuyen(String tenNhomQuyen) {
       this.tenNhomQuyen = tenNhomQuyen;
   }

    public String getTenNhomQuyen() {
       return tenNhomQuyen;
   }

    private String defaultPage; 
    public void setDefaultPage(String defaultPage) {
       this.defaultPage = defaultPage;
   }

    public String getDefaultPage() {
       return defaultPage;
   }

    private List<TblNhomQuyen> tblNhomQuyens; 
    public List<TblNhomQuyen>  getTblNhomQuyens() {
        return tblNhomQuyens; 
      } 

    private TblNhomQuyenService tblNhomQuyenService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_NhomQuyen", "xem")){ 
        return "noprivilege"; 
    }        
    
    tblNhomQuyenService = (TblNhomQuyenService) context.getBean("tbl_NhomQuyenClient"); 
        msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(tenNhomQuyen != null && !tenNhomQuyen.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("tenNhomQuyen");
        con.setValue1("%" + tenNhomQuyen + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(defaultPage != null && !defaultPage.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("defaultPage");
        con.setValue1("%" + defaultPage + "%");
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
           tblNhomQuyens = tblNhomQuyenService.findtblNhomQuyenByCondition(cons,pageSize,page); 
           pages = tblNhomQuyenService.counttblNhomQuyenByCondition(cons)/pageSize + 1; 
           postSearch(msg, cons); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
      dataString = ""; 
      dataString += "&tenNhomQuyen=" + tenNhomQuyen; 
      dataString += "&defaultPage=" + defaultPage; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_NhomQuyen Action"); 
         e.printStackTrace(); 
         return Action.ERROR; 
 } 
 } 
 } 
 
