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

import com.lb.jwitter.core.Tbl_DBTable;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_DBTableDAO")
public class Tbl_DBTableHibernateDAO extends HibernateGenericDao<Tbl_DBTable, Long> implements Tbl_DBTableDAO {
   private Log log = LogFactory.getLog(Tbl_DBTableHibernateDAO.class);

   @Autowired
   public Tbl_DBTableHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_DBTable> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_DBTable.class).list(); 
       return getSession().createCriteria(Tbl_DBTable.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_DBTable _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//   	return super.exist(id);
//   }

@Transactional
   public Collection<Tbl_DBTable> find(Tbl_DBTable obj,int pageSize,int page){
   	Collection<Tbl_DBTable> _tbl_DBTables = new ArrayList<Tbl_DBTable>();
   	try {
   		String sql = "select d from tbl_DBTable as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_DBTables = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_DBTables;
   }

}//endclass
