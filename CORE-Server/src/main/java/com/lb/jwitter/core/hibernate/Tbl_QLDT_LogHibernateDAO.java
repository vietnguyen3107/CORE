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

import com.lb.jwitter.core.Tbl_QLDT_Log;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_QLDT_LogDAO")
public class Tbl_QLDT_LogHibernateDAO extends HibernateGenericDao<Tbl_QLDT_Log, Long> implements Tbl_QLDT_LogDAO {
   private Log log = LogFactory.getLog(Tbl_QLDT_LogHibernateDAO.class);

   @Autowired
   public Tbl_QLDT_LogHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_QLDT_Log> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_QLDT_Log.class).list(); 
       return getSession().createCriteria(Tbl_QLDT_Log.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_QLDT_Log _newInstance) {
   	return super.save(_newInstance);
   }

@Transactional
   public Collection<Tbl_QLDT_Log> find(Tbl_QLDT_Log obj,int pageSize,int page){
   	Collection<Tbl_QLDT_Log> _tbl_QLDT_Logs = new ArrayList<Tbl_QLDT_Log>();
   	try {
   		String sql = "select d from tbl_QLDT_Log as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_QLDT_Logs = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_QLDT_Logs;
   }

}//endclass
