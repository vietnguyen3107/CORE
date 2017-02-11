package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_QLDT_HTMLReport;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_QLDT_HTMLReportDAO extends GenericDao<Tbl_QLDT_HTMLReport, Long>  {

   List<Tbl_QLDT_HTMLReport> findAll(int pageSize,int page);
   
   
   public Collection<Tbl_QLDT_HTMLReport> find(Tbl_QLDT_HTMLReport _tbl_QLDT_HTMLReport, int pageSize, int page);

 public List<Tbl_QLDT_HTMLReport> queryHQL(String hql,int pageSize,int page); 
}//endInterface

