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

import com.lb.jwitter.core.Tbl_QLDT_Config;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_QLDT_ConfigDAO")
public class Tbl_QLDT_ConfigHibernateDAO extends HibernateGenericDao<Tbl_QLDT_Config, Long> implements Tbl_QLDT_ConfigDAO {
   private Log log = LogFactory.getLog(Tbl_QLDT_ConfigHibernateDAO.class);

   @Autowired
   public Tbl_QLDT_ConfigHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_QLDT_Config> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_QLDT_Config.class).list(); 
       return getSession().createCriteria(Tbl_QLDT_Config.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_QLDT_Config _newInstance) {
   	return super.save(_newInstance);
   }

@Transactional
   public Collection<Tbl_QLDT_Config> find(Tbl_QLDT_Config obj,int pageSize,int page){
   	Collection<Tbl_QLDT_Config> _tbl_QLDT_Configs = new ArrayList<Tbl_QLDT_Config>();
   	try {
   		String sql = "select d from tbl_QLDT_Config as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_QLDT_Configs = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_QLDT_Configs;
   }

}//endclass
