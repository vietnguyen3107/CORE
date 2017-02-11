package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_DBTable;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_DBTableDAO extends GenericDao<Tbl_DBTable, Long>  {

   List<Tbl_DBTable> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_DBTable> find(Tbl_DBTable _tbl_DBTable, int pageSize, int page);

}//endInterface

