package com.lb.jwitter.action.admin;


 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import com.opensymphony.xwork2.ActionContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 import com.opensymphony.xwork2.Action; 
 import com.lb.jwitter.service.ConditionReport; 
 import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQuyen;
 import com.lb.jwitter.service.TblQuyenService;
  /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQuyenFormAction{
    private int pageSize; 
    public int getPageSize() {
       return pageSize;
 }

    private int page; 
    public int getPage() { return page; }

    private int pages; 
    public int getPages() { return pages; }

    private String dataString; 
    public String getDataString() { return dataString; }

    private Collection<TblQuyen> tblQuyens; 
    public Collection<TblQuyen>  getTblQuyens() {
         return tblQuyens; 
      } 

    private TblQuyenService tblQuyenService; 

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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Quyen", "xem")){ 
        return "noprivilege"; 
    }tblQuyenService = (TblQuyenService) context.getBean("tbl_QuyenClient"); 
        if(pageSize == 0){ 
            pageSize = 20; 
        } 
        if(page == 0){ 
            page =1; 
        } 
        tblQuyens =        tblQuyenService.findAlltblQuyen(pageSize, page); 
        pages = tblQuyenService.counttblQuyenByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&ten="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Form tbl_Quyen Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
