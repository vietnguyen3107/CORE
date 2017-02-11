package com.lb.jwitter.action.option;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.List;
import java.util.Date; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
//import org.springframework.test.context.ContextConfiguration;
import com.lb.jwitter.util.ApplicationContextProvider; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.opensymphony.xwork2.Action; 
import com.lb.jwitter.service.ConditionReport; 
import java.util.Map; 
 import com.opensymphony.xwork2.ActionContext; 
import com.lb.jwitter.util.Message; 
import com.lb.jwitter.service.TblQuyenChiTietService;import com.lb.jwitter.service.TblTaiKhoan;import com.lb.jwitter.service.TblQLDTLTOption;
import com.lb.jwitter.service.TblQLDTLTOptionService;

import com.lb.jwitter.service.TblQLDTLTOptionGroup;
import com.lb.jwitter.service.TblQLDTLTOptionGroupService;

 /** 
 * @author QUOCVIET  
 * 
 */ 


//@ContextConfiguration(locations="classpath:beans.xml") 
public class TblQLDTLTOptionGrouptblQLDTLTOptionSearchAction{
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

    private int num; 
    public int getNum() {
       return num;
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

    private Date today; 
    public Date getToday() { return new Date(); } 

    private Message msg; 
    public Message getMsg() { return msg; }

    private String ma; 
    public void setMa(String ma) {
       this.ma = ma;
   }

    public String getMa() {
       return ma;
   }

    private String ten; 
    public void setTen(String ten) {
       this.ten = ten;
   }

    public String getTen() {
       return ten;
   }

    /**
     * 
     */
    private int sortOrder;
    public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	private int optionGroupId; 
    public void setOptionGroupId(int optionGroupId) {
       this.optionGroupId = optionGroupId;
  }

    public int getOptionGroupId() {
       return optionGroupId;
  }

    private List<TblQLDTLTOption> tblQLDTLTOptions; 
    public List<TblQLDTLTOption>  getTblQLDTLTOptions() {
        return tblQLDTLTOptions; 
      } 

    private TblQLDTLTOptionService tblQLDTLTOptionService; 

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
     if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_QLDTLT_Option", "xem")){ 
        return "noprivilege"; 
    }tblQLDTLTOptionService = (TblQLDTLTOptionService) context.getBean("tbl_QLDTLT_OptionClient"); 
         msg = new Message(); 
        List<ConditionReport> cons = new ArrayList<ConditionReport>(); 
    if(ma != null && !ma.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ma");
        con.setValue1("%" + ma + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(ten != null && !ten.equals("")){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("ten");
        con.setValue1("%" + ten + "%");
        con.setOperator("like");
        cons.add(con);	
    } 
    if(optionGroupId != 0 ){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("optionGroupId.id");
        con.setValue1(new Long(optionGroupId));
        con.setOperator("eq");
        cons.add(con);	
    } 
    if(sortOrder != 0){ 
        ConditionReport con = new ConditionReport(); 
        con.setCol("sortOrder");
        con.setValue1(sortOrder );
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
           tblQLDTLTOptions = tblQLDTLTOptionService.findTblQLDTLTOptionByCondition(cons,pageSize,page); 
       num = tblQLDTLTOptionService.countTblQLDTLTOptionByCondition(cons); 
       pages = num/pageSize + 1; 
           postSearch(msg, cons); 
           if (msg.isPostMessage_b() == false) 
           { 
               return Action.ERROR; 
           } 
       }else{ 
           return Action.ERROR; 
       } 
      dataString = ""; 
      dataString += "&ma=" + ma; 
      dataString += "&ten=" + ten; 
      dataString += "&optionGroupId=" + optionGroupId; 
      dataString += "&sortOrder=" + sortOrder; 
        return Action.SUCCESS; 
      } 
      catch(Exception e){ 
         System.out.println("Loi Seach tbl_QLDTLT_Option Action"); 
         e.printStackTrace(); 
         msg.setPostMessage_b(false); 
         msg.setPostMessage_s(e.getMessage()); 
         return Action.ERROR; 
 } 
 } 
 } 
 
