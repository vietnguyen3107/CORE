package com.lb.jwitter.action.admin;


import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import javax.xml.datatype.DatatypeFactory;  
import javax.xml.datatype.XMLGregorianCalendar;  
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
import com.lb.jwitter.service.TblQLDTConfig;
import com.lb.jwitter.service.TblQLDTConfigService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTConfigAction{
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

    private String giaTri; 
    public void setGiaTri(String giaTri) {
       this.giaTri = giaTri;
 }

    public String getGiaTri() {
       return giaTri;
 }

    private TblQLDTConfig tblQLDTConfig; 
    public TblQLDTConfig getTblQLDTConfig () {
        return this.tblQLDTConfig ;
 }

    private Collection<TblQLDTConfig> tblQLDTConfigs; 
    public Collection<TblQLDTConfig> getTblQLDTConfigs() {
        return this.tblQLDTConfigs; 
      } 

    private TblQLDTConfigService tblQLDTConfigService; 

	private int preUpdate(Message msg, TblQLDTConfig obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblQLDTConfig obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_Config", "sua")){ 
        return "noprivilege"; 
    } 
           tblQLDTConfigService = (TblQLDTConfigService)context.getBean("tbl_QLDT_ConfigClient"); 
        msg = new Message(); 
        tblQLDTConfig = tblQLDTConfigService.gettblQLDTConfig(new Long(id)); 
        tblQLDTConfig.setTen(ten); 
        tblQLDTConfig.setGiaTri(giaTri); 
        preUpdate(msg,tblQLDTConfig); 
       if (msg.isPreMessage_b()) 
       { 
           tblQLDTConfigService.updatetblQLDTConfig(tblQLDTConfig); 
           postUpdate(msg, tblQLDTConfig); 
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
      tblQLDTConfigs =       tblQLDTConfigService.findAlltblQLDTConfig(pageSize, page); 
      pages = tblQLDTConfigService.counttblQLDTConfigByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&giaTri="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Update tbl_QLDT_Config Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_Config", "xem")){ 
        return "noprivilege"; 
    } 
           tblQLDTConfigService = (TblQLDTConfigService)context.getBean("tbl_QLDT_ConfigClient"); 
       if(pageSize == 0){ 
            pageSize = 20; 
        } 
        if(page == 0){ 
            page =1; 
        } 
        tblQLDTConfigs =        tblQLDTConfigService.findAlltblQLDTConfig(pageSize, page); 
        pages = tblQLDTConfigService.counttblQLDTConfigByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&giaTri="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Form tbl_QLDT_Config Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_Config", "xoa")){ 
        return "noprivilege"; 
    }           tblQLDTConfigService = (TblQLDTConfigService)context.getBean("tbl_QLDT_ConfigClient"); 
    msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    for(String id : ids){ 
        tblQLDTConfigService.deleteListtblQLDTConfig(ids); 
    } 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblQLDTConfigs =       tblQLDTConfigService.findAlltblQLDTConfig(pageSize, page); 
      pages = tblQLDTConfigService.counttblQLDTConfigByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&giaTri="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Delete tbl_QLDT_Config Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 	private int preInsert(Message msg, TblQLDTConfig obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblQLDTConfig obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_Config", "them")){ 
        return "noprivilege"; 
    }           tblQLDTConfigService = (TblQLDTConfigService)context.getBean("tbl_QLDT_ConfigClient"); 
        msg = new Message(); 
        tblQLDTConfig = new TblQLDTConfig(); 
        tblQLDTConfig.setTen(ten); 
        tblQLDTConfig.setGiaTri(giaTri); 
        preInsert(msg,tblQLDTConfig); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblQLDTConfigService.createtblQLDTConfig(tblQLDTConfig); 
           postInsert(msg, tblQLDTConfig); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblQLDTConfig.setId(id); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblQLDTConfigs =       tblQLDTConfigService.findAlltblQLDTConfig(pageSize, page); 
      pages = tblQLDTConfigService.counttblQLDTConfigByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&ten="; 
      dataString += "&giaTri="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_QLDT_Config Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_Config", "xem")){ 
        return "noprivilege"; 
    } 
           tblQLDTConfigService = (TblQLDTConfigService)context.getBean("tbl_QLDT_ConfigClient"); 
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
    if(giaTri != null && !giaTri.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("giaTri");
        con.setValue1("%" + giaTri + "%");
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
           tblQLDTConfigs = tblQLDTConfigService.findtblQLDTConfigByCondition(cons,pageSize,page); 
           pages = tblQLDTConfigService.counttblQLDTConfigByCondition(cons)/pageSize + 1; 
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
      dataString += "&giaTri=" + giaTri; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_QLDT_Config Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDT_Config", "sua")){ 
        return "noprivilege"; 
    } 
           tblQLDTConfigService = (TblQLDTConfigService)context.getBean("tbl_QLDT_ConfigClient"); 
        tblQLDTConfig = tblQLDTConfigService.gettblQLDTConfig(new Long(id)); 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_QLDT_Config Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
