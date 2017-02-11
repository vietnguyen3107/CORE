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
import com.lb.jwitter.core.Tbl_QLDTLT_OptionGroup;
import com.lb.jwitter.util.ConditionReport;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_QLDTLT_OptionGroupDAO")
public class Tbl_QLDTLT_OptionGroupHibernateDAO extends HibernateGenericDao<Tbl_QLDTLT_OptionGroup, Long> implements Tbl_QLDTLT_OptionGroupDAO {
   private Log log = LogFactory.getLog(Tbl_QLDTLT_OptionGroupHibernateDAO.class);

   @Autowired
   public Tbl_QLDTLT_OptionGroupHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_QLDTLT_OptionGroup> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_QLDTLT_OptionGroup.class).list(); 
       return getSession().createCriteria(Tbl_QLDTLT_OptionGroup.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_QLDTLT_OptionGroup _newInstance) {
   	return super.save(_newInstance);
   }

@Transactional
   public List<Tbl_QLDTLT_OptionGroup> find(Tbl_QLDTLT_OptionGroup obj,int pageSize,int page){
   	List<Tbl_QLDTLT_OptionGroup> _tbl_QLDTLT_OptionGroups = new ArrayList<Tbl_QLDTLT_OptionGroup>();
   	try {
   		String sql = "select d from tbl_QLDTLT_OptionGroup as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_QLDTLT_OptionGroups = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_QLDTLT_OptionGroups;
   }

 @Transactional 
 public List<Tbl_QLDTLT_OptionGroup> queryHQL(String hql,int pageSize,int page){ 
        List<Tbl_QLDTLT_OptionGroup> _tbls = new ArrayList<Tbl_QLDTLT_OptionGroup>(); 
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
