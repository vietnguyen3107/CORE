package com.lb.jwitter.service;

import java.io.Serializable;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lb.jwitter.*;
import com.lb.jwitter.core.hibernate.CommonDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;
import com.lb.jwitter.util.Qresult;

@Service("commonService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.CommonService")
public class CommonServiceImpl implements CommonService,Serializable {

   private Log log = LogFactory.getLog(CommonServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;


   @Autowired
   @Qualifier("commonDAO")
   private CommonDAO _CommonDAO;

	public CommonDAO get_CommonDAO() {
	return _CommonDAO;
}

public void set_CommonDAO(CommonDAO _CommonDAO) {
	this._CommonDAO = _CommonDAO;
}

	public List<Qresult> query(String sql,int columnNo, int pageSize,int page){
		 List<Qresult> result = new ArrayList<Qresult>();
		 List<Object> obj = _CommonDAO.query(sql, pageSize, page);
		 for (Iterator it = obj.iterator(); it.hasNext();) {
			  Object[] row = (Object[]) it.next();
			  List<Object> objs = new ArrayList<Object>();
			  
			  for(int i = 0; i < columnNo; i++){
				  
				  
					 Object nhid = row[i];
					 objs.add(nhid);
			  }
			  Qresult q = new Qresult();
			  q.setObjs(objs);

			  result.add(q);
			
		}

		 
		return result;
	}
    
    public List<Qresult> queryWithParams(String sql,int columnNo,String[] paramNames,String[] paramVals, int pageSize,int page){
		 List<Qresult> result = new ArrayList<Qresult>();
		 Map<String,Object> parameters = new HashMap<String, Object>();
		 if(paramNames != null && paramVals != null){
			 for(int i=0; i < paramNames.length; i++){
				 parameters.put(paramNames[i], paramVals[i]);
			 }
		 }
		 
		 List<Object> obj = _CommonDAO.queryWithParams(sql,parameters, pageSize, page);
		 for (Iterator it = obj.iterator(); it.hasNext();) {
			  Object[] row = (Object[]) it.next();
			  List<Object> objs = new ArrayList<Object>();
			  
			  for(int i = 0; i < columnNo; i++){
					 Object nhid = row[i];
					 objs.add(nhid);
			  }
			  Qresult q = new Qresult();
			  q.setObjs(objs);

			  result.add(q);
			
		}

		 
		return result;
	}

	
	public Boolean executeQuery(String sql){
		return _CommonDAO.executeQuery(sql);
	}
	

	public List<Qresult> createSQLQueryWithParams(String sql,int columnNo, String[] paramNames,String[] paramVals,int pageSize,int page){
		List<Qresult> result = new ArrayList<Qresult>();
		 Map<String,Object> parameters = new HashMap<String, Object>();
		 
		 if(paramNames != null && paramVals != null){
			 for(int i=0; i < paramNames.length; i++){
				 parameters.put(paramNames[i], paramVals[i]);
			 }
		 }
		 List<Object> obj = _CommonDAO.createSQLQueryWithParams(sql,parameters, 0, 0);
		 for (Iterator it = obj.iterator(); it.hasNext();) {
			  Object[] row = (Object[]) it.next();
			  List<Object> objs = new ArrayList<Object>();
			  
			  for(int i = 0; i < columnNo; i++){

					 Object nhid = row[i];
					 objs.add(nhid);
			  }
			  Qresult q = new Qresult();
			  q.setObjs(objs);

			  result.add(q);
			
		}

		 
		return result;
	}

	public List<Qresult> query_SQL_WithParams_AliasTransformer
			(String sql, List<String> paramNames, List<Object> paramVals,int pageSize,int page){
		
		List<Qresult> result = new ArrayList<Qresult>();
		 Map<String,Object> parameters = new HashMap<String, Object>();
		 
		 if(paramNames != null && paramVals != null){
			 for(int i=0; i < paramNames.size(); i++){
				 parameters.put(paramNames.get(i), paramVals.get(i));
			 }
		 }
		 List<Map<String, Object>> obj 
		 		= _CommonDAO.query_SQL_WithParams_AliasTransformer(sql,parameters, 0, 0);
		
		 
		 System.out.println("query with alias: obj.size = " + obj.size());
		 for( Map o :obj){
			 Qresult q = new Qresult();
			 q.setObjs(new ArrayList<Object>());
			 
			 q.setObjAlias(o);
			 q.getObjs().addAll(o.values());
			 result.add(q);
		 }
		 
		return result;
	}
	
    public List<Qresult> query_HQL_WithParams_AliasTransformer
    		(String sql,List<String> paramNames,List<Object> paramVals, int pageSize,int page){
    	
		 List<Qresult> result = new ArrayList<Qresult>();
		 Map<String,Object> parameters = new HashMap<String, Object>();
		 
		 if(paramNames != null && paramVals != null){
			 for(int i=0; i < paramNames.size(); i++){
				 parameters.put(paramNames.get(i), paramVals.get(i));
			 }
		 }
		 
		 List<Map<String, Object>> obj 
		 		= _CommonDAO.query_HQL_WithParams_AliasTransformer(sql,parameters, pageSize, page);

		 for( Map o :obj){
			 Qresult q = new Qresult();
			 q.setObjAlias(o);
			 result.add(q);
		 }
		 
		return result;
	}
    

	public Long countByHql(String hql) {
		return _CommonDAO.countByHql(hql);

	}
	
}//endclass

