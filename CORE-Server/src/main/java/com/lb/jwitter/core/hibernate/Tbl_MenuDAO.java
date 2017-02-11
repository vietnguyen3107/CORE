package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_Menu;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_MenuDAO extends GenericDao<Tbl_Menu, Long>  {

   List<Tbl_Menu> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_Menu> find(Tbl_Menu _tbl_Menu, int pageSize, int page);

}//endInterface

