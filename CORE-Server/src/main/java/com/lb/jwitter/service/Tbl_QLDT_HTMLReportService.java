package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_QLDT_HTMLReport;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_QLDT_HTMLReportService {

  public List<Tbl_QLDT_HTMLReport> findAllTbl_QLDT_HTMLReport(int pageSize, int page);

  public Long createTbl_QLDT_HTMLReport(Tbl_QLDT_HTMLReport obj);

  public void updateTbl_QLDT_HTMLReport(Tbl_QLDT_HTMLReport obj);

  public void deleteTbl_QLDT_HTMLReport(Long id);

  public void deleteListTbl_QLDT_HTMLReport(String[] listId);

  public Tbl_QLDT_HTMLReport getTbl_QLDT_HTMLReport(Long id);

public List<Tbl_QLDT_HTMLReport> findTbl_QLDT_HTMLReportByCondition(List<ConditionReport> cons,int pageSize,int page); 

public List<Object> findColumnTbl_QLDT_HTMLReportByCondition(List<ConditionReport> cons,List<String> columns, int pageSize,int page);  

public int countTbl_QLDT_HTMLReportByCondition(List<ConditionReport> cons); 

 public List<Tbl_QLDT_HTMLReport> queryHQLTbl_QLDT_HTMLReport(String hql,int pageSize,int page); 
}//endclass

