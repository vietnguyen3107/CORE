package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_QLDTLT_Option;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_QLDTLT_OptionService {

  public List<Tbl_QLDTLT_Option> findAllTbl_QLDTLT_Option(int pageSize, int page);

  public Long createTbl_QLDTLT_Option(Tbl_QLDTLT_Option obj);

  public void updateTbl_QLDTLT_Option(Tbl_QLDTLT_Option obj);

  public void deleteTbl_QLDTLT_Option(Long id);

  public void deleteListTbl_QLDTLT_Option(String[] listId);

  public Tbl_QLDTLT_Option getTbl_QLDTLT_Option(Long id);

public List<Tbl_QLDTLT_Option> findTbl_QLDTLT_OptionByCondition(List<ConditionReport> cons,int pageSize,int page); 

public List<Object> findColumnTbl_QLDTLT_OptionByCondition(List<ConditionReport> cons,List<String> columns, int pageSize,int page);  

public int countTbl_QLDTLT_OptionByCondition(List<ConditionReport> cons); 

 public List<Tbl_QLDTLT_Option> queryHQLTbl_QLDTLT_Option(String hql,int pageSize,int page); 
}//endclass

