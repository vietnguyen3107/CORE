package com.lb.jwitter.core.hibernate;

import java.util.Collection;

import com.lb.jwitter.core.Tbl_DonVi;
import com.lb.jwitter.util.ConditionReport;
import java.util.List;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_DonViDAO extends GenericDao<Tbl_DonVi, Long>  {

   List<Tbl_DonVi> findAll(int pageSize,int page);
   
   
   public List<Tbl_DonVi> find(Tbl_DonVi _tbl_DonVi, int pageSize, int page);

 public List<Tbl_DonVi> queryHQL(String hql,int pageSize,int page); 

}//endInterface

