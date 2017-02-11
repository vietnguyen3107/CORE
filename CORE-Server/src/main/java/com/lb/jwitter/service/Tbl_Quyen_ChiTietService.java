package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_Quyen_ChiTiet;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_Quyen_ChiTietService {

  public List<Tbl_Quyen_ChiTiet> findAlltbl_Quyen_ChiTiet(int pageSize, int page);

  public Long createtbl_Quyen_ChiTiet(Tbl_Quyen_ChiTiet obj);

  public void updatetbl_Quyen_ChiTiet(Tbl_Quyen_ChiTiet obj);

  public void deletetbl_Quyen_ChiTiet(Long id);

  public void deleteListtbl_Quyen_ChiTiet(String[] listId);

  public Tbl_Quyen_ChiTiet gettbl_Quyen_ChiTiet(Long id);

	public List<Tbl_Quyen_ChiTiet> findtbl_Quyen_ChiTietByCondition(List<ConditionReport> cons,int pageSize,int page); 
	
	public int counttbl_Quyen_ChiTietByCondition(List<ConditionReport> cons); 
	
	public boolean checkRight(Long nhomQuyenId, String tableName, String right);

}//endclass

