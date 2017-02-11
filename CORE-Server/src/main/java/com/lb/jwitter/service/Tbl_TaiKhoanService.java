package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_TaiKhoan;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_TaiKhoanService {

  public List<Tbl_TaiKhoan> findAlltbl_TaiKhoan(int pageSize, int page);

  public Long createtbl_TaiKhoan(Tbl_TaiKhoan obj);

  public void updatetbl_TaiKhoan(Tbl_TaiKhoan obj);

  public void deletetbl_TaiKhoan(Long id);

  public void deleteListtbl_TaiKhoan(String[] listId);

  public Tbl_TaiKhoan gettbl_TaiKhoan(Long id);

public List<Tbl_TaiKhoan> findtbl_TaiKhoanByCondition(List<ConditionReport> cons,int pageSize,int page); 

public int counttbl_TaiKhoanByCondition(List<ConditionReport> cons); 

}//endclass

