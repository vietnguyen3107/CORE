package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_Quyen_Menu;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_Quyen_MenuService {

  public List<Tbl_Quyen_Menu> findAlltbl_Quyen_Menu(int pageSize, int page);

  public Long createtbl_Quyen_Menu(Tbl_Quyen_Menu obj);

  public void updatetbl_Quyen_Menu(Tbl_Quyen_Menu obj);

  public void deletetbl_Quyen_Menu(Long id);

  public void deleteListtbl_Quyen_Menu(String[] listId);

  public Tbl_Quyen_Menu gettbl_Quyen_Menu(Long id);

	public List<Tbl_Quyen_Menu> findtbl_Quyen_MenuByCondition(List<ConditionReport> cons,int pageSize,int page); 
	
	
	public List<Tbl_Quyen_Menu> findtbl_Quyen_MenuByNhomQuyen(Long nhomQuyenId, int pageSize, int page); 
	
	public int counttbl_Quyen_MenuByCondition(List<ConditionReport> cons); 

}//endclass

