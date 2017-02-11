package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_Quyen_NhomQuyen;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_Quyen_NhomQuyenDAO extends GenericDao<Tbl_Quyen_NhomQuyen, Long>  {

   List<Tbl_Quyen_NhomQuyen> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_Quyen_NhomQuyen> find(Tbl_Quyen_NhomQuyen _tbl_Quyen_NhomQuyen, int pageSize, int page);

}//endInterface

