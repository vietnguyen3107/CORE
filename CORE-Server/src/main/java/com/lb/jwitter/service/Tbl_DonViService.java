package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_DonVi;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_DonViService {

  public List<Tbl_DonVi> findAllTbl_DonVi(int pageSize, int page);

  public Long createTbl_DonVi(Tbl_DonVi obj);

  public void updateTbl_DonVi(Tbl_DonVi obj);

  public void deleteTbl_DonVi(Long id);

  public void deleteListTbl_DonVi(String[] listId);

  public Tbl_DonVi getTbl_DonVi(Long id);

public List<Tbl_DonVi> findTbl_DonViByCondition(List<ConditionReport> cons,int pageSize,int page); 

public List<Object> findColumnTbl_DonViByCondition(List<ConditionReport> cons,List<String> columns, int pageSize,int page);  

public int countTbl_DonViByCondition(List<ConditionReport> cons); 

 public List<Tbl_DonVi> queryHQLTbl_DonVi(String hql,int pageSize,int page); 
}//endclass

