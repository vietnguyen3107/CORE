package com.lb.jwitter.core.hibernate;

import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_CanBo;
import com.lb.utils.orm.hibernate.GenericDao;

public interface Tbl_CanBoDAO extends GenericDao<Tbl_CanBo, Long>  {

   List<Tbl_CanBo> findAll(int pageSize,int page);
   
//   boolean exists(Long id);

   public Collection<Tbl_CanBo> find(Tbl_CanBo _tbl_CanBo, int pageSize, int page);
   public List<Tbl_CanBo> findByHQL(String hql, int pageSize, int page);

}//endInterface

