package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_DBTable;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_DBTableService {

  public List<Tbl_DBTable> findAlltbl_DBTable(int pageSize, int page);

  public Long createtbl_DBTable(Tbl_DBTable obj);

  public void updatetbl_DBTable(Tbl_DBTable obj);

  public void deletetbl_DBTable(Long id);

  public void deleteListtbl_DBTable(String[] listId);

  public Tbl_DBTable gettbl_DBTable(Long id);

public List<Tbl_DBTable> findtbl_DBTableByCondition(List<ConditionReport> cons,int pageSize,int page); 

public int counttbl_DBTableByCondition(List<ConditionReport> cons); 

}//endclass

