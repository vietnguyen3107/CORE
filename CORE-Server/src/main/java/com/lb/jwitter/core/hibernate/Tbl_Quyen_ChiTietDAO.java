package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_Quyen_ChiTiet;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_Quyen_ChiTietDAO extends GenericDao<Tbl_Quyen_ChiTiet, Long>  {

   List<Tbl_Quyen_ChiTiet> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_Quyen_ChiTiet> find(Tbl_Quyen_ChiTiet _tbl_Quyen_ChiTiet, int pageSize, int page);

   public boolean checkRight(Long nhomQuyenId, String tableName, String right);
}//endInterface

