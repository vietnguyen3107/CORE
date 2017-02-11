package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_QLDT_HTMLReport_Param;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_QLDT_HTMLReport_ParamDAO extends GenericDao<Tbl_QLDT_HTMLReport_Param, Long>  {

   List<Tbl_QLDT_HTMLReport_Param> findAll(int pageSize,int page);
   
   
   public Collection<Tbl_QLDT_HTMLReport_Param> find(Tbl_QLDT_HTMLReport_Param _tbl_QLDT_HTMLReport_Param, int pageSize, int page);

 public List<Tbl_QLDT_HTMLReport_Param> queryHQL(String hql,int pageSize,int page); 
}//endInterface

