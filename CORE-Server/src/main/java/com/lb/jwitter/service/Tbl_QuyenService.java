package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_Quyen;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_QuyenService {

  public List<Tbl_Quyen> findAlltbl_Quyen(int pageSize, int page);

  public Long createtbl_Quyen(Tbl_Quyen obj);

  public void updatetbl_Quyen(Tbl_Quyen obj);

  public void deletetbl_Quyen(Long id);

  public void deleteListtbl_Quyen(String[] listId);

  public Tbl_Quyen gettbl_Quyen(Long id);

public List<Tbl_Quyen> findtbl_QuyenByCondition(List<ConditionReport> cons,int pageSize,int page); 

public int counttbl_QuyenByCondition(List<ConditionReport> cons); 

}//endclass

