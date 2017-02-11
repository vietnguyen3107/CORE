package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_Quyen;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_QuyenDAO extends GenericDao<Tbl_Quyen, Long>  {

   List<Tbl_Quyen> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_Quyen> find(Tbl_Quyen _tbl_Quyen, int pageSize, int page);

}//endInterface

