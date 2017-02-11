package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_Quyen_Menu;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_Quyen_MenuDAO extends GenericDao<Tbl_Quyen_Menu, Long>  {

   List<Tbl_Quyen_Menu> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_Quyen_Menu> find(Tbl_Quyen_Menu _tbl_Quyen_Menu, int pageSize, int page);
   public List<Tbl_Quyen_Menu> findByNhomQuyen(Long nhomQuyenId, int pageSize, int page); 

}//endInterface

