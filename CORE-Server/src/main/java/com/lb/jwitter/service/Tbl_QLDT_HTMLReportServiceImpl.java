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
import com.lb.jwitter.core.Tbl_QLDT_HTMLReport;
import com.lb.jwitter.core.hibernate.Tbl_QLDT_HTMLReportDAO;
import com.lb.jwitter.hibernate.*;
import com.lb.jwitter.util.ConditionReport;

@Service("tbl_QLDT_HTMLReportService")
@Transactional
@WebService(endpointInterface = "com.lb.jwitter.service.Tbl_QLDT_HTMLReportService")
public class Tbl_QLDT_HTMLReportServiceImpl implements Tbl_QLDT_HTMLReportService,Serializable {

   private Log log = LogFactory.getLog(Tbl_QLDT_HTMLReportServiceImpl.class);
   private static final long serialVersionUID = -8740095022264495229L;

   @Autowired
   @Qualifier("tbl_QLDT_HTMLReportDAO")
   private Tbl_QLDT_HTMLReportDAO _tbl_QLDT_HTMLReportDao;

   public final List<Tbl_QLDT_HTMLReport> findAllTbl_QLDT_HTMLReport(int pageSize, int page){
   List<Tbl_QLDT_HTMLReport> result = get_tbl_QLDT_HTMLReportDao().findAll(pageSize, page);
       log.info("Number of user in DB:: "+result.size());
       return result;
   }

   @Transactional(noRollbackFor=IllegalArgumentException.class)
   public final Long createTbl_QLDT_HTMLReport(Tbl_QLDT_HTMLReport obj){
       return _tbl_QLDT_HTMLReportDao.save(obj);
   }

   public final void updateTbl_QLDT_HTMLReport(Tbl_QLDT_HTMLReport obj){
       _tbl_QLDT_HTMLReportDao.update(obj);
   }//end update methode

   public final Tbl_QLDT_HTMLReport getTbl_QLDT_HTMLReport (Long id){
       log.info("Try to retrieve the tbl_QLDT_HTMLReport: "+id);
       return get_tbl_QLDT_HTMLReportDao().get(id);
   }

   public void deleteTbl_QLDT_HTMLReport(Long id){
       log.info("Try to delete the Tbl_QLDT_HTMLReport by Id : "+ id);
       if(true){
	    _tbl_QLDT_HTMLReportDao.delete(id);
       } else {
       	throw new IllegalArgumentException("EmployeeId '"+id+"' does not exists");
       }
   }

   public void deleteListTbl_QLDT_HTMLReport(String[] listId){
       for(String id : listId){
   	    deleteTbl_QLDT_HTMLReport(Long.parseLong(id));
       }
   }

   public List<Tbl_QLDT_HTMLReport> findTbl_QLDT_HTMLReportByCondition(List<ConditionReport> cons,int pageSize,int page){ 
       return _tbl_QLDT_HTMLReportDao.findByCondition(Tbl_QLDT_HTMLReport.class, cons, pageSize, page); 
   } 
 
   public int countTbl_QLDT_HTMLReportByCondition(List<ConditionReport> cons){ 
       return _tbl_QLDT_HTMLReportDao.countByCondition(Tbl_QLDT_HTMLReport.class, cons); 
   } 
 
public List<Object> findColumnTbl_QLDT_HTMLReportByCondition( 
       List<ConditionReport> cons, List<String> columns, int pageSize, int page) { 
   return _tbl_QLDT_HTMLReportDao.findColumnByCondition( 
		Tbl_QLDT_HTMLReport.class, cons, columns, pageSize, page); 
} 
public List<Tbl_QLDT_HTMLReport> queryHQLTbl_QLDT_HTMLReport( 
       String hql, int pageSize, int page) { 
   return _tbl_QLDT_HTMLReportDao.queryHQL( hql, pageSize, page); 
} 
   public final Tbl_QLDT_HTMLReportDAO get_tbl_QLDT_HTMLReportDao() {
   	return _tbl_QLDT_HTMLReportDao;
   }
   public final void set_tbl_QLDT_HTMLReportDao(Tbl_QLDT_HTMLReportDAO obj) {
   	this._tbl_QLDT_HTMLReportDao = obj;
   }

}//endclass

