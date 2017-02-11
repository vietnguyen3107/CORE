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
//import org.springframework.test.context.ContextConfiguration;
import java.util.List; 
import java.util.Map; 
import com.lb.jwitter.util.ApplicationContextProvider;
import com.lb.jwitter.util.Encrypt;
import com.opensymphony.xwork2.ActionContext; 
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.TblQuyenChiTietService; 
import com.lb.jwitter.service.TblTaiKhoan;
import com.lb.jwitter.service.TblTaiKhoanService;

import com.lb.jwitter.service.TblNhomQuyen;
import com.lb.jwitter.service.TblNhomQuyenService;

import com.lb.jwitter.service.TblCanBo;
import com.lb.jwitter.service.TblCanBoService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblTaiKhoanAction{
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

    private String username; 
    public void setUsername(String username) {
       this.username = username;
 }

    public String getUsername() {
       return username;
 }

    private String password; 
    public void setPassword(String password) {
       this.password = password;
 }

    public String getPassword() {
       return password;
 }

    private int maNhomQuyen; 
    public void setMaNhomQuyen(int maNhomQuyen) {
       this.maNhomQuyen = maNhomQuyen;
 }

    public int getMaNhomQuyen() {
       return maNhomQuyen;
 }

    private int canBoId; 
    public void setCanBoId(int canBoId) {
       this.canBoId = canBoId;
 }

    public int getCanBoId() {
       return canBoId;
 }

    private TblTaiKhoan tblTaiKhoan; 
    public TblTaiKhoan getTblTaiKhoan () {
        return this.tblTaiKhoan ;
 }

    private Collection<TblTaiKhoan> tblTaiKhoans; 
    public Collection<TblTaiKhoan> getTblTaiKhoans() {
        return this.tblTaiKhoans; 
      } 

    private TblTaiKhoanService tblTaiKhoanService; 

    private Collection<TblNhomQuyen> tblNhomQuyens; 
    public Collection<TblNhomQuyen> getTblNhomQuyens() {
         return this.tblNhomQuyens; 
    }

    private TblNhomQuyenService tblNhomQuyenService; 

    private Collection<TblCanBo> tblCanBos; 
    public Collection<TblCanBo> getTblCanBos() {
         return this.tblCanBos; 
    }

    private TblCanBoService tblCanBoService; 

	private int preUpdate(Message msg, TblTaiKhoan obj ){ 
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postUpdate(Message msg, TblTaiKhoan obj ){ 
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
    tblNhomQuyenService = (TblNhomQuyenService) context.getBean("tbl_NhomQuyenClient");
    tblCanBoService = (TblCanBoService) context.getBean("tbl_CanBoClient");
    
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_TaiKhoan", "sua")){ 
        return "noprivilege"; 
    } 
           tblTaiKhoanService = (TblTaiKhoanService)context.getBean("tbl_TaiKhoanClient"); 
        msg = new Message(); 
        tblTaiKhoan = tblTaiKhoanService.gettblTaiKhoan(new Long(id)); 
        tblTaiKhoan.setUsername(username); 

 		if(password != null && !password.equals("")){
 			tblTaiKhoan.setPassword(Encrypt.sha(password, "SHA-1")); 
 		}
        tblTaiKhoan.setMaNhomQuyen(tblNhomQuyenService.gettblNhomQuyen(new Long(maNhomQuyen))); 
        tblTaiKhoan.setCanBoId(tblCanBoService.gettblCanBo(new Long(canBoId))); 
        preUpdate(msg,tblTaiKhoan); 
       if (msg.isPreMessage_b()) 
       { 
           tblTaiKhoanService.updatetblTaiKhoan(tblTaiKhoan); 
           postUpdate(msg, tblTaiKhoan); 
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
        
        List<ConditionReport> cons = new ArrayList<ConditionReport>();
        { 
            ConditionReport con = new ConditionReport(); 
            con.setCol("canBoId.id");
            con.setValue1("");
            con.setOperator("isNotNull");
            cons.add(con);	
        } 
      tblTaiKhoans =       tblTaiKhoanService.findtblTaiKhoanByCondition(cons, pageSize, page); 
      pages = tblTaiKhoanService.counttblTaiKhoanByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&username="; 
      dataString += "&password="; 
      dataString += "&maNhomQuyen="; 
      dataString += "&canBoId="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Update tbl_TaiKhoan Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_TaiKhoan", "xem")){ 
        return "noprivilege"; 
    } 
           tblTaiKhoanService = (TblTaiKhoanService)context.getBean("tbl_TaiKhoanClient"); 
       if(pageSize == 0){ 
            pageSize = 20; 
        } 
        if(page == 0){ 
            page =1; 
        } 
        
        List<ConditionReport> cons = new ArrayList<ConditionReport>();
        { 
            ConditionReport con = new ConditionReport(); 
            con.setCol("canBoId.id");
            con.setValue1("");
            con.setOperator("isNotNull");
            cons.add(con);	
        } 
      tblTaiKhoans =       tblTaiKhoanService.findtblTaiKhoanByCondition(cons, pageSize, page); 
        pages = tblTaiKhoanService.counttblTaiKhoanByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&username="; 
      dataString += "&password="; 
      dataString += "&maNhomQuyen="; 
      dataString += "&canBoId="; 
           tblNhomQuyenService = (TblNhomQuyenService)context.getBean("tbl_NhomQuyenClient"); 
      tblNhomQuyens = tblNhomQuyenService.findAlltblNhomQuyen(0, 0);
           tblCanBoService = (TblCanBoService)context.getBean("tbl_CanBoClient"); 
      tblCanBos = tblCanBoService.findAlltblCanBo(0, 0);
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Form tbl_TaiKhoan Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_TaiKhoan", "xoa")){ 
        return "noprivilege"; 
    }           tblTaiKhoanService = (TblTaiKhoanService)context.getBean("tbl_TaiKhoanClient"); 
    msg = new Message(); 

    List<String> ids = new ArrayList<String>(); 
    Collections.addAll(ids, idList.split(",")); 
    for(String id : ids){ 
        tblTaiKhoanService.deleteListtblTaiKhoan(ids); 
    } 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
        
        List<ConditionReport> cons = new ArrayList<ConditionReport>();
        { 
            ConditionReport con = new ConditionReport(); 
            con.setCol("canBoId.id");
            con.setValue1("");
            con.setOperator("isNotNull");
            cons.add(con);	
        } 
      tblTaiKhoans =       tblTaiKhoanService.findtblTaiKhoanByCondition(cons, pageSize, page); 
      pages = tblTaiKhoanService.counttblTaiKhoanByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&username="; 
      dataString += "&password="; 
      dataString += "&maNhomQuyen="; 
      dataString += "&canBoId="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi Delete tbl_TaiKhoan Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 	private int preInsert(Message msg, TblTaiKhoan obj ){ 
 		
 		if(password == null || password.equals("")){
 			msg.setPreMessage_b(false);
 			msg.setPreMessage_s("Password không được trống!");
 			
 			return 0;
 		}
        msg.setPreMessage_b(true); 
        msg.setPreMessage_s("success"); 
        return 1; 
    } 
	private int postInsert(Message msg, TblTaiKhoan obj ){ 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_TaiKhoan", "them")){ 
        return "noprivilege"; 
    }          
    tblTaiKhoanService = (TblTaiKhoanService)context.getBean("tbl_TaiKhoanClient"); 
           tblNhomQuyenService = (TblNhomQuyenService)context.getBean("tbl_NhomQuyenClient"); 
           tblCanBoService = (TblCanBoService)context.getBean("tbl_CanBoClient"); 
        msg = new Message(); 
        tblTaiKhoan = new TblTaiKhoan(); 
        tblTaiKhoan.setUsername(username); 

 		if(password != null && !password.equals("")){
 			tblTaiKhoan.setPassword(Encrypt.sha(password, "SHA-1")); 
 		}
        tblTaiKhoan.setMaNhomQuyen(tblNhomQuyenService.gettblNhomQuyen(new Long(maNhomQuyen))); 
        tblTaiKhoan.setCanBoId(tblCanBoService.gettblCanBo(new Long(canBoId))); 
        preInsert(msg,tblTaiKhoan); 
       if (msg.isPreMessage_b()) 
       { 
           id = tblTaiKhoanService.createtblTaiKhoan(tblTaiKhoan); 
           postInsert(msg, tblTaiKhoan); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
       tblTaiKhoan.setId(id); 
       if(pageSize == 0){ 
           pageSize = 20; 
       } 
        if(page == 0){ 
           page =1; 
       } 
        
        
        List<ConditionReport> cons = new ArrayList<ConditionReport>();
        { 
            ConditionReport con = new ConditionReport(); 
            con.setCol("canBoId.id");
            con.setValue1("");
            con.setOperator("isNotNull");
            cons.add(con);	
        } 
      tblTaiKhoans =       tblTaiKhoanService.findtblTaiKhoanByCondition(cons, pageSize, page); 
      pages = tblTaiKhoanService.counttblTaiKhoanByCondition(new ArrayList<ConditionReport>())/pageSize + 1; 
      dataString = ""; 
      dataString += "&id="; 
      dataString += "&username="; 
      dataString += "&password="; 
      dataString += "&maNhomQuyen="; 
      dataString += "&canBoId="; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Insert tbl_TaiKhoan Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_TaiKhoan", "xem")){ 
        return "noprivilege"; 
    } 
           tblTaiKhoanService = (TblTaiKhoanService)context.getBean("tbl_TaiKhoanClient"); 
        msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(id!= null && !id.equals(0)){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("id");
        con.setValue1(new Long(id));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(username != null && !username.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("username");
        con.setValue1("%" + username + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(password != null && !password.equalsIgnoreCase("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("password");
        con.setValue1("%" + password + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(maNhomQuyen != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("maNhomQuyen.id");
        con.setValue1(new Long(maNhomQuyen));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(canBoId != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("canBoId.id");
        con.setValue1(new Long(canBoId));
        con.setOperator("eq");
        cons.add(con);	
    } 
    { 
        ConditionReport con = new ConditionReport(); 
        con.setCol("canBoId.id");
        con.setValue1("");
        con.setOperator("isNotNull");
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
           tblTaiKhoans = tblTaiKhoanService.findtblTaiKhoanByCondition(cons,pageSize,page); 
           pages = tblTaiKhoanService.counttblTaiKhoanByCondition(cons)/pageSize + 1; 
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
      dataString += "&username=" + username; 
      dataString += "&password=" + password; 
      dataString += "&maNhomQuyen=" + maNhomQuyen; 
      dataString += "&canBoId=" + canBoId; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_TaiKhoan Action"); 
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
    if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_TaiKhoan", "sua")){ 
        return "noprivilege"; 
    } 
           tblTaiKhoanService = (TblTaiKhoanService)context.getBean("tbl_TaiKhoanClient"); 
        tblTaiKhoan = tblTaiKhoanService.gettblTaiKhoan(new Long(id)); 
           tblNhomQuyenService = (TblNhomQuyenService)context.getBean("tbl_NhomQuyenClient"); 
        tblNhomQuyens = tblNhomQuyenService.findAlltblNhomQuyen(0, 0);

           tblCanBoService = (TblCanBoService)context.getBean("tbl_CanBoClient"); 
        tblCanBos = tblCanBoService.findAlltblCanBo(0, 0);

        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
      System.out.println("Loi EditForm tbl_TaiKhoan Action"); 
     e.printStackTrace(); 
    return Action.ERROR; 
 } 
 } 
 } 
 
