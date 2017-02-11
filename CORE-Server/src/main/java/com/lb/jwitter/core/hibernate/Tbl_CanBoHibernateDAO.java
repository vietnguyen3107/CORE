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

import com.lb.jwitter.core.Tbl_CanBo;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_CanBoDAO")
public class Tbl_CanBoHibernateDAO extends HibernateGenericDao<Tbl_CanBo, Long> implements Tbl_CanBoDAO {
   private Log log = LogFactory.getLog(Tbl_CanBoHibernateDAO.class);

   @Autowired
   public Tbl_CanBoHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_CanBo> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_CanBo.class).list(); 
       return getSession().createCriteria(Tbl_CanBo.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_CanBo _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//   	return super.exist(id);
//   }

@Transactional
   public Collection<Tbl_CanBo> find(Tbl_CanBo obj,int pageSize,int page){
   	Collection<Tbl_CanBo> _tbl_CanBos = new ArrayList<Tbl_CanBo>();
   	try {
   		String sql = "select d from tbl_CanBo as d where 1=1 ";
   		sql += " order by d.id DESC ";
   		_tbl_CanBos = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_CanBos;
   }

@Transactional
public List<Tbl_CanBo> findByHQL(String hql,int pageSize,int page){
	List<Tbl_CanBo> _tbl_CanBos = new ArrayList<Tbl_CanBo>();
	try {
		
		_tbl_CanBos =  (List<Tbl_CanBo>) getSession().createQuery(hql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return _tbl_CanBos;
}

}//endclass
