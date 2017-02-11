package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_QLDT_Config;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_QLDT_ConfigDAO extends GenericDao<Tbl_QLDT_Config, Long>  {

   List<Tbl_QLDT_Config> findAll(int pageSize,int page);
   
   
   public Collection<Tbl_QLDT_Config> find(Tbl_QLDT_Config _tbl_QLDT_Config, int pageSize, int page);

}//endInterface

