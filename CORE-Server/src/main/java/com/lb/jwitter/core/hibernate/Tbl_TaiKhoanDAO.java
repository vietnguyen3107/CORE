package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_TaiKhoan;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_TaiKhoanDAO extends GenericDao<Tbl_TaiKhoan, Long>  {

   List<Tbl_TaiKhoan> findAll(int pageSize,int page);
   
//   boolean exists(Long id);
   
   public Collection<Tbl_TaiKhoan> find(Tbl_TaiKhoan _tbl_TaiKhoan, int pageSize, int page);

}//endInterface

