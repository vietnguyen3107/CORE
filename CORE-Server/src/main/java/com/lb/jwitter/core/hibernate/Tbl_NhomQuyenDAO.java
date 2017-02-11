package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_NhomQuyen;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_NhomQuyenDAO extends GenericDao<Tbl_NhomQuyen, Long>  {

   List<Tbl_NhomQuyen> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_NhomQuyen> find(Tbl_NhomQuyen _tbl_NhomQuyen, int pageSize, int page);

}//endInterface

