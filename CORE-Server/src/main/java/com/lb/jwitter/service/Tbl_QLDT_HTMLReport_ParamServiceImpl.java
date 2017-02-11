package com.lb.jwitter.service;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lb.jwitter.*;
import com.lb.jwitter.core.Tbl_QLDT_HTMLReport_Param;
import com.lb.jwitter.core.hibernate.Tbl_QLDT_HTMLReportDAO;
import com.lb.jwitter.core.hibernate.Tbl_QLDT_HTMLReport_ParamDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_QLDT_HTMLReport_ParamService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_QLDT_HTMLReport_ParamService")
public class Tbl_QLDT_HTMLReport_ParamServiceImpl implements Tbl_QLDT_HTMLReport_ParamService,Serializable {

   private Log log = LogFactory.getLog(Tbl_QLDT_HTMLReport_ParamServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_QLDT_HTMLReport_ParamDAO")
   private Tbl_QLDT_HTMLReport_ParamDAO _tbl_QLDT_HTMLReport_ParamDao;

   @Autowired
   @Qualifier("tbl_QLDT_HTMLReportDAO")
   private Tbl_QLDT_HTMLReportDAO _tbl_QLDT_HTMLReportDao;

   public final List<Tbl_QLDT_HTMLReport_Param> findAllTbl_QLDT_HTMLReport_Param(int pageSize, int page){
   List<Tbl_QLDT_HTMLReport_Param> result = get_tbl_QLDT_HTMLReport_ParamDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createTbl_QLDT_HTMLReport_Param(Tbl_QLDT_HTMLReport_Param obj){
       return _tbl_QLDT_HTMLReport_ParamDao.save(obj);
   }

   public final void updateTbl_QLDT_HTMLReport_Param(Tbl_QLDT_HTMLReport_Param obj){
       _tbl_QLDT_HTMLReport_ParamDao.update(obj);
   }//end update methode

   public final Tbl_QLDT_HTMLReport_Param getTbl_QLDT_HTMLReport_Param (Long id){
       log.info("Try to retrieve the tbl_QLDT_HTMLReport_Param: "+id);
       return get_tbl_QLDT_HTMLReport_ParamDao().get(id);
   }

   public void deleteTbl_QLDT_HTMLReport_Param(Long id){
       log.info("Try to delete the Tbl_QLDT_HTMLReport_Param by Id : "+ id);
       if(true){
	    _tbl_QLDT_HTMLReport_ParamDao.delete(id);
       } else {
       	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       }
   }

   public void deleteListTbl_QLDT_HTMLReport_Param(String[] listId){
       for(String id : listId){
   	    deleteTbl_QLDT_HTMLReport_Param(Long.parseLong(id));
       }
   }

   public List<Tbl_QLDT_HTMLReport_Param> findTbl_QLDT_HTMLReport_ParamByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_QLDT_HTMLReport_ParamDao.findByCondition(Tbl_QLDT_HTMLReport_Param.class, cons, pageSize, page); 
   } 
 
   public int countTbl_QLDT_HTMLReport_ParamByCondition(List<ConditionReport> cons){ 
       return _tbl_QLDT_HTMLReport_ParamDao.countByCondition(Tbl_QLDT_HTMLReport_Param.class, cons); 
   } 
 
public List<Object> findColumnTbl_QLDT_HTMLReport_ParamByCondition( 
       List<ConditionReport> cons, List<String> columns, int pageSize, int page) { 
   return _tbl_QLDT_HTMLReport_ParamDao.findColumnByCondition( 
		Tbl_QLDT_HTMLReport_Param.class, cons, columns, pageSize, page); 
} 
public List<Tbl_QLDT_HTMLReport_Param> queryHQLTbl_QLDT_HTMLReport_Param( 
       String hql, int pageSize, int page) { 
   return _tbl_QLDT_HTMLReport_ParamDao.queryHQL( hql, pageSize, page); 
} 
   public final Tbl_QLDT_HTMLReport_ParamDAO get_tbl_QLDT_HTMLReport_ParamDao() {
   	return _tbl_QLDT_HTMLReport_ParamDao;
   }
   public final void set_tbl_QLDT_HTMLReport_ParamDao(Tbl_QLDT_HTMLReport_ParamDAO obj) {
   	this._tbl_QLDT_HTMLReport_ParamDao = obj;
   }

   public Tbl_QLDT_HTMLReportDAO get_tbl_QLDT_HTMLReportDao() {
       return _tbl_QLDT_HTMLReportDao;
   }
   public void set_tbl_QLDT_HTMLReportDao(Tbl_QLDT_HTMLReportDAO _tbl_QLDT_HTMLReportDao) {
       this._tbl_QLDT_HTMLReportDao = _tbl_QLDT_HTMLReportDao;
   }

}//endclass

