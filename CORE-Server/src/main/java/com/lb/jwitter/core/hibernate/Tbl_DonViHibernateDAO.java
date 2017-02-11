package com.lb.jwitter.core.hibernate;

import org.apache.commons.logging.Log;
import java.util.ArrayList;
import java.util.List;
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
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import com.lb.jwitter.core.Tbl_DonVi;
import com.lb.jwitter.util.ConditionReport;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_DonViDAO")
public class Tbl_DonViHibernateDAO extends HibernateGenericDao<Tbl_DonVi, Long> implements Tbl_DonViDAO {
   private Log log = LogFactory.getLog(Tbl_DonViHibernateDAO.class);

   @Autowired
   public Tbl_DonViHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_DonVi> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_DonVi.class).list(); 
       return getSession().createCriteria(Tbl_DonVi.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_DonVi _newInstance) {
   	return super.save(_newInstance);
   }

@Transactional
   public List<Tbl_DonVi> find(Tbl_DonVi obj,int pageSize,int page){
   	List<Tbl_DonVi> _tbl_DonVis = new ArrayList<Tbl_DonVi>();
   	try {
   		String sql = "select d from tbl_DonVi as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_DonVis = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_DonVis;
   }

 @Transactional 
 public List<Tbl_DonVi> queryHQL(String hql,int pageSize,int page){ 
        List<Tbl_DonVi> _tbls = new ArrayList<Tbl_DonVi>(); 
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
