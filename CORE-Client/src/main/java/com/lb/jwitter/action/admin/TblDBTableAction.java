package com.lb.jwitter.action.admin;


import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.Collection; 
import java.util.Date; 
import com.lb.jwitter.service.ConditionReport; 
import org.springframework.context.support.ClassPathXmlApplicationContext; 
import com.lb.jwitter.util.Message; 
import java.util.Collections; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import java.util.List; 
import java.util.Map; 
import com.lb.jwitter.util.ApplicationContextProvider; 
 import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan; 
import com.lb.jwitter.service.TblDBTable;
import com.lb.jwitter.service.TblDBTableService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblDBTableAction{
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

    private String idList; 
    public String getIdList() { return idList; } 
    public void setIdList(String idList) { this.idList = idList; }

    private Message msg; 
    public Message getMsg() { return msg; }

    private Long id; 
    public Long getId() {
       return id;
 }

    public void setId(Long id) {
       this.id = id;
 }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
 }

    public String getTen() {
       return ten;
 }

    private String tenTV; 
    public void setTenTV(String tenTV) {
       this.tenTV = tenTV;
 }

    public String getTenTV() {
       return tenTV;
 }

    private TblDBTable tblDBTable; 
    public TblDBTable getTblDBTable () {
        return this.tblDBTable ;
 }

    private Collection<TblDBTable> tblDBTables; 
    public Collection<TblDBTable> getTblDBTables() {
        return this.tblDBTables; 
      } 

    private TblDBTableService tblDBTableService; 

	private int preUpdate(Message msg, TblDBTable obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblDBTable obj ){ 
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
 public String update() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DBTable", "sua")){ 
        return "noprivilege"; 
    }           tblDBTableService = (TblDBTableService)context.getBean("tbl_DBTableClient"); 
        msg = new Message(); 
        tblDBTable = tblDBTableService.gettblDBTable(new Long(id)); 
        tblDBTable.setTen(ten); 
        tblDBTable.setTenTV(tenTV); 
        preUpdate(msg,tblDBTable); 
       if (msg.isPreMessage_b()) 
       { 
           tblDBTableService.updatetblDBTable(tblDBTable); 
           postUpdate(msg, tblDBTable); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 

       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblDBTables =       tblDBTableService.findAlltblDBTable(pageSize, page); 
      //pages = tblDBTableService.counttblDBTableByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&tenTV="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Update tbl_DBTable Action"); 
         e.printStackTrace(); 
         return Action.ERROR; 
 } 
 } 
  public String form() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DBTable", "xem")){ 
        return "noprivilege"; 
    }           tblDBTableService = (TblDBTableService)context.getBean("tbl_DBTableClient"); 
       if(pageSize == 0){ 
            pageSize = 20; 
        } 
        if(page == 0){ 
            page =1; 
        } 
        tblDBTables =        tblDBTableService.findAlltblDBTable(pageSize, page); 
        pages = tblDBTableService.counttblDBTableByCondition(new ArrayList<ConditionReport>())/pageSize + 1;
        //tblDBTableService.c
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&tenTV="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Form tbl_DBTable Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
  public String delete() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DBTable", "xoa")){ 
        return "noprivilege"; 
    }           tblDBTableService = (TblDBTableService)context.getBean("tbl_DBTableClient"); 
    msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    for(String id : ids){ 
        tblDBTableService.deleteListtblDBTable(ids); 
    } 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblDBTables =       tblDBTableService.findAlltblDBTable(pageSize, page); 
      pages = tblDBTableService.counttblDBTableByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&tenTV="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Delete tbl_DBTable Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 	private int preInsert(Message msg, TblDBTable obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblDBTable obj ){ 
        msg.setPostMessage_b(true); 
        msg.setPostMessage_s("success"); 
        return 1; 
    } 
 public String insert() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DBTable", "them")){ 
        return "noprivilege"; 
    }           tblDBTableService = (TblDBTableService)context.getBean("tbl_DBTableClient"); 
        msg = new Message(); 
        tblDBTable = new TblDBTable(); 
        tblDBTable.setTen(ten); 
        tblDBTable.setTenTV(tenTV); 
        preInsert(msg,tblDBTable); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblDBTableService.createtblDBTable(tblDBTable); 
           postInsert(msg, tblDBTable); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblDBTable.setId(id); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblDBTables =       tblDBTableService.findAlltblDBTable(pageSize, page); 
      pages = tblDBTableService.counttblDBTableByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&tenTV="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_DBTable Action"); 
         e.printStackTrace(); 
         return Action.ERROR; 
 } 
 } 
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
 public String search() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DBTable", "xem")){ 
        return "noprivilege"; 
    }           tblDBTableService = (TblDBTableService)context.getBean("tbl_DBTableClient"); 
        msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(id!= null && !id.equals(0)){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("id");
        con.setValue1(new Long(id));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(ten != null && !ten.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ten");
        con.setValue1("%" + ten + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(tenTV != null && !tenTV.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("tenTV");
        con.setValue1("%" + tenTV + "%");
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
           tblDBTables = tblDBTableService.findtblDBTableByCondition(cons,pageSize,page); 
           pages = tblDBTableService.counttblDBTableByCondition(cons)/pageSize + 1; 
           postSearch(msg, cons); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
      dataString = ""; 
      dataString += "&id=" + id; 
      dataString += "&ten=" + ten; 
      dataString += "&tenTV=" + tenTV; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_DBTable Action"); 
         e.printStackTrace(); 
         return Action.ERROR; 
 } 
 } 
  public String editForm() throws Exception 
{ 
 try{ 	
     Map session = ActionContext.getContext().getSession();
     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
     if( taiKhoanDangNhap == null) return "noprivilege";
    ApplicationContext context = ApplicationContextProvider.getApplicationContext(); 
    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_DBTable", "sua")){ 
        return "noprivilege"; 
    }           tblDBTableService = (TblDBTableService)context.getBean("tbl_DBTableClient"); 
        tblDBTable = tblDBTableService.gettblDBTable(new Long(id)); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_DBTable Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 }
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public void setPage(int page) {
	this.page = page;
}
public void setPages(int pages) {
	this.pages = pages;
} 
 } 
 
