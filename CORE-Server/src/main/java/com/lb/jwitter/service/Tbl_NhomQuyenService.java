package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_NhomQuyen;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_NhomQuyenService {

  public List<Tbl_NhomQuyen> findAlltbl_NhomQuyen(int pageSize, int page);

  public Long createtbl_NhomQuyen(Tbl_NhomQuyen obj);

  public void updatetbl_NhomQuyen(Tbl_NhomQuyen obj);

  public void deletetbl_NhomQuyen(Long id);

  public void deleteListtbl_NhomQuyen(String[] listId);

  public Tbl_NhomQuyen gettbl_NhomQuyen(Long id);

public List<Tbl_NhomQuyen> findtbl_NhomQuyenByCondition(List<ConditionReport> cons,int pageSize,int page); 

public int counttbl_NhomQuyenByCondition(List<ConditionReport> cons); 

}//endclass

