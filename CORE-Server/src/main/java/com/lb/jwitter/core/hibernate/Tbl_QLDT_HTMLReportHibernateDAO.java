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

import com.lb.jwitter.core.Tbl_QLDT_HTMLReport;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_QLDT_HTMLReportDAO")
public class Tbl_QLDT_HTMLReportHibernateDAO extends HibernateGenericDao<Tbl_QLDT_HTMLReport, Long> implements Tbl_QLDT_HTMLReportDAO {
   private Log log = LogFactory.getLog(Tbl_QLDT_HTMLReportHibernateDAO.class);

   @Autowired
   public Tbl_QLDT_HTMLReportHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_QLDT_HTMLReport> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_QLDT_HTMLReport.class).list(); 
       return getSession().createCriteria(Tbl_QLDT_HTMLReport.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_QLDT_HTMLReport _newInstance) {
   	return super.save(_newInstance);
   }

@Transactional
   public Collection<Tbl_QLDT_HTMLReport> find(Tbl_QLDT_HTMLReport obj,int pageSize,int page){
   	Collection<Tbl_QLDT_HTMLReport> _tbl_QLDT_HTMLReports = new ArrayList<Tbl_QLDT_HTMLReport>();
   	try {
   		String sql = "select d from tbl_QLDT_HTMLReport as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_QLDT_HTMLReports = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_QLDT_HTMLReports;
   }

 @Transactional 
 public List<Tbl_QLDT_HTMLReport> queryHQL(String hql,int pageSize,int page){ 
        List<Tbl_QLDT_HTMLReport> _tbls = new ArrayList<Tbl_QLDT_HTMLReport>(); 
        try { 
            if(pageSize != 0 && page != 0) 
                _tbls = getSession().createQuery(hql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list(); 
            else 
                _tbls = getSession().createQuery(hql).list(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return _tbls; 
 } 
}//endclass
