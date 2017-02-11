package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_QLDT_Log;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_QLDT_LogService {

  public List<Tbl_QLDT_Log> findAlltbl_QLDT_Log(int pageSize, int page);

  public Long createtbl_QLDT_Log(Tbl_QLDT_Log obj);

  public void updatetbl_QLDT_Log(Tbl_QLDT_Log obj);

  public void deletetbl_QLDT_Log(Long id);

  public void deleteListtbl_QLDT_Log(String[] listId);

  public Tbl_QLDT_Log gettbl_QLDT_Log(Long id);

public List<Tbl_QLDT_Log> findtbl_QLDT_LogByCondition(List<ConditionReport> cons,int pageSize,int page); 

public List<Object> findColumntbl_QLDT_LogByCondition(List<ConditionReport> cons,List<String> columns, int pageSize,int page);  

public int counttbl_QLDT_LogByCondition(List<ConditionReport> cons); 

}//endclass

