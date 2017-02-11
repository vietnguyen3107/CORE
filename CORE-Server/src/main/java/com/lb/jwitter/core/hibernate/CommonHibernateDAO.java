package com.lb.jwitter.core.hibernate;

import org.apache.commons.logging.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lb.jwitter.core.Tbl_Menu;
import com.lb.utils.orm.hibernate.HibernateGenericDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Repository("commonDAO")
public class CommonHibernateDAO extends HibernateGenericDao<Object, Long> implements CommonDAO {
   private Log log = LogFactory.getLog(CommonHibernateDAO.class);

   @Autowired
   public CommonHibernateDAO(@Qualifier("sessionFactory")   SessionFactory sessionFactory) {
       super(sessionFactory);
   }

	@SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
	@Transactional
	public List queryWithParams(String sql,Map<String, Object> parameters,int pageSize,int page){
		   	try {
		   		List objs;
                Query query = getSession().createQuery(sql);
                Set<String> set = parameters.keySet();
                Iterator<String> i = set.iterator();
                while(i.hasNext()){
                	String key = i.next();
                	query = query.setParameter(key, parameters.get(key));
                }
                if(pageSize != 0){
                	query = query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize);
                }
		   		objs =  query.list();
		   		return objs;
		   		
		   	} catch (Exception e) {
		   		e.printStackTrace();
		   		
		   		return null;
		   	}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Boolean executeQuery(String sql){
		   	try {
		   		Query q = getSession().createQuery(sql);
		   		int i = q.executeUpdate();
		   		
		   		System.out.println("executeQuery = " + i);
		   		if(i != 0)
		   			return true;
		   		else
		   			return false;

		   		
		   	} catch (Exception e) {
		   		e.printStackTrace();
		   		
		   		return false;
		   	}
	}
	
	  @SuppressWarnings("unchecked")
		@Transactional
		public List createSQLQueryWithParams(String sql,Map<String, Object> parameters,int pageSize,int page){
			   	try {
			   		List objs;
	                Query query = getSession().createSQLQuery(sql);
	                
	                if(parameters != null && parameters.size() > 0){
		                Set<String> set = parameters.keySet();
		                Iterator<String> i = set.iterator();
		                while(i.hasNext()){
		                	String key = i.next();
		                	query = query.setParameter(key, parameters.get(key));
		                }
	                }
	                if(pageSize != 0){
	                	query = query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize);
	                }
			   		objs =  query.list();
			   		return objs;
			   		
			   	} catch (Exception e) {
			   		e.printStackTrace();
			   		
			   		return null;
			   	}
		}
	  
		
	  @SuppressWarnings("unchecked")
		@Transactional
		public List<Map<String,Object>> query_SQL_WithParams_AliasTransformer(String sql,Map<String, Object> parameters,int pageSize,int page){
			   	try {
			   		List<Map<String,Object>>  objs;
	                Query query = getSession().createSQLQuery(sql);
	                
	                if(parameters != null && parameters.size() > 0){
		                Set<String> set = parameters.keySet();
		                Iterator<String> i = set.iterator();
		                while(i.hasNext()){
		                	String key = i.next();
		                	query = query.setParameter(key, parameters.get(key));
		                }
	                }
	                if(pageSize != 0){
	                	query = query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize);
	                }
	                
	                query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE); 
	                
			   		objs =  query.list();
			   		return objs;
			   		
			   	} catch (Exception e) {
			   		e.printStackTrace();
			   		
			   		return null;
			   	}
		}
	    
	    @SuppressWarnings("unchecked")
		@Transactional
		public List<Map<String,Object>>  query_HQL_WithParams_AliasTransformer(String sql,Map<String, Object> parameters,int pageSize,int page){
			   	try {
			   		List<Map<String,Object>>  objs;
	                Query query = getSession().createQuery(sql);
	                Set<String> set = parameters.keySet();
	                Iterator<String> i = set.iterator();
	                while(i.hasNext()){
	                	String key = i.next();
	                	query = query.setParameter(key, parameters.get(key));
	                }
	                if(pageSize != 0){
	                	query = query.setFirstResult(pageSize*(page-1)).setMaxResults(pageSize);
	                }

	                query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE); 
	                
			   		objs =  query.list();
			   		return objs;
			   		
			   	} catch (Exception e) {
			   		e.printStackTrace();
			   		
			   		return null;
			   	}
		}
	    

		public Long countByHql(String hql) {
			try {
				return (Long) getSession().createQuery(hql).uniqueResult();
			} catch (Exception e) {
				e.printStackTrace();
				return new Long(0);
			}

		}
	    
	

}//endclass
