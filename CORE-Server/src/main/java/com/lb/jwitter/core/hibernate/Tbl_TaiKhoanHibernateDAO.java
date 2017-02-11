package com.lb.jwitter.core.hibernate;

import org.apache.commons.logging.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lb.jwitter.core.Tbl_TaiKhoan;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_TaiKhoanDAO")
public class Tbl_TaiKhoanHibernateDAO extends HibernateGenericDao<Tbl_TaiKhoan, Long> implements Tbl_TaiKhoanDAO {
   private Log log = LogFactory.getLog(Tbl_TaiKhoanHibernateDAO.class);

   @Autowired
   public Tbl_TaiKhoanHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_TaiKhoan> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_TaiKhoan.class).list(); 
       return getSession().createCriteria(Tbl_TaiKhoan.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_TaiKhoan _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//   	return super.exist(id);
//   }

@Transactional
   public Collection<Tbl_TaiKhoan> find(Tbl_TaiKhoan obj,int pageSize,int page){
   	Collection<Tbl_TaiKhoan> _tbl_TaiKhoans = new ArrayList<Tbl_TaiKhoan>();
   	try {
   		String sql = "select d from tbl_TaiKhoan as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_TaiKhoans = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_TaiKhoans;
   }

}//endclass
