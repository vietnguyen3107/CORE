package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_QLDT_Config;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_QLDT_ConfigService {

  public List<Tbl_QLDT_Config> findAlltbl_QLDT_Config(int pageSize, int page);

  public Long createtbl_QLDT_Config(Tbl_QLDT_Config obj);

  public void updatetbl_QLDT_Config(Tbl_QLDT_Config obj);

  public void deletetbl_QLDT_Config(Long id);

  public void deleteListtbl_QLDT_Config(String[] listId);

  public Tbl_QLDT_Config gettbl_QLDT_Config(Long id);

public List<Tbl_QLDT_Config> findtbl_QLDT_ConfigByCondition(List<ConditionReport> cons,int pageSize,int page); 

public List<Object> findColumntbl_QLDT_ConfigByCondition(List<ConditionReport> cons,List<String> columns, int pageSize,int page);  

public int counttbl_QLDT_ConfigByCondition(List<ConditionReport> cons); 

}//endclass

