package com.lb.jwitter.action.core;

import java.sql.Connection;
import java.util.ArrayList;
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
public class HomeAction {

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
		
		Map session = ActionContext.getContext().getSession();
	     taiKhoanDangNhap =  (TblTaiKhoan) session.get("taiKhoan");
	     if( taiKhoanDangNhap == null) return "noprivilege";
	    ApplicationContext context = contextProvider.getApplicationContext(); 
	    
	    tblQuyenChiTietService = (TblQuyenChiTietService) context.getBean("tbl_Quyen_ChiTietClient"); 
	    /*if(!tblQuyenChiTietService.checkRight(taiKhoanDangNhap.getMaNhomQuyen().getId(), "tbl_CanBo", "sua")){ 
	    	
	    	System.out.println("khong co quyen");
	        return "noprivilege"; 
	    }*/           
		tblQuyenMenuService = (TblQuyenMenuService) context.getBean("tbl_Quyen_MenuClient");

		/*if(taiKhoanDangNhap.getUsername().equals("admin")){
			tblQuyenMenus = tblQuyenMenuService.findAlltblQuyenMenu(0, 0);
		}else{
			tblQuyenMenus = tblQuyenMenuService.findtblQuyenMenuByNhomQuyen(taiKhoanDangNhap.getMaNhomQuyen().getId(), 0, 0);
		}*/
        tblQuyenMenus = tblQuyenMenuService.findtblQuyenMenuByNhomQuyen(taiKhoanDangNhap.getMaNhomQuyen().getId(), 0, 0);
		
	    tblMenuChas = new ArrayList<TblMenu>();
	    
	    List<TblMenu> tblMenus = new ArrayList<TblMenu>();
	    List<Long> tblMenuIds = new ArrayList<Long>();
	    for(TblQuyenMenu tbl : tblQuyenMenus){
	    	if(!tblMenuIds.contains(tbl.getMenuId().getId())){
	    		tblMenuIds.add(tbl.getMenuId().getId());
	    		tblMenus.add(tbl.getMenuId());
	    	}
	    	if(tbl.getMenuId().getMenuCha() == null)
	    		tblMenuChas.add(tbl.getMenuId());	
	    }

	    menuTreeJson = createMenuTreeJson(tblMenus, null);

		CommonService commonService = (CommonService) context.getBean("commonClient");
		
//		String sql = "select username, canBoId from tbl_taiKhoan as tk";
//		List<Qresult> re = commonService
//							.querySQLWithParamsAliasTransformer(sql, null, null, 0, 0);
//		
//		for(Qresult r : re){
//
//			System.out.println(r.getObjAlias().getEntryByKey("username").getValue().toString());
//		}
//		
//		String hql = "select tk.username as username, tk.canBoId.ngaySinh as ns from Tbl_TaiKhoan as tk";
//		List<Qresult> rs = commonService
//							.queryHQLWithParamsAliasTransformer(hql, null, null, 0, 0);
//		
//		for(Qresult r : rs){
//			System.out.println(r.getObjAlias().getEntryByKey("username").getValue().toString());
//			
//			XMLGregorianCalendar cb = (XMLGregorianCalendar) r.getObjAlias().getEntryByKey("ns").getValue();
//			
//			System.out.println(cb.toString());
//			
//		}
		
		
		return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		
		

	}
	
	private String createMenuTreeJson(List<TblMenu> tblMenus, TblMenu tblMenuCha){
		String menuTree = "[";
		for(TblMenu tblMenu : tblMenus){			
			if((tblMenuCha == null && tblMenu.getMenuCha() == null) || (tblMenuCha != null && tblMenu.getMenuCha() != null && tblMenu.getMenuCha().getId().compareTo(tblMenuCha.getId()) == 0)){
				String subMenuTree = createMenuTreeJson(tblMenus, tblMenu);
				String menuJson = "{ "
					+ "\"text\":\"" + tblMenu.getTen().trim() + "\", "
					+ "\"iconCls\":\"\", ";
				// leaf
				if(subMenuTree.equalsIgnoreCase("[]")){
					menuJson += "\"id\":\"" + tblMenu.getMenuId() + "\", "
						+ "\"isClass\":true, "
						+ "\"package\":\"" + tblMenu.getNhom() + "\", "
						+ "\"cls\":\"cls\", "
						+ "\"href\":\"" + tblMenu.getUrl() + "\", "
						+ "\"leaf\":true ";					
				} 
				// parent
				else {
					menuJson += "\"id\":\"Pkg" + tblMenu.getTen().trim() + "\", "
						+ "\"cls\":\"package\", "
						+ "\"singleClickExpand\":true, "
						+ "\"children\":" + subMenuTree + " ";
				}
				menuJson += "},";
				menuTree += " " + menuJson + " ";
			}
		}
		menuTree += "]";
		return menuTree;
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
