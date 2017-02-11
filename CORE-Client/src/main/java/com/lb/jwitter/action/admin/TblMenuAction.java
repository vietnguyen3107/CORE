package com.lb.jwitter.action.admin;


import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.GregorianCalendar; 
import javax.xml.datatype.DatatypeFactory;  
import javax.xml.datatype.XMLGregorianCalendar;  
import java.util.ArrayList; 
import java.util.List; 
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
import com.lb.jwitter.service.TblMenu;
import com.lb.jwitter.service.TblMenuService;

import com.lb.jwitter.service.TblMenu;
import com.lb.jwitter.service.TblMenuService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblMenuAction{
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

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private Long id; 
    public Long getId() {
       return id;
 }

    public void setId(Long id) {
       this.id = id;
 }

    private String url; 
    public void setUrl(String url) {
       this.url = url;
 }

    public String getUrl() {
       return url;
 }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
 }

    public String getTen() {
       return ten;
 }

    private int menuCha; 
    public void setMenuCha(int menuCha) {
       this.menuCha = menuCha;
 }

    public int getMenuCha() {
       return menuCha;
 }

    private String hinh; 
    public void setHinh(String hinh) {
       this.hinh = hinh;
 }

    public String getHinh() {
       return hinh;
 }

    private String menuId; 
    public void setMenuId(String menuId) {
       this.menuId = menuId;
 }

    public String getMenuId() {
       return menuId;
 }

    private String nhom; 
    public void setNhom(String nhom) {
       this.nhom = nhom;
 }

    public String getNhom() {
       return nhom;
 }

    private int sTT; 
    public void setSTT(int sTT) {
       this.sTT = sTT;
 }

    public int getSTT() {
       return sTT;
 }

    private TblMenu tblMenu; 
    public TblMenu getTblMenu () {
        return this.tblMenu ;
 }

  

    private List<TblMenu> tblMenus; 
    public List<TblMenu> getTblMenus() {
         return this.tblMenus; 
    }

    private TblMenuService tblMenuService; 

	private int preUpdate(Message msg, TblMenu obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblMenu obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Menu", "sua")){ 
        return "noprivilege"; 
    } 
           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
        msg = new Message(); 
        tblMenu = tblMenuService.gettblMenu(new Long(id)); 
        preUpdate(msg,tblMenu); 
        tblMenu.setUrl(url); 
        tblMenu.setTen(ten); 
        TblMenu uTblMenu = new TblMenu(); 
        uTblMenu.setId(new Long(menuCha));  
        tblMenu.setMenuCha(menuCha <=0 ? null : uTblMenu );  
 
        tblMenu.setHinh(hinh); 
        tblMenu.setMenuId(menuId); 
        tblMenu.setNhom(nhom); 
        tblMenu.setSTT(sTT); 
       if (msg.isPreMessage_b()) 
       { 
           tblMenuService.updatetblMenu(tblMenu); 
           postUpdate(msg, tblMenu); 
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
      tblMenus =       tblMenuService.findAlltblMenu(pageSize, page); 
      pages = tblMenuService.counttblMenuByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&url="; 
      dataString += "&ten="; 
      dataString += "&menuCha="; 
      dataString += "&hinh="; 
      dataString += "&menuId="; 
      dataString += "&nhom="; 
      dataString += "&sTT="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Update tbl_Menu Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_menu", "xem")){ 
        return "noprivilege"; 
    } 
           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
       if(pageSize == 0){ 
            pageSize = 20; 
        } 
        if(page == 0){ 
            page =1; 
        } 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&url="; 
      dataString += "&ten="; 
      dataString += "&menuCha="; 
      dataString += "&hinh="; 
      dataString += "&menuId="; 
      dataString += "&nhom="; 
      dataString += "&sTT="; 
           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
      tblMenus = tblMenuService.findAlltblMenu(0, 0);
      if(tblMenus != null)
    	  pages = tblMenus.size()/pageSize + 1; 
      else 
    	  pages = 1;
      
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Form tbl_Menu Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Menu", "xoa")){ 
        return "noprivilege"; 
    }           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
    msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    for(String id : ids){ 
        tblMenuService.deleteListtblMenu(ids); 
    } 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblMenus =       tblMenuService.findAlltblMenu(pageSize, page); 
      pages = tblMenuService.counttblMenuByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&url="; 
      dataString += "&ten="; 
      dataString += "&menuCha="; 
      dataString += "&hinh="; 
      dataString += "&menuId="; 
      dataString += "&nhom="; 
      dataString += "&sTT="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Delete tbl_Menu Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 	private int preInsert(Message msg, TblMenu obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblMenu obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Menu", "them")){ 
        return "noprivilege"; 
    }           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
        msg = new Message(); 
        tblMenu = new TblMenu(); 
        preInsert(msg,tblMenu); 
        tblMenu.setUrl(url); 
        tblMenu.setTen(ten); 
        TblMenu iTblMenu = new TblMenu(); 
        iTblMenu.setId(new Long(menuCha));  
        tblMenu.setMenuCha(menuCha <=0 ? null : iTblMenu );  
        tblMenu.setHinh(hinh); 
        tblMenu.setMenuId(menuId); 
        tblMenu.setNhom(nhom); 
        tblMenu.setSTT(sTT); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblMenuService.createtblMenu(tblMenu); 
           postInsert(msg, tblMenu); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblMenu.setId(id); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
      tblMenus =       tblMenuService.findAlltblMenu(pageSize, page); 
      pages = tblMenuService.counttblMenuByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&url="; 
      dataString += "&ten="; 
      dataString += "&menuCha="; 
      dataString += "&hinh="; 
      dataString += "&menuId="; 
      dataString += "&nhom="; 
      dataString += "&sTT="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_Menu Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Menu", "xem")){ 
        return "noprivilege"; 
    } 
           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
        msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(id!= null && !id.equals(0)){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("id");
        con.setValue1(new Long(id));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(url != null && !url.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("url");
        con.setValue1("%" + url + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(ten != null && !ten.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ten");
        con.setValue1("%" + ten + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(menuCha != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("menuCha.id");
        con.setValue1(new Long(menuCha));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(hinh != null && !hinh.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("hinh");
        con.setValue1("%" + hinh + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(menuId != null && !menuId.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("menuId");
        con.setValue1("%" + menuId + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(nhom != null && !nhom.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("nhom");
        con.setValue1("%" + nhom + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(sTT != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("STT");
        con.setValue1(sTT);
        con.setOperator("eq");
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
           tblMenus = tblMenuService.findtblMenuByCondition(cons,pageSize,page); 
           pages = tblMenuService.counttblMenuByCondition(cons)/pageSize + 1; 
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
      dataString += "&url=" + url; 
      dataString += "&ten=" + ten; 
      dataString += "&menuCha=" + menuCha; 
      dataString += "&hinh=" + hinh; 
      dataString += "&menuId=" + menuId; 
      dataString += "&nhom=" + nhom; 
      dataString += "&sTT=" + sTT; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_Menu Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_Menu", "sua")){ 
        return "noprivilege"; 
    } 
           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
        tblMenu = tblMenuService.gettblMenu(new Long(id)); 
           tblMenuService = (TblMenuService)context.getBean("tbl_MenuClient"); 
        tblMenus = tblMenuService.findAlltblMenu(0, 0);

        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_Menu Action"); 
     e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
    return Action.ERROR; 
 } 
 } 
 } 
 
