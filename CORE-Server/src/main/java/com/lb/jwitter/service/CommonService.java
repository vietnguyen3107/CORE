package com.lb.jwitter.service;

import java.sql.Connection;
import java.util.List;
import javax.jws.WebService;

import com.lb.jwitter.core.Tbl_Menu;
import com.lb.jwitter.util.ConditionReport;
import com.lb.jwitter.util.Qresult;

import java.util.Map;

@WebService
public interface CommonService {


public List<Qresult> query(String sql,int columnNo, int pageSize,int page);
public List<Qresult> queryWithParams(String sql,int columnNo,String[] paramNames,String[] paramVals, int pageSize,int page);
public Boolean executeQuery(String sql);

public List<Qresult> createSQLQueryWithParams
		(String sql,
		 int columnNo, 
		 String[] paramNames,
		 String[] paramVals,
		 int pageSize,
		 int page);

public List<Qresult> query_SQL_WithParams_AliasTransformer
		(String sql,
		 List<String> paramNames,
		 List<Object> paramVals,
		 int pageSize,
		 int page);

public List<Qresult> query_HQL_WithParams_AliasTransformer
		(String sql,
		 List<String> paramNames,
		 List<Object> paramVals, 
		 int pageSize,
		 int page);


public Long countByHql(String hql); 


}//endclass

