package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_Menu;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_MenuService {

  public List<Tbl_Menu> findAlltbl_Menu(int pageSize, int page);

  public Long createtbl_Menu(Tbl_Menu obj);

  public void updatetbl_Menu(Tbl_Menu obj);

  public void deletetbl_Menu(Long id);

  public void deleteListtbl_Menu(String[] listId);

  public Tbl_Menu gettbl_Menu(Long id);

public List<Tbl_Menu> findtbl_MenuByCondition(List<ConditionReport> cons,int pageSize,int page); 

public int counttbl_MenuByCondition(List<ConditionReport> cons); 

}//endclass

