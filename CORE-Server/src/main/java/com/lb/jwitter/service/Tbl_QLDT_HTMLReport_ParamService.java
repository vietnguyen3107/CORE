package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_QLDT_HTMLReport_Param;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_QLDT_HTMLReport_ParamService {

  public List<Tbl_QLDT_HTMLReport_Param> findAllTbl_QLDT_HTMLReport_Param(int pageSize, int page);

  public Long createTbl_QLDT_HTMLReport_Param(Tbl_QLDT_HTMLReport_Param obj);

  public void updateTbl_QLDT_HTMLReport_Param(Tbl_QLDT_HTMLReport_Param obj);

  public void deleteTbl_QLDT_HTMLReport_Param(Long id);

  public void deleteListTbl_QLDT_HTMLReport_Param(String[] listId);

  public Tbl_QLDT_HTMLReport_Param getTbl_QLDT_HTMLReport_Param(Long id);

public List<Tbl_QLDT_HTMLReport_Param> findTbl_QLDT_HTMLReport_ParamByCondition(List<ConditionReport> cons,int pageSize,int page); 

public List<Object> findColumnTbl_QLDT_HTMLReport_ParamByCondition(List<ConditionReport> cons,List<String> columns, int pageSize,int page);  

public int countTbl_QLDT_HTMLReport_ParamByCondition(List<ConditionReport> cons); 

 public List<Tbl_QLDT_HTMLReport_Param> queryHQLTbl_QLDT_HTMLReport_Param(String hql,int pageSize,int page); 
}//endclass

