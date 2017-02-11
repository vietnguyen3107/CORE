package com.lb.jwitter.core.hibernate;

import java.util.Collection;

import com.lb.jwitter.core.Tbl_QLDTLT_OptionGroup;
import com.lb.jwitter.util.ConditionReport;
import java.util.List;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_QLDTLT_OptionGroupDAO extends GenericDao<Tbl_QLDTLT_OptionGroup, Long>  {

   List<Tbl_QLDTLT_OptionGroup> findAll(int pageSize,int page);
   
   
   public List<Tbl_QLDTLT_OptionGroup> find(Tbl_QLDTLT_OptionGroup _tbl_QLDTLT_OptionGroup, int pageSize, int page);

 public List<Tbl_QLDTLT_OptionGroup> queryHQL(String hql,int pageSize,int page); 

}//endInterface

