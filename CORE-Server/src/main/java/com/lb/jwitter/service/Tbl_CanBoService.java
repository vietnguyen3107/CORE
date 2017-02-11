package com.lb.jwitter.service;

import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_CanBo;
import com.lb.jwitter.util.ConditionReport;

@WebService
public interface Tbl_CanBoService {

  public List<Tbl_CanBo> findAlltbl_CanBo(int pageSize, int page);

  public Long createtbl_CanBo(Tbl_CanBo obj);

  public void updatetbl_CanBo(Tbl_CanBo obj);

  public void deletetbl_CanBo(Long id);

  public void deleteListtbl_CanBo(String[] listId);

  public Tbl_CanBo gettbl_CanBo(Long id);

public List<Tbl_CanBo> findtbl_CanBoByCondition(List<ConditionReport> cons,int pageSize,int page); 
public List<Tbl_CanBo> findtbl_CanBoByHQL(String hql,int pageSize,int page); 

public int counttbl_CanBoByCondition(List<ConditionReport> cons); 

}//endclass

