package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_QLDT_Config;
import com.lb.jwitter.core.Tbl_QLDT_Log;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_QLDT_LogDAO extends GenericDao<Tbl_QLDT_Log, Long>  {

   List<Tbl_QLDT_Log> findAll(int pageSize,int page);
   
   
   public Collection<Tbl_QLDT_Log> find(Tbl_QLDT_Log _tbl_QLDT_Log, int pageSize, int page);

}//endInterface

