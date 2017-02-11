package com.lb.jwitter.core.hibernate;

import java.util.Collection;

import com.lb.jwitter.core.Tbl_QLDTLT_Option;
import com.lb.jwitter.util.ConditionReport;
import java.util.List;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_QLDTLT_OptionDAO extends GenericDao<Tbl_QLDTLT_Option, Long>  {

   List<Tbl_QLDTLT_Option> findAll(int pageSize,int page);
   
   
   public List<Tbl_QLDTLT_Option> find(Tbl_QLDTLT_Option _tbl_QLDTLT_Option, int pageSize, int page);

 public List<Tbl_QLDTLT_Option> queryHQL(String hql,int pageSize,int page); 

}//endInterface

