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

import com.lb.jwitter.core.Tbl_NhomQuyen;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_NhomQuyenDAO")
public class Tbl_NhomQuyenHibernateDAO extends HibernateGenericDao<Tbl_NhomQuyen, Long> implements Tbl_NhomQuyenDAO {
   private Log log = LogFactory.getLog(Tbl_NhomQuyenHibernateDAO.class);

   @Autowired
   public Tbl_NhomQuyenHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_NhomQuyen> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_NhomQuyen.class).list(); 
       return getSession().createCriteria(Tbl_NhomQuyen.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_NhomQuyen _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//   	return super.exist(id);
//   }

@Transactional
   public Collection<Tbl_NhomQuyen> find(Tbl_NhomQuyen obj,int pageSize,int page){
   	Collection<Tbl_NhomQuyen> _tbl_NhomQuyens = new ArrayList<Tbl_NhomQuyen>();
   	try {
   		String sql = "select d from tbl_NhomQuyen as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_NhomQuyens = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_NhomQuyens;
   }

}//endclass
