package com.lb.jwitter.core.hibernate;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

import com.lb.jwitter.core.Tbl_Menu;
import com.lb.utils.orm.hibernate.GenericDao;

import java.util.Map;

public interface CommonDAO extends GenericDao<Object, Long>  {

   public List query(String sql, int pageSize, int page);
   
   public List queryWithParams(String sql, Map<String, Object> parameters, int pageSize, int page);
   
   public Boolean executeQuery(String sql);
   public List createSQLQueryWithParams
		(String sql,Map<String, Object> parameters,int pageSize,int page);

   public List<Map<String,Object>> query_SQL_WithParams_AliasTransformer
		(String sql,Map<String, Object> parameters,int pageSize,int page);
   public List<Map<String,Object>> query_HQL_WithParams_AliasTransformer
   		(String sql, Map<String, Object> parameters, int pageSize, int page);
   
   public Long countByHql(String hql);

}//endInterface

