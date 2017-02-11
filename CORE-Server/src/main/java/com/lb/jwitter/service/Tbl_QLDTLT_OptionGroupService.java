package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_QLDTLT_OptionGroup;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_QLDTLT_OptionGroupService {

  public List<Tbl_QLDTLT_OptionGroup> findAllTbl_QLDTLT_OptionGroup(int pageSize, int page);

  public Long createTbl_QLDTLT_OptionGroup(Tbl_QLDTLT_OptionGroup obj);

  public void updateTbl_QLDTLT_OptionGroup(Tbl_QLDTLT_OptionGroup obj);

  public void deleteTbl_QLDTLT_OptionGroup(Long id);

  public void deleteListTbl_QLDTLT_OptionGroup(String[] listId);

  public Tbl_QLDTLT_OptionGroup getTbl_QLDTLT_OptionGroup(Long id);

public List<Tbl_QLDTLT_OptionGroup> findTbl_QLDTLT_OptionGroupByCondition(List<ConditionReport> cons,int pageSize,int page); 

public List<Object> findColumnTbl_QLDTLT_OptionGroupByCondition(List<ConditionReport> cons,List<String> columns, int pageSize,int page);  

public int countTbl_QLDTLT_OptionGroupByCondition(List<ConditionReport> cons); 

 public List<Tbl_QLDTLT_OptionGroup> queryHQLTbl_QLDTLT_OptionGroup(String hql,int pageSize,int page); 
}//endclass

