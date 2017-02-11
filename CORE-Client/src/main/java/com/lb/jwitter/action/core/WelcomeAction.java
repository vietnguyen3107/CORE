package com.lb.jwitter.action.core;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;

import com.lb.jwitter.service.CommonService;
import com.lb.jwitter.service.ConditionReport;
import com.lb.jwitter.service.Qresult;
import com.lb.jwitter.service.TblCanBo;
import com.lb.jwitter.service.TblMenu;
import com.lb.jwitter.service.TblMenuService;
import com.lb.jwitter.service.TblQuyenChiTietService;
import com.lb.jwitter.service.TblQuyenMenu;
import com.lb.jwitter.service.TblQuyenMenuService;
import com.lb.jwitter.service.TblTaiKhoan;
import com.lb.jwitter.util.ApplicationContextProvider;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

//@ContextConfiguration(locations="classpath:beans.xml") 
public class WelcomeAction {

	private List<TblQuyenMenu> tblQuyenMenus;
	private TblQuyenMenuService tblQuyenMenuService;
	private List<TblMenu> tblMenuChas;
	
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
		try {
		
			Date today = new Date();
		Map session = ActionContext.getContext().getSession();
	     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
	     if( taiKhoanDangNhap == null) return "noprivilege";
	    ApplicationContext context = contextProvider.getApplicationContext(); 
//	    TblQLDTLTKhoaDaoTaoService tblQLDTLTKhoaDaoTaoService = (TblQLDTLTKhoaDaoTaoService) context.getBean("tbl_QLDTLT_KhoaDaoTaoClient");
//
//
//	    String hql = "from TblQLDTLTKhoaDaoTao kdt where 1=1 ";
//	    hql += " and kdt.khoaDaoTaoDuKienId is null "; 
//	    hql += " and (kdt.donViId.id = " +taiKhoanDangNhap.getCanBoId().getDonViId().getId()+ " OR kdt.donViId.donViChaId.id = " +taiKhoanDangNhap.getCanBoId().getDonViId().getId()+ ")"; 
//	    
//		tblQLDTLTKhoaDaoTaoDuKiens = tblQLDTLTKhoaDaoTaoService.queryHQLTblQLDTLTKhoaDaoTao(hql, 0, 0);
		
		
		return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		
		

	}
	
	public List<TblQuyenMenu> getTblQuyenMenus() {
		return tblQuyenMenus;
	}
	public void setTblQuyenMenus(List<TblQuyenMenu> tblQuyenMenus) {
		this.tblQuyenMenus = tblQuyenMenus;
	}
	public List<TblMenu> getTblMenuChas() {
		return tblMenuChas;
	}
	public void setTblMenuChas(List<TblMenu> tblMenuChas) {
		this.tblMenuChas = tblMenuChas;
	}

	public String menuTreeJson;

	public String getMenuTreeJson() {
		return menuTreeJson;
	}
	public void setMenuTreeJson(String menuTreeJson) {
		this.menuTreeJson = menuTreeJson;
	}
	
	
	
	
}
