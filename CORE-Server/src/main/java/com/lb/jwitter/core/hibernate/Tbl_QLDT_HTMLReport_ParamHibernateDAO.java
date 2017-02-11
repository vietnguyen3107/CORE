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

import com.lb.jwitter.core.Tbl_QLDT_HTMLReport_Param;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_QLDT_HTMLReport_ParamDAO")
public class Tbl_QLDT_HTMLReport_ParamHibernateDAO extends HibernateGenericDao<Tbl_QLDT_HTMLReport_Param, Long> implements Tbl_QLDT_HTMLReport_ParamDAO {
   private Log log = LogFactory.getLog(Tbl_QLDT_HTMLReport_ParamHibernateDAO.class);

   @Autowired
   public Tbl_QLDT_HTMLReport_ParamHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_QLDT_HTMLReport_Param> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_QLDT_HTMLReport_Param.class).list(); 
       return getSession().createCriteria(Tbl_QLDT_HTMLReport_Param.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_QLDT_HTMLReport_Param _newInstance) {
   	return super.save(_newInstance);
   }

@Transactional
   public Collection<Tbl_QLDT_HTMLReport_Param> find(Tbl_QLDT_HTMLReport_Param obj,int pageSize,int page){
   	Collection<Tbl_QLDT_HTMLReport_Param> _tbl_QLDT_HTMLReport_Params = new ArrayList<Tbl_QLDT_HTMLReport_Param>();
   	try {
   		String sql = "select d from tbl_QLDT_HTMLReport_Param as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_QLDT_HTMLReport_Params = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_QLDT_HTMLReport_Params;
   }

 @Transactional 
 public List<Tbl_QLDT_HTMLReport_Param> queryHQL(String hql,int pageSize,int page){ 
        List<Tbl_QLDT_HTMLReport_Param> _tbls = new ArrayList<Tbl_QLDT_HTMLReport_Param>(); 
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
