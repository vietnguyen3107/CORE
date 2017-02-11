package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_Quyen_NhomQuyen;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_Quyen_NhomQuyenService {

  public List<Tbl_Quyen_NhomQuyen> findAlltbl_Quyen_NhomQuyen(int pageSize, int page);

  public Long createtbl_Quyen_NhomQuyen(Tbl_Quyen_NhomQuyen obj);

  public void updatetbl_Quyen_NhomQuyen(Tbl_Quyen_NhomQuyen obj);

  public void deletetbl_Quyen_NhomQuyen(Long id);

  public void deleteListtbl_Quyen_NhomQuyen(String[] listId);

  public Tbl_Quyen_NhomQuyen gettbl_Quyen_NhomQuyen(Long id);

public List<Tbl_Quyen_NhomQuyen> findtbl_Quyen_NhomQuyenByCondition(List<ConditionReport> cons,int pageSize,int page); 

public int counttbl_Quyen_NhomQuyenByCondition(List<ConditionReport> cons); 

}//endclass

