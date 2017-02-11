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

import com.lb.jwitter.core.Tbl_Quyen;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_QuyenDAO")
public class Tbl_QuyenHibernateDAO extends HibernateGenericDao<Tbl_Quyen, Long> implements Tbl_QuyenDAO {
   private Log log = LogFactory.getLog(Tbl_QuyenHibernateDAO.class);

   @Autowired
   public Tbl_QuyenHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_Quyen> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_Quyen.class).list(); 
       return getSession().createCriteria(Tbl_Quyen.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_Quyen _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//   	return super.exist(id);
//   }

@Transactional
   public Collection<Tbl_Quyen> find(Tbl_Quyen obj,int pageSize,int page){
   	Collection<Tbl_Quyen> _tbl_Quyens = new ArrayList<Tbl_Quyen>();
   	try {
   		String sql = "select d from tbl_Quyen as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_Quyens = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_Quyens;
   }

}//endclass
