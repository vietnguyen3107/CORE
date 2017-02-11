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

import com.lb.jwitter.core.Tbl_Menu;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

@Repository("tbl_MenuDAO")
public class Tbl_MenuHibernateDAO extends HibernateGenericDao<Tbl_Menu, Long> implements Tbl_MenuDAO {
   private Log log = LogFactory.getLog(Tbl_MenuHibernateDAO.class);

   @Autowired
   public Tbl_MenuHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

   @SuppressWarnings("unchecked")
@Transactional
   public final List<Tbl_Menu> findAll(int pageSize, int page) {
       if( pageSize == 0) return getSession().createCriteria(Tbl_Menu.class).list(); 
       return getSession().createCriteria(Tbl_Menu.class).setFirstResult(pageSize * (page-1)).setMaxResults(pageSize).list();
   }
   
@Transactional
   public final Long save(Tbl_Menu _newInstance) {
   	return super.save(_newInstance);
   }

//@Transactional
//   public final boolean exists(Long id) {
//   	return super.exist(id);
//   }

@Transactional
   public List query(String sql,int pageSize,int page){
	   	try {
	   		List objs;
	   		if(pageSize == 0){

		   		objs =  getSession().createQuery(sql).list();
		   		
	   		}else {

		   		objs =  getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
		   		
	   		}
	   		return objs;
	   		
	   	} catch (Exception e) {
	   		e.printStackTrace();
	   		
	   		return null;
	   	}
   }

   
@Transactional
   public Collection<Tbl_Menu> find(Tbl_Menu obj,int pageSize,int page){
   	Collection<Tbl_Menu> _tbl_Menus = new ArrayList<Tbl_Menu>();
   	try {
   		String sql = "select d from tbl_Menu as d where 1=1 ";
   		
   		
   sql += " and d.id = " + obj.getId() + " ";
   sql += " and d.Url = " + obj.getUrl() + " ";
   sql += " and d.Ten = " + obj.getTen() + " ";
   sql += " and d.menuCha = " + obj.getMenuCha() + " ";
   sql += " and d.Hinh = " + obj.getHinh() + " ";
   		sql += " order by d.id DESC ";
   		
   		_tbl_Menus = getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	return _tbl_Menus;
   }

}//endclass
